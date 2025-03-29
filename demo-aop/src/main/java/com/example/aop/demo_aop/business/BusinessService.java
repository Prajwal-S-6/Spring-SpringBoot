package com.example.aop.demo_aop.business;

import com.example.aop.demo_aop.annotations.TrackTime;
import com.example.aop.demo_aop.data.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService {
    
    @Autowired
    private DataService dataService;

    @TrackTime
    public int calculateMax() throws InterruptedException {
        int[] data = dataService.retrieveData();

//        throw new RuntimeException("Something went wrong");
        return Arrays.stream(data).max().orElse(0);
    }
}
