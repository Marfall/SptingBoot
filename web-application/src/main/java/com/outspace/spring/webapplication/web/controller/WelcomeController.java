package com.outspace.spring.webapplication.web.controller;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

    @GetMapping("/")
    public String showWelcomePage(ModelMap model) {
        model.put("name", getLoggedInUserName());
        return "welcome";
    }

    private String getLoggedInUserName() {

        Object principal = SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();

        if (principal instanceof UserDetails) {
           return  ((UserDetails) principal).getUsername();
        }
        return principal.toString();
    }
}
