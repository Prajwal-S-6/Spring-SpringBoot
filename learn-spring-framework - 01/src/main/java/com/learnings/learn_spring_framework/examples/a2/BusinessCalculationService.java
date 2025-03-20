package com.learnings.learn_spring_framework.examples.a2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Service
@ComponentScan
public class BusinessCalculationService {
    // -- Field @Autowired based DI--
//    @Autowired
//    @Qualifier("MongoDbDataServiceQualifier")
    private DbDataService dbdata;

    // --constructor based DI--
    public BusinessCalculationService(@Qualifier("MongoDbDataServiceQualifier") DbDataService dbData) {
        this.dbdata = dbData;
    }

    public int findMax() {
        return Arrays.stream(dbdata.retrieveData()).max().orElse(0);
    }
}
