// App.js
import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

// Import components and pages
import Navbar from './nav.jsx';
import Home from './Home.jsx';
import About from './About.jsx';

function App() {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<About />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
