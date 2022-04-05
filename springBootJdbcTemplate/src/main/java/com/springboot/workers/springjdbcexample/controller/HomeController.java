package com.springboot.workers.springjdbcexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers.springjdbcexample.util.DateTimeUtilities;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public String index() {
		return "Hello visitor!\nVisiting time: "+DateTimeUtilities.getTimeStamp();
	}
}
