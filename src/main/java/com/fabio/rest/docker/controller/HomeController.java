package com.fabio.rest.docker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabio.rest.docker.services.DockerService;

@RestController
@RequestMapping(value="docker/")
public class HomeController {
	@Autowired
	private DockerService dockerService;
	
	@GetMapping("get/id")
	public String getId() {
		return dockerService.getIdContainer();
	}
}
