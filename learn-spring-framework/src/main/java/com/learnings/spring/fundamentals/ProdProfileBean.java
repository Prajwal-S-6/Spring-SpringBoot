package com.learnings.spring.fundamentals;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class ProdProfileBean implements ProfileBean{
}
