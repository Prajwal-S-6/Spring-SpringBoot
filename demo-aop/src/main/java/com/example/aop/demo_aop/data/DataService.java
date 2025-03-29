package com.example.aop.demo_aop.data;

import org.springframework.stereotype.Service;

@Service
public class DataService {

    public int[] retrieveData() throws InterruptedException {
        Thread.sleep(30);
        return new int[]{11, 22, 33};
    }
}
