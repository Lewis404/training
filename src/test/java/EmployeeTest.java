package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
		float oldSalary = e.getSalary();
		assertThrows(IllegalArgumentException.class, () -> e.setSalary(Employee.MIN_SALARY - 1));
		assertNotEquals(Employee.MIN_SALARY - 1, e.getSalary());
		assertEquals(oldSalary, e.getSalary());
	}

	@Test
	void testSalaryMinSuccess() {
		Employee e = new Employee(15, "Henry Banana");
		e.setSalary(Employee.MIN_SALARY);
		assertEquals(Employee.MIN_SALARY, e.getSalary());
	}

	@Test
	void testNumberAsStringSuccess() {
		Employee e = new Employee(15, "Henry Banana");
		assertTrue(e.setNumber("18"));
		assertEquals(18, e.getNumber());
	}

	@Test
	void testNumberAsStringFailure() {
		Employee e = new Employee(15, "Henry Banana");
		assertThrows(NumberFormatException.class, () -> e.setNumber("Not a number"));
		assertEquals(15, e.getNumber());
	}

	@Test
	void testNumberAsNegativeFailure() {
		Employee e = new Employee(-5, "Henry Banana");
		assertEquals(0 , e.getNumber());
		assertFalse(e.setNumber(-1));
	}
}
