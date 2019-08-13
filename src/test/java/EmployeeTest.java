package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import employee_stuff.Employee; 

class EmployeeTest {

	@Test
	void testEmployeeInt() {
		Employee e = new Employee(15);
		assertEquals(15, e.getNumber());
	}

	@Test
	void testEmployeeIntString() {
		Employee e = new Employee(15, "Henry Banana");
		assertEquals(15, e.getNumber());
		assertEquals("Henry Banana", e.getName());
	}

	@Test
	void testEmployeeIntStringFloat() {
		Employee e = new Employee(15, "Henry Banana", 20000f);
		assertEquals(15, e.getNumber());
		assertEquals("Henry Banana", e.getName());
		assertEquals(20000f, e.getSalary(), 0.000001);
	}
	
	@Test
	void testSalaryMinFailure() {
		Employee e = new Employee(15, "Henry Banana");
		assertThrows(IllegalArgumentException.class, () -> {
			e.setSalary(6999);
		});
		assertNotEquals(6999, e.getSalary());
	}

	@Test
	void testSalaryMinSuccess() {
		Employee e = new Employee(15, "Henry Banana");
		e.setSalary(Employee.MIN_SALARY);
		assertEquals(Employee.MIN_SALARY, e.getSalary());
	}
}
