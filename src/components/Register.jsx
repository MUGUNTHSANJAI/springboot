import React, { useState } from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';

const Register = () => {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    password: '',
    userName: '',
    roleNames: [],
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  const handleRoleCheckboxChange = (e) => {
    const { value, checked } = e.target;
    setFormData((prev) => ({
      ...prev,
      roleNames: checked
        ? [...prev.roleNames, value]
        : prev.roleNames.filter((role) => role !== value),
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post('http://localhost:3001/api/auth/register', {
        ...formData,
      });
      alert('Registered Successfully!');
    } catch (err) {
      console.error('Register Error', err);
      alert('Registration failed.');
    }
  };

  return (
    <div className="container mt-5">
      <div className="row justify-content-center">
        <div className="col-md-6">
          <div className="card p-4 shadow">
            <h2 className="text-center mb-4">Register</h2>
            <form onSubmit={handleSubmit}>
              <div className="mb-3">
                <input
                  type="text"
                  name="name"
                  value={formData.name}
                  onChange={handleChange}
                  className="form-control"
                  placeholder="Full Name"
                  required
                />
              </div>

              <div className="mb-3">
                <input
                  type="text"
                  name="userName"
                  value={formData.userName}
                  onChange={handleChange}
                  className="form-control"
                  placeholder="Username"
                  required
                />
              </div>

              <div className="mb-3">
                <input
                  type="email"
                  name="email"
                  value={formData.email}
                  onChange={handleChange}
                  className="form-control"
                  placeholder="Email"
                  required
                />
              </div>

              <div className="mb-3">
                <input
                  type="password"
                  name="password"
                  value={formData.password}
                  onChange={handleChange}
                  className="form-control"
                  placeholder="Password"
                  required
                />
              </div>

              <div className="mb-3">
                <label className="form-check-label me-3">
                  <input
                    type="checkbox"
                    className="form-check-input me-1"
                    value="ROLE_USER"
                    checked={formData.roleNames.includes("ROLE_USER")}
                    onChange={handleRoleCheckboxChange}
                  />
                  ROLE_USER
                </label>

                <label className="form-check-label">
                  <input
                    type="checkbox"
                    className="form-check-input me-1"
                    value="ROLE_ADMIN"
                    checked={formData.roleNames.includes("ROLE_ADMIN")}
                    onChange={handleRoleCheckboxChange}
                  />
                  ROLE_ADMIN
                </label>
              </div>

              <button type="submit" className="btn btn-primary w-100">Register</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Register;
