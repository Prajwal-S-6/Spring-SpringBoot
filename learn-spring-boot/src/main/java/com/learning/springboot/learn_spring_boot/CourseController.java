package com.learning.springboot.learn_spring_boot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/spring")
public class CourseController {

    @GetMapping("/courses")
    // url to retrieve will be /spring/courses
    public List<Course> retrieveAllCourses() {
        return Arrays.asList(
                new Course(1, "Learn AWS", "Udemy"),
                new Course(2, "Learn Devops", "Udemy"),
                new Course(3, "Learn Azure", "Udemy"),
                new Course(4, "Learn Kubernetes", "Udemy"),
                new Course(5, "Learn Docker", "Udemy")
        );
    }

}
