package com.omblanco.springboot.webflux.thymeleaf.app.web.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.omblanco.springboot.webflux.thymeleaf.app.web.dtos.AppInfoDTO;

/**
 * Controlador del estado de la aplicación
 * @author oscar.martinezblanco
 *
 */
@Controller
@RequestMapping
public class AppInfoController {

    @Value("${app.version}")
    private String appVersion;
    
    @Value("${app.environment}")
    private String environment;
    
    @Value("${app.name}")
    private String name;
    
    /**
     * Recupera el estado de la aplicación
     * @return
     */
    @GetMapping({ "/"})
    public String getAppInfo(Model model) {
        
        AppInfoDTO appInfoDto = new AppInfoDTO();
        appInfoDto.setEnvironment(environment);
        appInfoDto.setVersion(appVersion);
        appInfoDto.setNow(new Date());
        appInfoDto.setName(name);
        
        model.addAttribute("appinfo", appInfoDto);
        
        return "index";
    }
}
