package com.replicon.client;

import com.google.common.collect.ImmutableList;
import com.replicon.common.TestCase;
import com.replicon.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class RepliconAPITest extends TestCase {

    RepliconAPI _target;

    @Mock
    RepliconClient _repliconClient;

    @Test
    public void getEmployees_success() {
        _target = new RepliconAPI(_repliconClient);

        Employee employeeOne = getEmployee("EmployeeOne");
        Employee employeeTwo = getEmployee("EmployeeTwo");
        ImmutableList<Employee> employeesFixture = ImmutableList.of(employeeOne, employeeTwo);

        Class<Employee> employeeClass = Employee.class;
        String employeesPath = "employees";

        doReturn(employeesFixture).when(_repliconClient).getModelsFrom(employeeClass, employeesPath);

        ImmutableList<Employee> result = _target.getEmployees();

        verify(_repliconClient).getModelsFrom(employeeClass, employeesPath);

        assertNotNull(result);
        assertEquals(employeeOne, result.get(0));
        assertEquals(employeeTwo, result.get(1));
    }

}