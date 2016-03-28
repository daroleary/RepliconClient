package com.replicon.client;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.replicon.model.Employee;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.ResponseProcessingException;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.text.MessageFormat;

public enum RepliconClient implements IRepliconAPI {
    INSTANCE {
	@Override
	public ImmutableList<Employee> getEmployees() {
	    return getRepliconAPI().getEmployees();
	}
    };

    private static final String BASE_URL = "http://interviewtest.replicon.com/";

    private final transient RepliconAPI _repliconAPI;
    private final transient Client _client;

    RepliconClient() {
	_repliconAPI = new RepliconAPI(this);
	_client = ClientBuilder.newBuilder()
		.register(JacksonFeature.class)
		.build();
    }

    public RepliconAPI getRepliconAPI() {
	return _repliconAPI;
    }

    public Invocation.Builder getInvocationBuilderOfJSONFrom(String path) {
	Preconditions.checkNotNull(path);

	return _client.target(getURL(path)).request(MediaType.APPLICATION_JSON_TYPE);
    }

    public <T extends Comparable> T getModelFrom(Class<T> clazz, String path) {
	Preconditions.checkNotNull(clazz);

	try {
	    return getInvocationBuilderOfJSONFrom(path).get(clazz);
	} catch (ResponseProcessingException ex) {
	    throw new RuntimeException(MessageFormat.format("Encountered unexpected exception processing HTTP GET, for: \n" +
							    "class: [{0}],\n" +
							    "path : [{1}]",
							    clazz.getName(),
							    path));
	}
    }

    public <T extends Comparable> ImmutableList<T> getModelsFrom(Class<T> clazz, String path) {
	Preconditions.checkNotNull(clazz);

	try {
	    //noinspection EmptyClass
	    return _client.target(getURL(path)).request(MediaType.APPLICATION_JSON_TYPE).get(new GenericType<ImmutableList<T>>() {
	    });
	} catch (ResponseProcessingException ex) {
	    throw new RuntimeException(MessageFormat.format("Encountered unexpected exception processing HTTP GET, for: \n" +
							    "class: [{0}],\n" +
							    "path : [{1}]",
							    clazz.getName(),
							    path));
	}

    }

    public String getURL(String path) {
	Preconditions.checkNotNull(path);

	return MessageFormat.format("{0}\\{1}", BASE_URL, path);
    }
}
