package com.learnings.learn_spring_framework.examples.a2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Repository
@Qualifier("MongoDbDataServiceQualifier")
public class MongoDbDataService implements DbDataService {
    @Override
    public int[] retrieveData() {
        return new int[] {11, 22, 33, 44, 55};
    }
}
