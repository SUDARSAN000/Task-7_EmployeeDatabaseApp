package Day_7;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
	
	public void addEmployee(Employee emp) {
		String sql = "INSERT INTO employees (id, name, position, salary)"
				     + "VALUES (?, ?, ?, ?)";
		try(Connection con = DBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, emp.getId());
			stmt.setString(2, emp.getName());
			stmt.setString(3, emp.getPosition());
			stmt.setDouble(4, emp.getSalary());
			stmt.executeUpdate();
			System.out.println("Employee added successfully... EmpID : "+ emp.getId()+"\n");
		}
		catch (SQLException e) {
			System.out.println("Error adding employee : "+e.getMessage());
		}
	}
	
	public List<Employee> getAllEmployees(){
		List<Employee> list = new ArrayList<>();
		String sql = "SELECT * FROM employees";
		
		try(Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(sql)){
			
			while(set.next()) {
				Employee emp = new Employee(
						set.getString("id"),
						set.getString("name"),
						set.getString("position"),
						set.getDouble("salary")
						);
				list.add(emp);	
			}
		}
		catch(SQLException e) {
			System.out.println("Error fetching employees : "+e.getMessage());
		}
		return list;
	}
	
	public void UpdateEmployee(String id, String name, String position, double salary) {
		String sql = "UPDATE employees SET name=?, position=?, salary=? WHERE id=?";
		try(Connection con = DBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, name);
			stmt.setString(2, position);
			stmt.setDouble(3, salary);
			stmt.setString(4, id);
			int rows = stmt.executeUpdate();
			if(rows > 0) {
				System.out.println("Employee updated successfully...\n");
			}
			else {
				System.out.println("No employee found with that id !\n");
			}
		}
		catch(SQLException e) {
			System.out.println("Error updating employee : "+e.getMessage());
		}
	}
	
	public void deleteEmployee(String id) {
		String sql = "DELETE FROM employees WHERE id=? ";
		try(Connection con = DBConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(2, id);
			int rows = stmt.executeUpdate();
			if(rows > 0) {
				System.out.println("Employee deleted successfully...\n");
			}
			else {
				System.out.println("No employee found with that id !\n");
			}
			
		} catch (SQLException e) {
			System.out.println("Error deleting employee : "+e.getMessage());
		}
	}
	
}
