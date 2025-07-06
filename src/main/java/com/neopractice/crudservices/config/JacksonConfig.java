package com.neopractice.crudservices.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

@Configuration
public class JacksonConfig {
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        JavaTimeModule module = new JavaTimeModule();
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                .appendOptional(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                .toFormatter();
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer(formatter));
        mapper.registerModule(module);
        return mapper;
    }
}
