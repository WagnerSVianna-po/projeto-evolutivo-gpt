package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.EmployeesDao;
import model.entities.Employees;

public class Program2 {

	public static void main(String[] args) {

		EmployeesDao employeesDao = DaoFactory.createEmployeesDao();
		
		List<Employees> list = employeesDao.findAll();
		list.forEach(System.out::println);
	}

}
