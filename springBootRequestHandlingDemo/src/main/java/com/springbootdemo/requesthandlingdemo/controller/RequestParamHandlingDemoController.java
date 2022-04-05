package com.springbootdemo.requesthandlingdemo.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestParamHandlingDemoController {
	
	@GetMapping("/showName")
	public String showName(@RequestParam String firstName, @RequestParam String lastName) {
		return String.format("First Name: %s</br>Last Name: %s",firstName,lastName);
	}
	
	@GetMapping("/showNamePartly")
	public String showNamePartly(@RequestParam String firstName, @RequestParam(required=false) String lastName) {
		return String.format("First Name: %s</br>Last Name: %s",firstName,lastName);
	}
	
	@GetMapping("/showNameOptional")
	public String showNameOptional(@RequestParam String firstName, @RequestParam Optional<String> lastName) {
		return String.format("First Name: %s</br>Last Name: %s",firstName,lastName);
	}
	
	@GetMapping("/showNameWithDefaults")
	public String showNameWithDefaults(@RequestParam(defaultValue="NA") String firstName, @RequestParam Optional<String> lastName) {
		return String.format("First Name: %s</br>Last Name: %s",firstName,lastName.orElseGet(() -> "Not Provided"));
	}
	
	@GetMapping("/showAllParams")
	public String showAllParams(@RequestParam Map<String,String> allParams) {
		return "Parameters:: "+allParams.entrySet();
	}
}
