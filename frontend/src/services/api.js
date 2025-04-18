import axios from 'axios';

// Base URL of your Spring Boot backend
const api = axios.create({
  baseURL: 'http://localhost:8080', // change if your backend runs elsewhere
});

export default api;
