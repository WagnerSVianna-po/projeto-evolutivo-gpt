package application;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.EmployeesDao;
import model.entities.Employees;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
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
				listEmployees().forEach(System.out::println);;
				System.out.println();
				System.out.println("Pressione enter para continuar");
				sc.nextLine();
				break;
			}
			case 2: {
				System.out.print("Informe o salario: ");
				double salary = sc.nextDouble();
				System.out.println();
				SalaryMax(listEmployees(), salary);
				sc.nextLine();
				sc.nextLine();
				break;
			}
			case 3: {
				System.out.print("Informe o email: ");
				String email = sc.nextLine();
				System.out.println();
				SearchEmail(listEmployees(), email);
				sc.nextLine();
				break;
			}
			case 4: {
				MaxSalary(listEmployees());
				sc.nextLine();
				break;
			}
			case 5: {
				AvarageSalary(listEmployees());
				sc.nextLine();
				break;
			}
			case 6: {
				SumSalarys(listEmployees());
				sc.nextLine();
				break;
			}
			case 7: {
				OrdenedEmployees(listEmployees());
				sc.nextLine();
				break;
			}
			case 8: {
				OrdenedSalary(listEmployees());
				sc.nextLine();
				break;
			}
			case 9: {
				Emails(listEmployees());
				sc.nextLine();
				break;
			}
			case 0: {
				System.out.println("Programa encerrado!");
				break;
			}
			default:
				System.out.println("Numero invalido.");
			}
		}
		
		sc.close();
	}
	
	public static List<Employees> listEmployees() {
		EmployeesDao empDao = DaoFactory.createEmployeesDao();
		List<Employees> list = empDao.findAll();
		return list;
	}
	
	public static void SalaryMax(List<Employees> l, double salary) {
		List<Employees> salaryMax = l.stream().
				filter(e -> e.getSalary() > salary).
				toList();
		
		salaryMax.forEach(System.out::println);
		System.out.println();
		System.out.println("Pressione enter para continuar");
	}
	
	public static void SearchEmail (List<Employees> l, String email) {
		
		Optional<Employees> employeeEmail = l.stream().
				filter(e -> e.getEmail().equals(email)).
				findFirst();
		employeeEmail.ifPresent(System.out::println);
		System.out.println();
		System.out.println("Pressione enter para continuar");
	}
	
	public static void MaxSalary (List<Employees> l) {
		Optional<Employees> maxSalary = l.stream().
				max(Comparator.comparing(Employees::getSalary));
		
		maxSalary.ifPresent(System.out::println);
		System.out.println();
		System.out.println("Pressione enter para continuar");
	}
	
	public static void AvarageSalary (List<Employees> l) {
		OptionalDouble avgSalary = l.stream().
				mapToDouble(Employees::getSalary).
				average();
			
			avgSalary.ifPresent(System.out::println);
			System.out.println();
			System.out.println("Pressione enter para continuar");
	}
	
	public static void SumSalarys (List<Employees> l) {
		double sumSalary = l.stream().
				map(Employees::getSalary).
				reduce(0.0, (x,y) -> x+y);
		System.out.print("Soma dos salarios: ");
		System.out.println(sumSalary);
		System.out.println();
		System.out.println("Pressione enter para continuar");
	}
	
	public static void OrdenedEmployees (List<Employees> l) {
		List<Employees> namesOrdened = l.stream().
				sorted(Comparator.comparing(Employees::getName)).
				toList();
		
		namesOrdened.forEach(System.out::println);
		System.out.println();
		System.out.println("Pressione enter para continuar");
	}
	
	public static void OrdenedSalary (List<Employees> l) {
		List<Employees> salaryOrdened = l.stream().
				sorted(Comparator.reverseOrder()).
				toList();
		
		salaryOrdened.forEach(System.out::println);
		System.out.println();
		System.out.println("Pressione enter para continuar");
	}
	
	public static void Emails (List<Employees> l) {
		List<String> emails = l.stream().
				map(Employees::getEmail).
				toList();
		
		emails.forEach(System.out::println);
		System.out.println();
		System.out.println("Pressione enter para continuar");
	}

}
