// src/pages/HomePage.js

import React from 'react';
import TaskList from '../components/TaskList';

function HomePage() {
  return (
    <div style={{ padding: '20px' }}>
      <h1>Welcome to LevelUp</h1>
      <TaskList />
    </div>
  );
}

export default HomePage;
