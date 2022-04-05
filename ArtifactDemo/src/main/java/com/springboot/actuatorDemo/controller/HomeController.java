package com.springboot.actuatorDemo.controller;

import java.util.Date;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public String index() {
		Date date = new Date();
		String result = "Hello visitor! \nVisiting Time: "+date;
		return result;
	}
}
