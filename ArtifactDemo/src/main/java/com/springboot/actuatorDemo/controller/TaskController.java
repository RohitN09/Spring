package com.springboot.actuatorDemo.controller;

import com.springboot.model.Worker;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/worker")
public class TaskController {
	
	@GetMapping("/showWorker")
	public Worker getWorker() {
		return new Worker(101,"Rohit",5000);
	}
	
	@GetMapping("/all/showWorkers")
	public List<Worker> getWorkers(){
		Worker w1 = new Worker(101,"Rohit",5000);
		Worker w2 = new Worker(102,"Gaurav",7000);
		Worker w3 = new Worker(103,"Karan",6000);
		
		List<Worker> workers = List.of(w1,w2,w3);
		
		return workers;
	}
}
