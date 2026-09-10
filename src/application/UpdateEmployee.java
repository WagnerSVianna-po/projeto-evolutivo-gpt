package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.EmployeesDao;
import model.entities.Employees;

public class UpdateEmployee {

	private Scanner sc;
	
	public UpdateEmployee(Scanner sc) {
		this.sc = sc;
	}
	
	public void updateEmp() {
		EmployeesDao empDao = DaoFactory.createEmployeesDao();

		System.out.println("== Atualização de funcionario ==");
		System.out.print("Informe o ID do funcionario: ");
		System.out.println();
		int id = sc.nextInt();
		sc.nextLine();
		Employees empUp = empDao.findById(id);
		
		System.out.print("Nome: ");
		String name = sc.nextLine();
		empUp.setName(name);
		
		System.out.print("Email: ");
		String email = sc.next();
		empUp.setEmail(email);
		
		System.out.print("Salario: ");
		double salary = sc.nextDouble();
		empUp.setSalary(salary);
		
		empDao.update(empUp);
		System.out.println(empUp);
		System.out.println("Update completed!");
	}
}
