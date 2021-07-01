import './App.css';
import React, {useEffect, useState} from "react";
import axios from "axios";

function App() {
  let [entities, setEntities] = useState([]);

  useEffect(() => {

  }, []);

  function fetchAllEntities() {
    axios.get("http://localhost:8085" + "/entity").then(({data}) => {
          setEntities(data);
    });
  }

  return (
    <div className="App">
      <header className="App-header">
          <button className="myBtn" onClick={fetchAllEntities()}/>
      </header>
    </div>
  );
}

export default App;