import { BrowserRouter, Switch, Route } from 'react-router-dom';
import React from 'react';
import signup from './signup'
import Login from './Login';
import Feed from './Feed';
import './App.css';
const App = () => {
    return(
        <div>
          
          <BrowserRouter>
          <div className="auth-wrapper">
          <div className="auth-inner">
            <Switch>

              <Route exact path ='/' component={Login}/>
              <Route exact path ='/login' component={Login}/>
              <Route exact path ='/signup' component={signup}/>
              <Route exact path ='/Feed' component={Feed}/>
            </Switch>
            </div>
            </div>
          </BrowserRouter>  
        </div>
    )
}
export default App;