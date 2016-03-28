package com.replicon.client;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class RepliconClientTest {

    RepliconClient _target;

    @Test
    public void getClient_isNotNull_success() {
        _target = RepliconClient.INSTANCE;

        assertNotNull(_target);
    }

    @Test
    @Ignore
    public void getModelFrom_success() {

    }

    @Test
    @Ignore
    public void getInvocationBuilderOfJSONFrom_success() {

    }

    @Test
    @Ignore
    public void getInvocationBuilderOfJSONFrom_pathIsNull_throwsNullPointerException() {

    }

    @Test
    @Ignore
    public void getModelFrom_classIsNull_throwsNullPointerException() {

    }

    @Test
    @Ignore
    public void getModelsFrom_classIsNull_throwsNullPointerException() {

    }

    @Test
    @Ignore
    public void getURL_success() {

    }

    @Test
    @Ignore
    public void getURL_pathIsNull_throwsNullPointerException() {

    }
}