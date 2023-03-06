import React, {useState, useEffect} from 'react';
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import CharCreation from './containers/CharacterCreation/CharCreation';
import Homepage from './containers/Homepage';
import Sail from './containers/Sail';
import Intro from './containers/Intro';
import South from './containers/South/South';
import North from './containers/North/North';
import East from './containers/East/East';
import West from './containers/West/West';
import Request from "./helpers/request";


function App(){

  const [player, setPlayer] = useState({})
  const [npcs, setNpcs] = useState([])
  const [enemies, setEnemies] = useState([])
  const [ships, setShips] = useState([])
  const [raids, setRaids] = useState([])
  const [kraken, setKraken] = useState([])
  
  useEffect(()=>{
      const request = new Request();
      
  
      const npcPromise = request.get('/api/npcs');
      const enemyPromise = request.get('/api/enemies');
      const shipPromise = request.get('/api/ships');
      const raidPromise = request.get('/api/raids');
      const krakenPromise = request.get('/api/bosses');
  
      Promise.all([npcPromise, enemyPromise, shipPromise, raidPromise, krakenPromise])
          .then((data) => {
              setNpcs(data[0])
              setEnemies(data[1])
              setShips(data[2])
              setRaids(data[3])
              setKraken(data[4])
          })
  }, [])

  return(
    <Router>
      <Routes>
      <Route path='/' element={<Homepage />} />
      <Route path='/charcreation' element={<CharCreation onCreate={setPlayer}/>} />
      <Route path='/sail' element={<Sail />} />
      <Route path='/intro' element={<Intro player={player}/>} />
      <Route path='/south' element={<South raids={raids} ships={ships} />} />
      <Route path='/north' element={<North enemies={enemies} ships={ships} npcs={npcs} player={player}/>} />
      <Route path='/east' element={<East enemies={enemies} ships={ships} npcs={npcs} player={player} />} />
      <Route path='/west' element={<West raids={raids} ships={ships}/>} />
      </Routes>
    </Router>
  )
}

export default App;