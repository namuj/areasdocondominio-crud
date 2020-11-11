package com.example.crud.areasdocondominio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EntityScan(basePackages= {"com.example.crud.areasdocondominio.model"})
@ComponentScan(basePackages= {"com.example.crud.*"})
@EnableJpaRepositories(basePackages= {"com.example.crud.areasdocondominio.repository"})
@EnableTransactionManagement
@EnableWebMvc
@RestController
@EnableAutoConfiguration
public class AreasdocondominioApplication {

	public static void main(String[] args) {
		SpringApplication.run(AreasdocondominioApplication.class, args);
	}

}
