package com.example.mockito.demo_mockito.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeBusinessImplTestUsingStub {

    DataService dataServiceStub = new DataServiceStub();
    SomeBusinessImpl business = new SomeBusinessImpl(dataServiceStub);
    @Test
    void shouldFindLargestElementFromData() {
        assertEquals(85, business.findLargestFromAllData());
    }
}

class DataServiceStub implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {25, 66, 85};
    }
}