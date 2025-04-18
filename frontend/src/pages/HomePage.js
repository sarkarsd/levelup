import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import './HomePage.css'; 

const HomePage = () => {
  const [userStats, setUserStats] = useState(null);
  const [tasks, setTasks] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    // Fetch stats for user with id 1 (adjust id as needed)
    axios
      .get("http://localhost:8080/users/1/stats")
      .then((response) => {
        setUserStats(response.data);
      })
      .catch((err) => {
        setError("Error fetching user stats: " + err.message);
      });

    // Fetch tasks for the user
    axios
      .get("http://localhost:8080/tasks/user/1")
      .then((response) => {
        setTasks(response.data);
      })
      .catch((err) => {
        setError("Error fetching tasks: " + err.message);
      });
  }, []);

  if (error) {
    return <div>{error}</div>;
  }

  if (!userStats || tasks.length === 0) {
    return <div>Loading...</div>;
  }

  return (
    <div className="home-page">
      <h1>{userStats.name}'s Dashboard</h1>
      <div className="user-stats">
        <p>Level: {userStats.level}</p>
        <p>Total XP: {userStats.totalXp}</p>
      </div>

      <div className="task-summary">
        <h2>Tasks Overview</h2>

        {/* Main Tasks */}
        <div className="task-type">
          <h3>Main Task ({userStats.taskCountByType.MAIN ||0})</h3>
          {tasks.filter((task) => task.type === "MAIN").map((task) => (
            <div key={task.id} className="task-item">
              <p>{task.title}</p>
              <p>XP: {task.xp}</p>
            </div>
          ))}
        </div>

        {/* Side Tasks */}
        <div className="task-type">
          <h3>Side Tasks ({userStats.taskCountByType.SIDE||0})</h3>
          {tasks.filter((task) => task.type === "SIDE").map((task) => (
            <div key={task.id} className="task-item">
              <p>{task.title}</p>
              <p>XP: {task.xp}</p>
            </div>
          ))}
        </div>

        {/* Daily Tasks */}
        <div className="task-type">
          <h3>Daily Tasks ({userStats.taskCountByType.DAILY||0})</h3>
          {tasks.filter((task) => task.type === "DAILY").map((task) => (
            <div key={task.id} className="task-item">
              <p>{task.title}</p>
              <p>XP: {task.xp}</p>
            </div>
          ))}
        </div>
      </div>

      {/* Link to create a new task */}
      <Link to="/task-form" className="create-task-btn">Create New Task</Link>
    </div>
  );
};

export default HomePage;


