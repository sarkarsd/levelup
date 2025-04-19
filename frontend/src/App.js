import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import HomePage from './pages/HomePage';
import TaskForm from './components/TaskForm'; // Add TaskForm if you want to navigate there
import TaskList from './components/TaskList';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/task-form/:userId" element={<TaskForm />} />  {/* Dynamic userId */}
        <Route path="/task-list/:userId" element={<TaskList />} />
      </Routes>
    </Router>
  );
}

export default App;

