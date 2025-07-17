import { useEffect, useState } from "react";
import axios from "axios";
import 'bootstrap/dist/css/bootstrap.min.css';

const Employee = () => {
  const [employees, setEmployees] = useState([]);
  const [editEmployee, setEditEmployee] = useState(null);
  const token = localStorage.getItem("token");
  const role = localStorage.getItem("role");

  useEffect(() => {
    const fetchEmployees = async () => {
      try {
        const response = await axios.get("http://localhost:3001/employee", {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        });
        setEmployees(response.data);
      } catch (err) {
        console.error("Error fetching employees", err);
        alert("Unauthorized or Error");
      }
    };

    fetchEmployees();
  }, [token]);

  const handleDelete = async (empId) => {
    try {
      await axios.delete(`http://localhost:3001/employee/${empId}`, {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      });
      setEmployees(employees.filter((emp) => emp.empId !== empId));
      alert("Employee deleted successfully");
    } catch (err) {
      console.error("Error deleting employee", err);
      alert("Delete failed");
    }
  };

  const handleEditChange = (e) => {
    const { name, value } = e.target;
    setEditEmployee({ ...editEmployee, [name]: value });
  };

  const handleEditSubmit = async () => {
    try {
      await axios.put(`http://localhost:3001/employee/${editEmployee.empId}`, editEmployee, {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      });
      setEmployees(employees.map(emp => emp.empId === editEmployee.empId ? editEmployee : emp));
      alert("Employee updated successfully");
      setEditEmployee(null);
    } catch (err) {
      console.error("Error updating employee", err);
      alert("Update failed");
    }
  };

  return (
    <div className="container mt-4">
      <h2>Employee List</h2>
      <p>Logged in as: {role}</p>
      <table className="table table-bordered">
        <thead className="thead-dark">
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            {role === "ROLE_ADMIN" && <th>Actions</th>}
          </tr>
        </thead>
        <tbody>
          {employees.map((emp) => (
            <tr key={emp.empId}>
              <td>{emp.empId}</td>
              <td>{emp.name}</td>
              <td>{emp.email}</td>
              {role === "ROLE_ADMIN" && (
                <td>
                  <button
                    onClick={() => setEditEmployee(emp)}
                    className="btn btn-primary btn-sm me-2"
                    data-bs-toggle="modal"
                    data-bs-target="#editModal"
                  >
                    Edit
                  </button>
                  <button
                    onClick={() => handleDelete(emp.empId)}
                    className="btn btn-danger btn-sm"
                  >
                    Delete
                  </button>
                </td>
              )}
              {role=="ROLE_USER" &&(<td>
                  <button
                    onClick={() => setEditEmployee(emp)}
                    className="btn btn-primary btn-sm me-2"
                    data-bs-toggle="modal"
                    data-bs-target="#editModal"
                  >
                    Edit
                  </button>
                 </td>)}
            </tr>
          ))}
        </tbody>
      </table>

      {editEmployee && (
        <div className="modal fade show d-block" id="editModal">
          <div className="modal-dialog">
            <div className="modal-content p-3">
              <div className="modal-header">
                <h5 className="modal-title">Edit Employee</h5>
                <button type="button" className="btn-close" onClick={() => setEditEmployee(null)}></button>
              </div>
              <div className="modal-body">
                <input
                  type="text"
                  name="name"
                  value={editEmployee.name}
                  onChange={handleEditChange}
                  className="form-control mb-2"
                  placeholder="Name"
                />
                <input
                  type="email"
                  name="email"
                  value={editEmployee.email}
                  onChange={handleEditChange}
                  className="form-control mb-2"
                  placeholder="Email"
                />
              </div>
              <div className="modal-footer">
                <button className="btn btn-secondary" onClick={() => setEditEmployee(null)}>Cancel</button>
                <button className="btn btn-success" onClick={handleEditSubmit}>Save Changes</button>
              </div>
            </div>
          </div>
        </div>
      )}
    </div>
  );
};

export default Employee;
