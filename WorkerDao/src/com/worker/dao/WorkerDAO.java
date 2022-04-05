package com.worker.dao;

import com.worker.model.Worker;
import java.sql.*;
import java.util.List;

public interface WorkerDAO {
        public int add(Worker worker)
                        throws SQLException;

        public void delete(int workerId)
                        throws SQLException;

        public Worker getWorker(int workerId)
                        throws SQLException;

        public List<Worker> getWorkers()
                        throws SQLException;

        public void update(Worker worker)
                        throws SQLException;
}