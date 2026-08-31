package model.dao;

import java.util.List;

import model.entities.Employees;

public interface EmployeesDao {

	List<Employees> findAll();
	void insert(Employees obj);
	void update(Employees obj);
	void deleteById(Integer id);
	Employees findById(Integer id);
}
