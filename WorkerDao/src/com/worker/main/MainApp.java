package com.worker.main;

import com.worker.util.DBConnection;

import java.sql.*;
import com.worker.model.Worker;
import java.util.List;

import com.worker.dao.WorkerDAO;
import com.worker.dao.WorkerDAOImplementation;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        WorkerDAO workerDao = new WorkerDAOImplementation();
        Worker worker = new Worker(10, "Rohit", "rohit@gmail.com");

        workerDao.add(worker);

        workerDao.delete(10);

        Worker obj = workerDao.getWorker(8);
        System.out.println(obj);

        List<Worker> workers = workerDao.getWorkers();
        workers.forEach(System.out::println);

        Worker updateWorker = new Worker(10, "Rohit", "Nayal", 5000,
                Date.valueOf("2022-03-15"), "SD", "rohit@org.in");
        workerDao.update(updateWorker);

        DBConnection.closeConnection();
    }
}