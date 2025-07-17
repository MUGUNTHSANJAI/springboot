import { useState } from "react";
import axios from "axios";
import 'bootstrap/dist/css/bootstrap.min.css'; // Make sure this import is present in your main entry file as well!

const Login = () => {
  const [name, setName] = useState("");
  const [password, setPassword] = useState("");

  async function handleLogin(event) {
    event.preventDefault();
    try {
      const response = await axios.post(
        "http://localhost:3001/api/auth/login",
        { name, password }
      );

      const token = response.data.token;
      const userName = response.data.userName;
      const roles = response.data.roles[0];

      if (token) {
        localStorage.setItem("token", token);
        localStorage.setItem("role", roles);
        localStorage.setItem("userName", userName);
        alert("Login Successful");
      } else {
        alert("Invalid token received");
      }

    } catch (e) {
      console.error("Login error:", e.response?.data || e.message);
      alert(e.response?.data?.message || "Login Failed");
    }
  }

  return (
    <div className="container mt-5">
      <div className="row justify-content-center">
        <div className="col-md-4">
          <div className="card p-4 shadow">
            <h2 className="text-center mb-4">Login</h2>
            <form onSubmit={handleLogin}>
              <div className="mb-3">
                <label htmlFor="name" className="form-label">User Name</label>
                <input
                  id="name"
                  name="name"
                  value={name}
                  type="text"
                  onChange={(e) => setName(e.target.value)}
                  className="form-control"
                  required
                />
              </div>

              <div className="mb-3">
                <label htmlFor="password" className="form-label">Password</label>
                <input
                  id="password"
                  name="password"
                  value={password}
                  type="password"
                  onChange={(e) => setPassword(e.target.value)}
                  className="form-control"
                  required
                />
              </div>

              <button type="submit" className="btn btn-primary w-100">Login</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Login;
