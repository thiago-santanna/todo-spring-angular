package com.tsswebapps.todo.configuration;

import com.tsswebapps.todo.services.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("test")
public class TestConfig {
    @Autowired
    private DbService dbService;

    @Bean
    public boolean instancia() {
        try {
            return this.dbService.instaciaBaseDeDados();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
