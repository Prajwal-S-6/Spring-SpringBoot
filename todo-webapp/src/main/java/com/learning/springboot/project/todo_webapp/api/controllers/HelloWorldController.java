package com.learning.springboot.project.todo_webapp.api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorldController {
    // @GetMapping("/")
    @RequestMapping(value = "say-hello", method = RequestMethod.GET)
    @ResponseBody
    public String sayHello() {
        return "Hello";
    }

    @GetMapping("say-hello-html")
    @ResponseBody
    public String sayHelloHtml() {
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>My first html page</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("<p>Hello from HTML</p>");
        sb.append("</body>");
        sb.append("</html>");
        return sb.toString();
    }

    @RequestMapping("say-hello-jsp")
    // path -- /src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
    public String sayHelloJsp() {
        return "sayHello";
    }
}
