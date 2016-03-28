package com.replicon.client;

import com.google.common.collect.ImmutableList;
import com.replicon.model.Employee;

final class RepliconAPI implements IRepliconAPI {

    private final RepliconClient _client;

    RepliconAPI(RepliconClient client) {
	_client = client;
    }

    @Override
    public ImmutableList<Employee> getEmployees() {
	return getClient().getModelsFrom(Employee.class, "employees");
    }

    public RepliconClient getClient() {
	return _client;
    }
}
