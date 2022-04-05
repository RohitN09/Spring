package com.springboot.workers.springjdbcexample.dao;

import com.springboot.workers.springjdbcexample.model.Worker;

import java.sql.*;
import java.util.List;
import javax.sql.DataSource;

public interface WorkerDAO {
	
	public void add(Worker worker) throws SQLException;

	public void delete(int workerId) throws SQLException;

	public Worker getWorker(int workerId) throws SQLException;

	public List<Worker> getWorkers() throws SQLException;

	public void update(Worker worker) throws SQLException;
}