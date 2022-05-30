package com.fabio.rest.docker.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.fabio.rest.docker.controller","com.fabio.rest.docker.services"})
public class DockerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerServiceApplication.class, args);

	}

}
