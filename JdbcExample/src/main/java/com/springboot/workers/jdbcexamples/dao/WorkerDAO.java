package com.springboot.workers.jdbcexamples.dao;

import java.sql.*;
import java.util.List;

import com.springboot.workers.jdbcexamples.model.Worker;

public interface WorkerDAO {
        public int add(Worker worker) throws SQLException;

        public void delete(int workerId) throws SQLException;

        public Worker getWorker(int workerId) throws SQLException;

        public List<Worker> getWorkers() throws SQLException;

        public void update(Worker worker) throws SQLException;
}