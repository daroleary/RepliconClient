package com.replicon.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ComparisonChain;

public class Employee implements Comparable<Employee> {

    private final int _id;
    private final String _name;

    public Employee(@JsonProperty("_id") int id,
		    @JsonProperty("_name") String name) {

	_id = id;
	_name = name;
    }

    public int getId() {
	return _id;
    }

    public String getName() {
	return _name;
    }

    @Override
    public String toString() {
	return "Employee{" +
	       "_id=" + _id +
	       ", _name='" + _name + '\'' +
	       '}';
    }

    @Override
    public int compareTo(Employee o) {
	return ComparisonChain.start()
		.compare(_name, o._name)
		.compare(_id, o._id)
		.result();
    }

    @Override
    public boolean equals(Object o) {
	if (this == o) {
	    return true;
	}
	if (o == null || getClass() != o.getClass()) {
	    return false;
	}

	Employee employee = (Employee) o;

	if (_id != employee._id) {
	    return false;
	}
	return _name.equals(employee._name);

    }

    @Override
    public int hashCode() {
	int result = _id;
	result = 31 * result + _name.hashCode();
	return result;
    }
}
