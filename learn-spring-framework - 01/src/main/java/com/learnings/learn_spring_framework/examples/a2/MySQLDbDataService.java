package com.learnings.learn_spring_framework.examples.a2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Qualifier("MySQLDbDataServiceQualifier")
public class MySQLDbDataService implements DbDataService {
    @Override
    public int[] retrieveData() {
        return new int[] {1, 2, 3, 4, 5};
    }
}
