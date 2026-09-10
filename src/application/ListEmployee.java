package application;


import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Scanner;

import model.entities.Employees;
import service.EmployeeService;

public class ListEmployee {
	
	private Scanner sc;
	private EmployeeService empServ = new EmployeeService();
	
	public ListEmployee(Scanner sc) {
		this.sc = sc;
	}

	public void listEmp() {
		
		empServ.refreshList();
 		int number = 1;
		
		while (number != 0) {
			
			System.out.print("Escolha uma opção \n"
					+ "1 - listar funcionarios\n"
					+ "2 - Funcionarios acima de um valor\n"
					+ "3 - Procurar funcionario por e-mail\n"
					+ "4 - Mostrar maior salario\n"
					+ "5 - Mostrar média salarial\n"
					+ "6 - Mostrar soma dos salarios\n"
					+ "7 - Mostras funcionarios em ordem alfabética\n"
					+ "8 - Mostrar funcionários por salário (maior para menor)\n"
					+ "9 - Mostrar apenas emails\n"
					+ "0 - Encerrar\n"
					+ "Opção: ");

			number = sc.nextInt();
			sc.nextLine();
			System.out.println();
			
			switch (number) {
			case 1: {
				empServ.listEmployees().forEach(System.out::println);;
				System.out.println();
				System.out.println("Pressione enter para continuar");
				sc.nextLine();
				break;
			}
			case 2: {
				System.out.print("Informe o salario: ");
				double salary = sc.nextDouble();
				System.out.println();
				List<Employees> list = empServ.SalaryMax(salary);
				list.forEach(System.out::println);
				System.out.println();
				System.out.println("Pressione enter para continuar");
				sc.nextLine();
				sc.nextLine();
				break;
			}
			case 3: {
				System.out.print("Informe o email: ");
				String email = sc.nextLine();
				System.out.println();
				Optional<Employees> empEmail = empServ.SearchEmail(email);
				empEmail.ifPresent(System.out::println);
				System.out.println();
				System.out.println("Pressione enter para continuar");
				sc.nextLine();
				break;
			}
			case 4: {
				Optional<Employees> maxSalary = empServ.MaxSalary();
				maxSalary.ifPresent(System.out::println);
				System.out.println();
				System.out.println("Pressione enter para continuar");
				sc.nextLine();
				break;
			}
			case 5: {
				OptionalDouble avgSalary = empServ.AvarageSalary();
				avgSalary.ifPresent(System.out::println);
				System.out.println();
				System.out.println("Pressione enter para continuar");
				sc.nextLine();
				break;
			}
			case 6: {
				double sumSalary = empServ.SumSalarys();
				System.out.print("Soma dos salarios: ");
				System.out.println(sumSalary);
				System.out.println();
				System.out.println("Pressione enter para continuar");
				sc.nextLine();
				break;
			}
			case 7: {
				List<Employees> namesOrdened = empServ.OrdenedEmployees();
				namesOrdened.forEach(System.out::println);
				System.out.println();
				System.out.println("Pressione enter para continuar");
				sc.nextLine();
				break;
			}
			case 8: {
				List<Employees> salaryOrdened = empServ.OrdenedSalary();
				salaryOrdened.forEach(System.out::println);
				System.out.println();
				System.out.println("Pressione enter para continuar");
				sc.nextLine();
				break;
			}
			case 9: {
				List<String> emails = empServ.Emails();
				emails.forEach(System.out::println);
				System.out.println();
				System.out.println("Pressione enter para continuar");
				sc.nextLine();
				break;
			}
			case 0: {
				break;
			}
			default:
				System.out.println("Numero invalido.");
			}
		}
		
	}
}
