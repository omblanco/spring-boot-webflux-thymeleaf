package com.omblanco.springboot.webflux.thymeleaf.app.web.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Clase con la información del estado de la aplicación
 * @author oscar.martinezblanco
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AppInfoDTO {

    private String environment;
    
    private String version;
    
    private String name;
    
    private Date now;
}
