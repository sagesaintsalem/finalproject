import React from 'react';
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import CharCreation from './containers/CharacterCreation/CharCreation';
import Homepage from './containers/Homepage';
import Sail from './containers/Sail';
import Intro from './containers/Intro';
import South from './containers/South/South';
import North from './containers/North/North';
import East from './containers/East/East';
import West from './containers/West/West';


function App(){
  return(
    <Router>
      <Routes>
      <Route path='/' element={<Homepage />} />
      <Route path='/charcreation' element={<CharCreation/>} />
      <Route path='/sail' element={<Sail />} />
      <Route path='/intro' element={<Intro />} />
      <Route path='/south' element={<South />} />
      <Route path='/north' element={<North />} />
      <Route path='/east' element={<East />} />
      <Route path='/west' element={<West />} />
      </Routes>
    </Router>
  )
}

export default App;