package com.springboot.my.org.crudapi.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.my.org.crudapi.model.Bonus;
import com.springboot.my.org.crudapi.repository.BonusRepository;

@Service
public class BonusService {
	
	@Autowired
	BonusRepository bonusRepo;
	
	public Bonus getBonusById(Integer id) {
		try {
			return bonusRepo.findBonusById(id);
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Bonus> getBonusByDept(String dept) {
		try {
			return bonusRepo.findBonusByDept(dept);
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Bonus> getAllBonus() {
		try{
			return bonusRepo.findAllBonus();
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean createBonus(Bonus bonus) {
		try{
			return bonusRepo.addBonus(bonus);			
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}		
	}

	public boolean deleteBonusById(Integer id) {
		try {
			return bonusRepo.deleteBonusById(id);			
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
