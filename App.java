package Day_7;

import java.util.List;
import java.util.Scanner;

public class App {
	private static final Scanner scanner = new Scanner(System.in);
	private static final EmployeeDAO dao = new EmployeeDAO();
	
	public static void main (String args[]) {
		
		System.out.println("___Employee Database App___\n");
		while(true) {
			showMenu();
			int choice = getInt("Enter your choice : ");
			switch(choice) {
				case 1 -> addEmployee();
				case 2 -> viewAllEmployee();
				case 3 -> updateEmployee();
				case 4 -> deleteEmployee();
				case 5 -> {System.out.println("Exiting...Thankyou ^-^"); return ;}
				default -> System.out.println("Invalid choice ! please enter number from 1 to 5\n");
			}
		}
	}

	private static void deleteEmployee() {
		String id = getString("Enter employee ID to delete : ");
		dao.deleteEmployee(id);
	}

	private static void updateEmployee() {
		String id = getString("Enter employee ID to update : ");
		String name = getString("Enter name : ");
		String position = getString("Enter position : ");
		double salary = getDouble("Enter salary : ");
		dao.UpdateEmployee(id, name, position, salary);
	}

	private static void viewAllEmployee() {
		List<Employee> list = dao.getAllEmployees();
		if(list.isEmpty()) {
			System.out.println("No Employees Found !\n");
		}
		else{
			list.forEach(System.out::println);
			System.out.println();
		}
	}

	private static void addEmployee() {
		String name = getString("Enter name : ");
		String position = getString ("Enter position : ");
		double salary = getDouble("Enter salary : ");
		dao.addEmployee(new Employee(name, position, salary));
	}

	
	private static void showMenu() {
		System.out.println("1. AddEmployee");
		System.out.println("2. ViewAllEmployee");
		System.out.println("3. UpdateEmployee");
		System.out.println("4. DeleteEmployee");
		System.out.println("5. Exit\n");
	}
	
	private static int getInt(String msg) {
		while(true){
			try {
				System.out.println(msg);
				return Integer.parseInt(scanner.next());
			}
			catch(Exception e) {
				System.out.println("please enter a valid number\n");
			}
		}
	}
	private static double getDouble(String msg) {
		while(true) {
			try {
				System.out.println(msg);
				return Double.parseDouble(scanner.next());
			}
			catch(Exception e) {
				System.out.println("please enter a valid amount\n");
			}
		}
	}

	private static String getString(String msg) {
		System.out.println(msg);
		return scanner.next();
	}
}
