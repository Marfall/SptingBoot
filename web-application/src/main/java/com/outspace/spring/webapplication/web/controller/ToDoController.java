package com.outspace.spring.webapplication.web.controller;


import com.outspace.spring.webapplication.web.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;

@Controller
@SessionAttributes("name")
public class ToDoController {

    @Autowired
    ToDoService service;

    @GetMapping("/list-todos")
    public String showToDos(ModelMap model) {
        String name = (String)model.get("name");
        model.put("todos", service.retrieveToDos(name));
        return "list-todos";
    }

    @GetMapping("/add-todo")
    public String addToDo(ModelMap model) {
        return "todo";
    }

    @PostMapping("/add-todo")
    public String addToDoPage(ModelMap model, @RequestParam String desc) {
        service.addTodo((String)model.get("name"), desc, new Date(), false);
        return  "redirect:/list-todos";
    }

    @GetMapping("/delete-todo")
    public String deleteToDo(@RequestParam int id) {
        service.deleteTodo(id);
        return "redirect:/list-todos";
    }

}
