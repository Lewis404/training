package employee_stuff;

public class Employee {
	private String name;
	private int number;
	private float salary;
	private float bonus;
	public static final float MIN_SALARY = 10000f;
	private final float INITIAL_BONUS = 200f;
	public static int instanceCount;

	@Override
	public void finalize() {
		instanceCount--;
	}

	public Employee() {
		//////////
		instanceCount++;
		this.bonus = INITIAL_BONUS;
	}

	public Employee(int newNumber) {
		this();
		this.setNumber(newNumber);
	}

	public Employee(int newNumber, String newName) {
		this(newNumber);
		this.setName(newName);
	}

	public Employee(int newNumber, String newName, float newSalary) {
		this(newNumber, newName);
		this.setSalary(newSalary);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public boolean setNumber(String thisNumber) {
		return setNumber(Integer.parseInt(thisNumber));
	}

	public boolean setNumber(int thisNumber) {
		if (thisNumber > 0) {
			this.number = thisNumber;
			return true;
		} else {
			return false;
		}
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float newSalary) {
		if (newSalary >= MIN_SALARY) {
			this.salary = newSalary;
		} else {
			throw new IllegalArgumentException("new salary below minimum");
		}
	}

	public float calcPay() {
		return getSalary() / 12;
	}

	@Override
	public String toString() {
		return String.format("Employee %d: %s, £%.2f. " + "Monthly gross pay: £%.2f.", this.getNumber(), this.getName(),
				this.getSalary(), this.calcPay());
	}

	public static int surnameSort(Employee e1, Employee e2) {
		if (!e1.getName().contains(" "))
			return -1;
		if (!e2.getName().contains(" "))
			return 1;
		return e1.getName().split(" ")[1].compareToIgnoreCase(e2.getName().split(" ")[1]);
	}

}
