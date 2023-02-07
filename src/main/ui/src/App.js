import React, {Component} from 'react';
import './bootstrap.css'
import './App.css';
import MyDojoApp from './components/MyDojoApp';


class App extends Component {
  render() {
    return (
      <div className="App">
         <MyDojoApp/>
      </div>
    )
  }
}
export default App