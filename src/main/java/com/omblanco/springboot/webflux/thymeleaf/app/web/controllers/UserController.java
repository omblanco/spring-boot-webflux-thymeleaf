package com.omblanco.springboot.webflux.thymeleaf.app.web.controllers;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.omblanco.springboot.webflux.api.client.dto.UserFilterDTO;
import com.omblanco.springboot.webflux.thymeleaf.app.web.services.UserService;

import lombok.AllArgsConstructor;

/**
 * Controlador que recupera la información de los usuarios 
 * @author ombla
 *
 */

@AllArgsConstructor
@Controller
@RequestMapping
public class UserController {
    
    private UserService userService;

    @GetMapping({ "/users"})
    public String getUsers(Model model, Pageable pageable) {
        
        model.addAttribute("mongoUsers", userService.getMongoUsers(new UserFilterDTO(), pageable));
        model.addAttribute("mySqlUsers", userService.getMySqlUsers(new UserFilterDTO(), pageable));
        
        return "users/index";
    }
}
