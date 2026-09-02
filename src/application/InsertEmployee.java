package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.EmployeesDao;
import model.entities.Employees;

public class InsertEmployee {

	private Scanner sc;
	
	public InsertEmployee(Scanner sc) {
		this.sc = sc;
	}
	
	public void insertEmp() {
		Employees emp = new Employees();
		EmployeesDao empDao = DaoFactory.createEmployeesDao();
		
		boolean cont = true;
		
		while (cont) {
			System.out.println("== Cadastro de novo funcionario ==");
			System.out.println("Informe os dados: ");
			
			sc.nextLine();
			System.out.print("Nome: ");
			String name = sc.nextLine();
			System.out.print("Email: ");
			String email = sc.nextLine();
			System.out.print("Salario: ");
			double salary = sc.nextDouble();
			
			emp.setName(name);
			emp.setEmail(email);
			emp.setSalary(salary);
			
			empDao.insert(emp);
			System.out.println("Insert! New Employee = " + emp.getName());
			
			System.out.println("Deseja Cadastrar novo funcionario (y/n)? ");
			char confirmacao = sc.next().charAt(0);
			if (confirmacao == 'n') {
				cont = false;
			}
		}
		
		
	}
}
