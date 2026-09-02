package application;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean cont = true;
		ListEmployee listEmp = new ListEmployee(sc);
		InsertEmployee insertEmp = new InsertEmployee(sc);
		
		while (cont) {
			
			System.out.print("\n== Menu Employee ==\n"
					+ "1 - Listar funcionarios \n"
					+ "2 - Inserir novo funcionario \n"
					+ "\n== Informe a opção pelo numero: ");
			
			int menu = sc.nextInt();
			
			switch (menu) {
				case 1:
					listEmp.listEmp();
					break;
				case 2: 
					insertEmp.insertEmp();
			}
			
		}
		
		
		
		sc.close();
	}

}
