package com.outspace.spring.webapplication.web.controller;


import com.outspace.spring.webapplication.web.model.ToDo;
import com.outspace.spring.webapplication.web.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@SessionAttributes("name")
public class ToDoController {

    @Autowired
    ToDoService service;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date - dd/MM/yyyy
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false
        ));
    }

    @GetMapping("/list-todos")
    public String showToDos(ModelMap model) {
        String name = getLoggedUserName(model);
        model.put("todos", service.retrieveToDos(name));
        return "list-todos";
    }

    private String getLoggedUserName(ModelMap model) {
        return (String) model.get("name");
    }

    @GetMapping("/add-todo")
    public String addToDo(ModelMap model) {
        model.addAttribute("todo", new ToDo(0, getLoggedUserName(model), "Default Desc", new Date(), false));
        return "todo";
    }

    @PostMapping("/add-todo")
    public String addToDoPage(ModelMap model, @ModelAttribute("todo") @Valid  ToDo todo, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("ERROR!!!");
            return "todo";
        } else {
            service.addTodo(getLoggedUserName(model), todo.getDesc(), todo.getTargetDate(), false);
            return "redirect:/list-todos";
        }
    }

    @GetMapping("/delete-todo")
    public String deleteToDo(@RequestParam int id) {
        service.deleteTodo(id);
        return "redirect:/list-todos";
    }

    @GetMapping("/update-todo")
    public String showUpdateToDoPage(@RequestParam int id, ModelMap model) {
        ToDo todo = service.retrieveToDo(id);
        model.put("todo", todo);
        return "todo";
    }

    @PostMapping("/update-todo")
    public String updateToDo(@Valid @ModelAttribute("todo") ToDo todo, BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "todo";
        }
        todo.setUser(getLoggedUserName(model));
        service.updateToDo(todo);
        return "redirect:/list-todos";
    }
}
