package com.portfolio.Lucas.Ortega;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@SpringBootApplication
public class LucasOrtegaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LucasOrtegaApplication.class, args);
	}

}