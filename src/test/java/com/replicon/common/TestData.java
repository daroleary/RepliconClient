package com.replicon.common;

import com.replicon.model.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestData {

    public Employee getEmployee(String name) {
	return getEmployee(1, name);
    }

    public Employee getEmployee(int idFixture, String nameFixture) {
	return new Employee(idFixture, nameFixture);
    }

    public List<Employee> getEmployees(Employee ... employees) {
	List<Employee> employeeList = new ArrayList<>();
	Collections.addAll(employeeList, employees);
	return employeeList;
    }
}
