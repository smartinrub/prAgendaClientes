package com.sergio.pragendaclientes.controllers;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping("/resource")
    public Map<String, Object> home() {
        Map<String, Object> model = new HashMap<>();
        model.put("content", "Bienvenido");
        return model;
    }

    @RequestMapping("/user")
    public Principal page(Principal user) {
        return user;
    }

}
