// src/components/TaskList.js

import React, { useEffect, useState } from 'react';
import api from '../services/api'; // this is our axios config

function TaskList() {
  const [tasks, setTasks] = useState([]);

  // Fetch tasks when the component loads
  useEffect(() => {
    fetchTasks();
  }, []);

  const fetchTasks = async () => {
    try {
      const userId = 1; // Hardcoded user ID for now
      const response = await api.get(`/tasks/user/${userId}`);
      setTasks(response.data); // Save tasks in state
    } catch (error) {
      console.error('Failed to fetch tasks:', error);
    }
  };

  return (
    <div>
      <h2>Your Tasks</h2>
      <ul>
        {tasks.map((task) => (
          <li key={task.id}>
            <strong>{task.title}</strong> - {task.type} - {task.status} - {task.xp} - {task.deadline}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default TaskList;
