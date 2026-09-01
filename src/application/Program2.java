package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.EmployeesDao;
import model.entities.Employees;

public class Program2 {

	public static void main(String[] args) {

		EmployeesDao employeesDao = DaoFactory.createEmployeesDao();
		
		
		System.out.println("=== TEST 1: employees listAll ===");
		List<Employees> list = employeesDao.findAll();
		list.forEach(System.out::println);
		
		System.out.println("=== TEST 2: employees findById ===");
		Employees emp = employeesDao.findById(1);
		System.out.println(emp);
		
	}

}
