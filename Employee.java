package Day_7;

public class Employee {
	private static int count = 1;
	private String id;
	private String name;
	private String position;
	private double salary;
	
	public Employee(String name, String position, double salary) {
		this.id = "EID"+count++;
		this.name = name;
		this.position = position;
		this.salary = salary;
	}
	public Employee(String id, String name, String position, double salary) {
		this.id = id;
		this.name = name;
		this.position = position;
		this.salary = salary;
	}

	public String getId() { return id; }

	public String getName() { return name; }
	
	public String getPosition() { return position; }

	public double getSalary() { return salary; }

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", position=" + position + ", salary=" + salary + "]";
	}
	
	
}
