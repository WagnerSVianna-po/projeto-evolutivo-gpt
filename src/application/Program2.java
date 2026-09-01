package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.EmployeesDao;
import model.entities.Employees;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		EmployeesDao employeesDao = DaoFactory.createEmployeesDao();
		
		
		System.out.println("=== TEST 1: employees listAll ===");
		List<Employees> list = employeesDao.findAll();
		list.forEach(System.out::println);
		
		System.out.println("=== TEST 2: employees findById ===");
		Employees emp = employeesDao.findById(1);
		System.out.println(emp);
		
		/** COMENTADO PARA NÃO RODAR SEMPRE
		System.out.println("=== TEST 3: employees Insert ===");
		emp = new Employees(null, "Levi", "levi@gmail.com", 1500.00);
		employeesDao.insert(emp);
		System.out.println("Insert! New Employee = " + emp.getName());
		**/
		
		System.out.println("=== TEST 4: employees Update ===");
		Employees empUp = employeesDao.findById(4);
		empUp.setName("Bob");
		empUp.setEmail("bob@gmail.com");
		employeesDao.update(empUp);
		System.out.println("Employee updated");
		
		System.out.println("=== TEST 5: employees Delete ===");
		System.out.print("Informe o id que deseja deletar: ");
		int id = sc.nextInt();
		employeesDao.deleteById(id);
		System.out.println("Employee deleted");
		
		
		
		sc.close();
		
	}

}
