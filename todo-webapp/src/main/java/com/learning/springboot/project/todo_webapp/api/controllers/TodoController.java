package com.learning.springboot.project.todo_webapp.api.controllers;

import com.learning.springboot.project.todo_webapp.Todo;
import com.learning.springboot.project.todo_webapp.repositories.TodoRepository;
import com.learning.springboot.project.todo_webapp.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;

@Controller
@SessionAttributes("username")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(value="todo-list", method = RequestMethod.GET)
    public String getTodoList(ModelMap modelMap) {
        todoService.initializeTodo();
        var todos = todoService.findByUserName("Prajwal");
        modelMap.addAttribute("todos", todos);
        return "todos";
    }


    @RequestMapping(value="add-todo", method = RequestMethod.GET)
    public String addNewTodo() {
        return "add-todos";
    }

    @RequestMapping(value="add-todo", method = RequestMethod.POST)
    public String saveTodo(ModelMap model, Todo todo) {
        todoService.addTodo(model.get("username").toString(), todo.getDescription(), LocalDate.now().plusDays(60), false);
        return "redirect:todo-list";
    }


}
