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
import Boss from './containers/Boss'
import Request from "./helpers/request";
import NavBar from './containers/NavBar';


function App(){

  const [player, setPlayer] = useState({})
  const [npcs, setNpcs] = useState([])
  const [enemies, setEnemies] = useState([])
  const [ships, setShips] = useState([])
  const [raids, setRaids] = useState([])
  const [kraken, setKraken] = useState([])
  const [northVisited, setNorthVisited] = useState(false)
  const [southVisited, setSouthVisited] = useState(false)
  const [eastVisited, setEastVisited] = useState(false)
  const [westVisited, setWestVisited] = useState(false)
  const [allVisited, setAllVisited] = useState(false)
  
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

  useEffect(()=>{
    visited();
  }, [northVisited, southVisited, eastVisited, westVisited])

  const updateShip = (updatedShip) => {
    let updatedShips = []
    ships.forEach(ship => {
      if (ship.id === updatedShip.id){
        updatedShips.push(updatedShip)
      } else {
        updatedShips.push(ship)
      }
    })
    setShips(updatedShips);
  }


  const updateNPC = (updatedNpc) => {
    let updatedNpcs = []
    npcs.forEach(npc => {
      if (npc.id === updatedNpc.id){
        updatedNpcs.push(updatedNpc)
      } else {
        updatedNpcs.push(npc)
      }
    })
    setNpcs(updatedNpcs);
  }

  const updateEnemy = (updatedEnemy) => {
    let updatedEnemies = []
    enemies.forEach(enemy => {
      if (enemy.id === updatedEnemy.id){
        updatedEnemies.push(updatedEnemy)
      } else {
        updatedEnemies.push(enemy)
      }
    })
    setEnemies(updatedEnemies);
  }

  const updateShips = (updatedShips)=>{
    setShips(updatedShips)
  }

  const updateRaid = (updatedRaid) => {
    let updatedRaids = []
    raids.forEach(raid => {
      if (raid.id === updatedRaid.id){
        updatedRaids.push(updatedRaid)
      } else {
        updatedRaids.push(raid)
      }
    })
    setRaids(updatedRaids);
  }

  // Need a player update function here
  const updatePlayer = (updatedPlayer) => {
    setPlayer(updatedPlayer);
  }
  

  // Need a kraken update function here
  const updateKraken = (updatedKraken) => {
    setKraken(updatedKraken);
  }

  const visited = () => {
    if(northVisited === true && southVisited === true && eastVisited === true && westVisited === true){
      setAllVisited(true)}
  }


  return(
    <Router>
      {ships.length > 0 ?<NavBar player={player} ships={ships}/> : null}
      <Routes>
      <Route path='/' element={<Homepage />} />
      <Route path='/charcreation' element={<CharCreation onCreate={setPlayer}/>} />
      <Route path='/sail' element={<Sail allVisited={allVisited} />} />
      <Route path='/intro' element={<Intro player={player}/>} />
      <Route path='/south' element={<South raids={raids} updateRaid={updateRaid} ships={ships} updateShip={updateShip} setSouthVisited={setSouthVisited} />} />
      <Route path='/north' element={<North enemies={enemies} updateEnemy={updateEnemy} npcs={npcs} updateNPC={updateNPC} player={player} updatePlayer={updatePlayer} setNorthVisited={setNorthVisited}/>} />
      {ships ? <Route path='/east' element={<East ships={ships} updateShip={updateShip} updateShips={updateShips} setEastVisited={setEastVisited} />} /> : null}
      <Route path='/west' element={<West raids={raids} updateRaid={updateRaid} ships={ships} updateShip={updateShip} setWestVisited={setWestVisited} />} />
      <Route path='/boss' element={<Boss ships={ships} updateShip={updateShip} npcs={npcs} updateNPC={updateNPC} kraken={kraken} updateKraken={updateKraken} player={player} updatePlayer={updatePlayer} />} />
      </Routes>
    </Router>
  )
}

export default App;