package com.outspace.spring.webapplication.web.controller;


import com.outspace.spring.webapplication.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    LoginService service;

    @GetMapping("/login")
    public String loginMessage() {

        return "login";
    }

    @PostMapping("/login")
    public String showWelcomePage(@RequestParam String name, String password, ModelMap model) {

        if (!service.validateUser(name, password)) {
            model.put("errorMessage", "Wrong credentials, try again");
            return "login";
        } else {
            model.put("name", name);
            model.put("password", password);
            return "welcome";
        }
    }
}
