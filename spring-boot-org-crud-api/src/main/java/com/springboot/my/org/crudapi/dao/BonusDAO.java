package com.springboot.my.org.crudapi.dao;

import java.sql.*;
import java.util.List;

import com.springboot.my.org.crudapi.model.Bonus;

public interface BonusDAO {
	public boolean addBonus(Bonus bonus) throws SQLException;
	
	public boolean deleteBonusById(int workerRefId) throws SQLException;

    public Bonus findBonusById(int workerRefId) throws SQLException;
    
    public List<Bonus> findBonusByDept(String dept) throws SQLException;

    public List<Bonus> findAllBonus() throws SQLException;

    public boolean replaceBonus(Bonus bonus) throws SQLException;
}