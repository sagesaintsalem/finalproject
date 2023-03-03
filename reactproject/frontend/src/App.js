import React from 'react';
import {BrowserRouter as Router} from 'react-router-dom';
import Homepage from './containers/Homepage';


function App(){
  return(
    <Router>
      <Homepage/>
    </Router>
  )
}

export default App;