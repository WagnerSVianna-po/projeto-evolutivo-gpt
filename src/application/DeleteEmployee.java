package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.EmployeesDao;

public class DeleteEmployee {

	private Scanner sc;
	
	public DeleteEmployee(Scanner sc) {
		this.sc = sc;
	}
	
	public void deleteEmp() {
		EmployeesDao empDao = DaoFactory.createEmployeesDao();
		
		System.out.println("== Deletar funcionario ==");
		System.out.print("Informe o ID do funcionario: ");
		System.out.println();
		int id = sc.nextInt();
		empDao.deleteById(id);
		
		System.out.println("Delete completede!");
		
		
	}
}
