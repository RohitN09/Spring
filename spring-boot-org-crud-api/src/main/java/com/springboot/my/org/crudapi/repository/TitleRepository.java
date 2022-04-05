package com.springboot.my.org.crudapi.repository;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.springboot.my.org.crudapi.dao.TitleDAO;
import com.springboot.my.org.crudapi.model.Title;
import com.springboot.my.org.crudapi.util.DataBaseConnection;

@Repository
public class TitleRepository implements TitleDAO {
	private final Connection con;
    
    public TitleRepository() throws SQLException {
        this.con = DataBaseConnection.getConnection();
    }
    
    @Override
    public boolean insertTitle(Title title) throws SQLException {
    	String sql = "insert into title values (?,?,?)";
    	
    	PreparedStatement prep = con.prepareStatement(sql);
    	prep.setInt(1,title.getWorkerRefId());
    	prep.setString(2,title.getWorkerTitle());
    	prep.setDate(3,title.getAffectedFrom());
    	
    	int col = prep.executeUpdate();
    	System.out.println(col+" row added");
    	return col==1;
    }
	
    @Override
	public boolean deleteTitleById(int workerRefId) throws SQLException {
		String sql = "delete from title where worker_ref_id=" + workerRefId + " order by affected_from desc limit 1";
		
		Statement state = con.createStatement();
		int rowDel = state.executeUpdate(sql);
		System.out.println(rowDel + " row deleted");
		return rowDel==1;
	}

    @Override
    public Title findTitleById(int workerRefId) throws SQLException {
    	String sql = "select * from title where worker_ref_id=" + workerRefId;
    	Title title = null;
    	Statement state = con.createStatement();
    	ResultSet res = state.executeQuery(sql);
    	
    	while (res.next()) {
    		int id = res.getInt(1);
    		String wTitle = res.getString(2);
    		Date date = res.getDate(3);
    		
    		title = new Title(id,wTitle,date);
    	}
    	return title;
    }
    
    @Override
    public List<Title> findTitleByDept(String dept) throws SQLException {
    	String sql = String.format("""
    			select worker_id, worker_title, affected_from
    			from worker inner join title
    			on worker_id = worker_ref_id
    			where department = "%s"
       			""",dept);
    	
    	List<Title> ls = new ArrayList<>();
    	Title title = null;
    	Statement state = con.createStatement();
    	ResultSet res = state.executeQuery(sql);
    	
    	while (res.next()) {
    		int id = res.getInt(1);
    		String wTitle = res.getString(2);
    		Date date = res.getDate(3);
    		
    		title = new Title(id,wTitle,date);
    		ls.add(title);   	}
    	return ls;
    }

    @Override
    public List<Title> findAllTitles() throws SQLException {
    	String sql = "select * from title";
    	
    	List<Title> ls = new ArrayList<>();
    	Title title = null;
    	Statement state = con.createStatement();
    	ResultSet res = state.executeQuery(sql);
    	
    	while (res.next()) {
    		int id = res.getInt(1);
    		String wTitle = res.getString(2);
    		Date date = res.getDate(3);
    		
    		title = new Title(id,wTitle,date);
    		ls.add(title);
    	}
    	return ls;
    }
    
    @Override
    public boolean replaceTitle(Title title) throws SQLException {
    	String update = "update title set worker_title=?, affected_from=? where worker_ref_id=?";
        PreparedStatement prep = con.prepareStatement(update);
        prep.setString(1, title.getWorkerTitle());
        prep.setDate(2, title.getAffectedFrom());
        prep.setInt(3, title.getWorkerRefId());

        int rowCount = prep.executeUpdate();
        System.out.println(rowCount + " row updated");
        
        return rowCount==1;      
    }
    	
    @Override
    public boolean createTitleById(int id, String title) throws SQLException {
    	Date date = new Date(System.currentTimeMillis());
    	String update = "insert into title values (?,?,?)";
    	PreparedStatement prep = con.prepareStatement(update);
        prep.setInt(1, id);
        prep.setString(2, title);
        prep.setDate(3, date);
        
        int rowCount = prep.executeUpdate();
        return rowCount==1;
    }
}
