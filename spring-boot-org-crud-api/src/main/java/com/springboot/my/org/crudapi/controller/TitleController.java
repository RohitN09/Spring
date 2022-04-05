package com.springboot.my.org.crudapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.my.org.crudapi.service.TitleService;
import com.springboot.my.org.crudapi.model.Title;

@RestController
public class TitleController {
	
	@Autowired
	TitleService titleService;
	
	@GetMapping("/worker/title/{id}")
	public Title showTitle(@PathVariable int id) {
		return titleService.findTitleById(id);
	}
	
	@GetMapping("worker/title/all")
	public List<Title> showAllTitles() {
		return titleService.findAllTitles();
	}
	
	@GetMapping("dept/{dept}/all")
	public List<Title> showAllDeptTitle(@PathVariable String dept) {
		return titleService.findTitleByDept(dept);
	}
	
	@PostMapping("worker/{id}/promote/{title}")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean create(@PathVariable int id, @PathVariable String title) {
		return titleService.createTitle(id, title);	
	}
	
	@DeleteMapping("worker/{id}/demote")
	public boolean delete(@PathVariable int id) {
		return titleService.deleteTitleById(id);
	}
	
}
