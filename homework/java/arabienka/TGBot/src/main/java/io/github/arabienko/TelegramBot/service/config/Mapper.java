package io.github.arabienko.TelegramBot.service.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.management.openmbean.OpenMBeanAttributeInfoSupport;

@Configuration
public class Mapper {
    @Bean
    public ObjectMapper objectMapper(){
        ObjectMapper objectMapper=new ObjectMapper();

        return objectMapper;
    }

}
