package service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import model.dao.DaoFactory;
import model.dao.EmployeesDao;
import model.entities.Employees;

public class EmployeeService {
	
	private EmployeesDao empDao = DaoFactory.createEmployeesDao();
	private List<Employees> list = empDao.findAll();
	
	public EmployeeService() {
	}
	
	public void refreshList() {
		this.list = empDao.findAll();
	}
	
	public List<Employees> listEmployees() {
		return this.list;
	}

	public List<Employees> SalaryMax( double salary) {
		List<Employees> salaryMax = list.stream().
				filter(e -> e.getSalary() > salary).
				toList();
		
		return salaryMax;
	}
	
	public Optional<Employees> SearchEmail (String email) {
		
		Optional<Employees> employeeEmail = list.stream().
				filter(e -> e.getEmail().equals(email)).
				findFirst();
		return employeeEmail;

	}
	
	public Optional<Employees> MaxSalary() {
		Optional<Employees> maxSalary = list.stream().
				max(Comparator.comparing(Employees::getSalary));
		
		return maxSalary;
	}
	
	public OptionalDouble AvarageSalary () {
		OptionalDouble avgSalary = list.stream().
				mapToDouble(Employees::getSalary).
				average();
			
			return avgSalary;
	}
	
	public double SumSalarys () {
		double sumSalary = list.stream().
				map(Employees::getSalary).
				reduce(0.0, (x,y) -> x+y);
		return sumSalary;
	}
	
	public List<Employees> OrdenedEmployees () {
		List<Employees> namesOrdened = list.stream().
				sorted(Comparator.comparing(Employees::getName)).
				toList();
		
		return namesOrdened;
	}
	
	public List<Employees> OrdenedSalary () {
		List<Employees> salaryOrdened = list.stream().
				sorted(Comparator.comparing(Employees::getSalary).reversed()).
				toList();
		
		return salaryOrdened;
	}
	
	public List<String> Emails () {
		List<String> emails = list.stream().
				map(Employees::getEmail).
				toList();
		
		return emails;
	}

}
