package com.springboot.my.org.crudapi.dao;

import java.sql.*;
import java.util.List;
import java.util.Map;

import com.springboot.my.org.crudapi.model.Worker;

public interface WorkerDAO {
        public boolean insertWorker(Worker worker) throws SQLException;

        public boolean deleteWorkerById(int workerId) throws SQLException;

        public Worker findWorkerById(int workerId) throws SQLException;

        public List<Worker> findAllWorkers() throws SQLException;

        public boolean replaceWorker(Worker worker) throws SQLException;
        
        public boolean updateWorkerEmailById(int id,String email) throws SQLException;
        
        public List<Map<String,String>> getAllCombinedDetails() throws SQLException;
        
        public List<Map<String,String>> getAllCombinedDetailsByDept(String dept) throws SQLException;
}