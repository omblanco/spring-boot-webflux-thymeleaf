package com.omblanco.springboot.webflux.thymeleaf.app.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import reactor.core.publisher.Flux;

/**
 * Controlador que recupera la información de los usuarios 
 * @author ombla
 *
 */
@Controller
@RequestMapping
public class UserController {

    @GetMapping({ "/users"})
    public String getUsers(Model model) {
        
        
        model.addAttribute("users", Flux.empty());
        
        return "users/index";
    }
}
