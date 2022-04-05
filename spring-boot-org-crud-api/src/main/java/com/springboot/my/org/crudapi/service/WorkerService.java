package com.springboot.my.org.crudapi.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.my.org.crudapi.model.Worker;
import com.springboot.my.org.crudapi.repository.WorkerRepository;

@Service
public class WorkerService {
	
	@Autowired
	WorkerRepository workerRepo;
	
	public Worker getWorker(Integer id) {
		try {
			return workerRepo.findWorkerById(id);
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	

	public List<Worker> getWorkers() {
		try{
			return workerRepo.findAllWorkers();
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean createWorker(Worker worker) {
		try{
			return workerRepo.insertWorker(worker);
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}		
	}

	public boolean updateWorker(Integer id, String email) {
		try {
			return workerRepo.updateWorkerEmailById(id,email);
		} catch(SQLException e) {
			e.printStackTrace();	
			return false;
		}
	}

	public boolean deleteWorkerById(Integer id) {
		try {
			return workerRepo.deleteWorkerById(id);
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Map<String,String>> getCombinedDetails() {
		try {
			return workerRepo.getAllCombinedDetails();
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Map<String,String>> getCombinedDetailsByDept(String dept) {
		try {
			return workerRepo.getAllCombinedDetailsByDept(dept);
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
