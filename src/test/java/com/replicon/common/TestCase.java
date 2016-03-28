package com.replicon.common;

import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.mockito.stubbing.Stubber;

public class TestCase extends TestData {

    public static <T> OngoingStubbing<T> when(T methodCall) {
	return Mockito.when(methodCall);
    }

    public static Stubber doReturn(Object toBeReturned) {
	return Mockito.doReturn(toBeReturned);
    }

    public <T> T verify(T object) {
	return Mockito.verify(object);
    }
}
