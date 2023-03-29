package com.tss.webapps.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfiguration {
    @Bean(name = "applicationName")
    public String applicationName() {
        return "Sistema de vendas";
    }

}
