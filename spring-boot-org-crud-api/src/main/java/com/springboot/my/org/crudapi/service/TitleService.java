package com.springboot.my.org.crudapi.service;

import java.sql.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.my.org.crudapi.model.Title;
import com.springboot.my.org.crudapi.repository.TitleRepository;

@Service
public class TitleService {

	@Autowired
	TitleRepository titleRepo;
	
	public boolean addTitle(Title title) {
		try {
			return titleRepo.insertTitle(title);
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteTitleById(int workerRefId) {
		try {
			return titleRepo.deleteTitleById(workerRefId);
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

    public Title findTitleById(int workerRefId) {
    	try {
    		return titleRepo.findTitleById(workerRefId);
    	} catch(SQLException e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    
    public List<Title> findTitleByDept(String dept) {
    	try {
    		return titleRepo.findTitleByDept(dept);
    	} catch(SQLException e) {
    		e.printStackTrace();
    		return null;
    	}
    }

    public List<Title> findAllTitles() {
    	try{
    		return titleRepo.findAllTitles();
    	} catch(SQLException e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    
    public boolean createTitle(int id, String title) {
    	try {
    		return titleRepo.createTitleById(id, title);
    	} catch(SQLException e) {
    		e.printStackTrace();
    		return false;
    	}
    }
}
