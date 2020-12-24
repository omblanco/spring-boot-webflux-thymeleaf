package com.omblanco.springboot.webflux.thymeleaf.app.web.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.omblanco.springboot.webflux.api.client.ReactiveUsersClient;
import com.omblanco.springboot.webflux.api.client.impl.ReactiveUsersClientBuilder;

/**
 * Clase de configuración de los beans de los clientes del servicio de usuarios
 * @author ombla
 *
 */
@Configuration
public class UserClientConfig {
    
    @Value("${mongo.user}")
    private String mongoUser;

    @Value("${mongo.password}")
    private String mongoPassword;
    
    @Value("${mongo.endpoint}")
    private String mongoEndpoint;
    
    @Value("${mysql.user}")
    private String mySqlUser;

    @Value("${mysql.password}")
    private String mySqlPassword;
    
    @Value("${mysql.endpoint}")
    private String mySqlEndpoint;
    
    
    @Bean("mongoUserClient")
    public ReactiveUsersClient<String> mongoUserClient() {
        return ReactiveUsersClientBuilder.build(mongoUser, mongoPassword, mongoEndpoint);
    }
    
    @Bean("mySqlUserClient")
    public ReactiveUsersClient<Long> mySqlUserClient() {
        return ReactiveUsersClientBuilder.build(mySqlUser, mySqlPassword, mySqlEndpoint);
    }
}
