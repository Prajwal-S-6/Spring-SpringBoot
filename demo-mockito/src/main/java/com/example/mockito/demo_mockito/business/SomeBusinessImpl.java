package com.example.mockito.demo_mockito.business;

import java.util.Arrays;
import java.util.OptionalInt;

public class SomeBusinessImpl {

    DataService dataService;

    public SomeBusinessImpl(DataService dataService) {
        this.dataService = dataService;
    }

    public int findLargestFromAllData() {
        int[] data = dataService.retrieveAllData();
        OptionalInt maxValue = Arrays.stream(data).max();
        return maxValue.orElse(Integer.MIN_VALUE);
    }
}

interface DataService {
    int[] retrieveAllData();
}
