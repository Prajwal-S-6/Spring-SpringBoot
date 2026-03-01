package com.learnings.spring.fundamentals;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"dev", "test"})
public class DevProfileBean implements ProfileBean {
}
