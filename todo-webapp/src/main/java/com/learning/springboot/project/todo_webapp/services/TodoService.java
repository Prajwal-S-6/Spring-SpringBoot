package com.learning.springboot.project.todo_webapp.services;

import com.learning.springboot.project.todo_webapp.Todo;
import com.learning.springboot.project.todo_webapp.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static  int todosCount = 0;

    @Autowired
    private TodoRepository todoRepository;



    public List<Todo> findByUserName(String userName) {
        return todoRepository.findByUsername(userName);
    }

    public void initializeTodo() {
        todoRepository.save(new Todo(++todosCount, "Prajwal", "Learn AWS", LocalDate.now().plusYears(1), false));
        todoRepository.save(new Todo(++todosCount, "Prajwal", "Learn DevOps", LocalDate.now().plusYears(2), false));
        todoRepository.save(new Todo(++todosCount, "Prajwal", "Learn Web Development", LocalDate.now().plusYears(3), false));
    }

    public void addTodo(String userName, String description, LocalDate date, boolean isDone) {
        todoRepository.save(new Todo(++todosCount, userName, description, date, isDone));
    }


}
