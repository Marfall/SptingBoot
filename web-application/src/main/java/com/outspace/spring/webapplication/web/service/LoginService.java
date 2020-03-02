package com.outspace.spring.webapplication.web.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean validateUser(String userid, String password) {

        return  userid.equalsIgnoreCase("Marfall")
                && password.equalsIgnoreCase("Marfall");
    }
}
