import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Login from './components/Login';
import Register from './components/Register';
import Navbar from './components/Navbar'; 
import './App.css'
import AddEmployees from './components/AddEmployees';
import Employee from './components/Employee';

function App() {
  return (
    <Router>
      <Navbar /> 
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<Register />} />
        <Route path="/add" element={<AddEmployees/>}/>
        <Route path="/" element={<Employee/>}/>
      </Routes>
    </Router>
  );
}

export default App;
