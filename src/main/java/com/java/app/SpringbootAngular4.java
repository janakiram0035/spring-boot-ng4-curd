package com.java.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication(scanBasePackages = "com.java")
@ComponentScan(basePackages = "com.java")
@EnableJpaRepositories(basePackages= { "com.java.repository"})
@EnableElasticsearchRepositories(basePackages= {"com.java.repository.search"})
@EntityScan(basePackages="com.java.domain")
public class SpringbootAngular4 {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAngular4.class, args);
	}

	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter()  {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
            	registry.addMapping("api/*")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST")
                .allowedHeaders("header1", "header2", "header3")
                .exposedHeaders("header1", "header2")
                .maxAge(3600);
            }
        };
    }
}
