package com.springboot.my.org.crudapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.my.org.crudapi.service.BonusService;
import com.springboot.my.org.crudapi.model.Bonus;

@RestController
public class BonusController {
	
	@Autowired
	BonusService bonusService;
	
	@GetMapping("/worker/bonus/{id}")
	public Bonus showBonus(@PathVariable int id) {
		return bonusService.getBonusById(id);
	}
	
	@GetMapping("worker/bonus/all")
	public List<Bonus> showAllBonus() {
		return bonusService.getAllBonus();
	}
	
	@GetMapping("dept/{dept}/bonuses")
	public List<Bonus> showAllDeptBonus(@PathVariable String dept) {
		return bonusService.getBonusByDept(dept);
	}
	
	@PostMapping("worker/{id}/bonus/new")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean create(@RequestBody Bonus bonus) {
		return bonusService.createBonus(bonus);	
	}
	
	@DeleteMapping("worker/{id}/bonus/latest")
	public boolean delete(@PathVariable int id) {
		return bonusService.deleteBonusById(id);
	}
}