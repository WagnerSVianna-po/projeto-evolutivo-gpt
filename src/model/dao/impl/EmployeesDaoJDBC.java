package model.dao.impl;

import java.sql.Connection;
import java.util.List;

import model.dao.EmployeesDao;
import model.entities.Employees;

public class EmployeesDaoJDBC implements EmployeesDao {
	
	private Connection conn;
	
	public EmployeesDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<Employees> findAll() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

}
