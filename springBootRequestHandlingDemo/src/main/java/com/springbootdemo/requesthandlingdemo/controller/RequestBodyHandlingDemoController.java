package com.springbootdemo.requesthandlingdemo.controller;

import com.springbootdemo.requesthandlingdemo.model.User;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestBodyHandlingDemoController {
	
	@PostMapping("/showCredentials")
	public User showCredentials(@RequestBody User user) {
		return user;
	}
	
	@PostMapping("/showRequestBody")
	@ResponseStatus(HttpStatus.CREATED)
	public Map<String,String> showRequestBody(@RequestBody Map<String, String> requestBody) {
		return requestBody;
	}
}
