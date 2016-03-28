package com.replicon.client;

import com.google.common.collect.ImmutableList;
import com.replicon.model.Employee;

import java.util.List;

public interface IRepliconAPI {
    ImmutableList<Employee> getEmployees();
}
