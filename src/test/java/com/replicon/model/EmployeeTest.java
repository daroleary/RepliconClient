package com.replicon.model;

import com.replicon.common.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeTest extends TestData {

    private Employee _target;

    @Test
    public void getEmployee_success() {

	int idFixture      = 2;
	String nameFixture = "name";

	_target = getEmployee(idFixture, nameFixture);

	assertNotNull(_target);
	assertEquals(idFixture, _target.getId());
	assertEquals(nameFixture, _target.getName());
    }

    @Test
    public void getEmployees_orderByNameAndId_success() {
	Employee firstEmployee = getEmployee(2, "name");
	Employee secondEmployee = getEmployee(1, "name");
	Employee thirdEmployee = getEmployee(3, "other_name");
	Employee fourthEmployee = getEmployee(3, "another_name");
	List<Employee> employees = getEmployees(firstEmployee, secondEmployee, thirdEmployee, fourthEmployee);
	Collections.sort(employees);

	assertEquals(fourthEmployee, employees.get(0));
	assertEquals(secondEmployee, employees.get(1));
	assertEquals(firstEmployee, employees.get(2));
	assertEquals(thirdEmployee, employees.get(3));
    }
}