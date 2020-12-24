package com.omblanco.springboot.webflux.thymeleaf.app.web.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.omblanco.springboot.webflux.api.client.ReactiveUsersClient;
import com.omblanco.springboot.webflux.api.client.dto.RestResponsePage;
import com.omblanco.springboot.webflux.api.client.dto.UserDTO;
import com.omblanco.springboot.webflux.api.client.dto.UserFilterDTO;
import com.omblanco.springboot.webflux.thymeleaf.app.web.services.UserService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * Implemetación del servicio de usuarios
 * @author ombla
 *
 */
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private ReactiveUsersClient<String> mongoUserClient;
    
    private ReactiveUsersClient<Long> mySqlUserClient;

    @Override
    public Mono<Page<UserDTO<Long>>> getMySqlUsers(UserFilterDTO filter, Pageable pageable) {
        return mySqlUserClient.getUsers(filter, pageable).map(this::convertMySqlResponsePageToPage);
    }

    @Override
    public Mono<Page<UserDTO<String>>> getMongoUsers(UserFilterDTO filter, Pageable pageable) {
        return mongoUserClient.getUsers(filter, pageable).map(this::convertMongoResponsePageToPage);
    }
    
    private Page<UserDTO<Long>> convertMySqlResponsePageToPage(RestResponsePage<UserDTO<Long>> requestPage) {
        return new PageImpl<>(requestPage.getContent(), requestPage.getPageable(), requestPage.getTotalElements());
    }
    
    private Page<UserDTO<String>> convertMongoResponsePageToPage(RestResponsePage<UserDTO<String>> requestPage) {
        return new PageImpl<>(requestPage.getContent(), requestPage.getPageable(), requestPage.getTotalElements());
    }
}
