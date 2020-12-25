package com.omblanco.springboot.webflux.thymeleaf.app.web.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.omblanco.springboot.webflux.api.client.dto.UserDTO;
import com.omblanco.springboot.webflux.api.client.dto.UserFilterDTO;

import reactor.core.publisher.Mono;

/**
 * Interfaz del servicio de usuarios
 * @author ombla
 *
 */
public interface UserService {
    
    /**
     * Recupera los usuarios de MySql
     * @param filter Filtro
     * @param pageable Paginación y ordenación
     * @return Página de usuarios
     */
    Mono<Page<UserDTO<Long>>> getMySqlUsers(UserFilterDTO filter, Pageable pageable);

    /**
     * Recupera los usuarios de Mongo
     * @param filter Filtro
     * @param pageable Paginación y ordenación
     * @return Página de usuarios
     */
    Mono<Page<UserDTO<String>>> getMongoUsers(UserFilterDTO filter, Pageable pageable);

}
