package com.springboot.my.org.crudapi.dao;

import java.sql.*;
import java.util.List;

import com.springboot.my.org.crudapi.model.Title;

public interface TitleDAO {
	public boolean insertTitle(Title title) throws SQLException;
	
	public boolean deleteTitleById(int workerRefId) throws SQLException;

    public Title findTitleById(int workerRefId) throws SQLException;
    
    public List<Title> findTitleByDept(String dept) throws SQLException;

    public List<Title> findAllTitles() throws SQLException;

    public boolean replaceTitle(Title title) throws SQLException;
    
    public boolean createTitleById(int id, String title) throws SQLException;
}