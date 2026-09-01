package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.EmployeesDao;
import model.entities.Employees;

public class EmployeesDaoJDBC implements EmployeesDao {
	
	private Connection conn;
	
	public EmployeesDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<Employees> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM employees ORDER BY name");
			
			rs = st.executeQuery();
			
			List<Employees> list = new ArrayList<>();
			
			while (rs.next()) {
				Employees emp = new Employees();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setEmail(rs.getString("email"));
				emp.setSalary(rs.getDouble("salary"));
				list.add(emp);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public void insert(Employees obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Employees obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employees findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM employees WHERE id = ?");
			st.setInt(1, id);
			
			rs = st.executeQuery();
			
			if (rs.next()) {
				Employees emp = new Employees();
				
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setEmail(rs.getString("email"));
				emp.setSalary(rs.getDouble("salary"));
				return emp;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

}
