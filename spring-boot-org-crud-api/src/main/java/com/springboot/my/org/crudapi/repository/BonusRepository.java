package com.springboot.my.org.crudapi.repository;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.springboot.my.org.crudapi.dao.BonusDAO;
import com.springboot.my.org.crudapi.model.Bonus;
import com.springboot.my.org.crudapi.util.DataBaseConnection;

@Repository
public class BonusRepository implements BonusDAO {
	private final Connection con;
    
    public BonusRepository() throws SQLException {
        this.con = DataBaseConnection.getConnection();
    }
    
    @Override
    public boolean addBonus(Bonus bonus) throws SQLException {
    	String sql = "insert into bonus values (?,?,?)";
    	
    	PreparedStatement prep = con.prepareStatement(sql);
    	prep.setInt(1,bonus.getWorkerRefId());
    	prep.setInt(2, bonus.getBonusAmount());
    	prep.setDate(3,bonus.getBonusDate());
    	
    	int col = prep.executeUpdate();
    	System.out.println(col+" row added");
    	return col==1;
    }
	
    @Override
	public boolean deleteBonusById(int workerRefId) throws SQLException {
		String sql = "delete from bonus where worker_ref_id=" + workerRefId + " order by bonus_date desc limit 1";
		
		Statement state = con.createStatement();
		int rowDel = state.executeUpdate(sql);
		System.out.println(rowDel + " row deleted");
		return rowDel==1;
	}

    @Override
    public Bonus findBonusById(int workerRefId) throws SQLException {
    	String sql = "select * from bonus where worker_ref_id="+workerRefId;
    	Bonus bonus = null;
    	Statement state = con.createStatement();
    	ResultSet res = state.executeQuery(sql);
    	
    	while (res.next()) {
    		int id = res.getInt(1);
    		int amount = res.getInt(2);
    		Date date = res.getDate(3);
    		
    		bonus = new Bonus(id,amount,date);
    	}
    	return bonus;
    }
    
    @Override
    public List<Bonus> findBonusByDept(String dept) throws SQLException {
    	String sql = String.format("""
    			select worker_ref_id,
    			bonus_amount,
    			bonus_date from worker inner join bonus
    			on worker_id = worker_ref_id 
    			where department = "%s"
    			""",dept);
    	
    	List<Bonus> ls = new ArrayList<>();
    	Bonus bonus = null;
    	Statement state = con.createStatement();
    	ResultSet res = state.executeQuery(sql);
    	
    	while (res.next()) {
    		int id = res.getInt(1);
    		int amount = res.getInt(2);
    		Date date = res.getDate(3);
    		
    		bonus = new Bonus(id,amount,date);
    		ls.add(bonus);
    	}
    	return ls;
    }

    @Override
    public List<Bonus> findAllBonus() throws SQLException {
    	String sql = "select * from bonus";
    	
    	List<Bonus> ls = new ArrayList<>();
    	Bonus bonus = null;
    	Statement state = con.createStatement();
    	ResultSet res = state.executeQuery(sql);
    	
    	while (res.next()) {
    		int id = res.getInt(1);
    		int amount = res.getInt(2);
    		Date date = res.getDate(3);
    		
    		bonus = new Bonus(id,amount,date);
    		ls.add(bonus);
    	}
    	return ls;
    }

    @Override
    public boolean replaceBonus(Bonus bonus) throws SQLException {
    	String update = "update bonus set bonus_amount=?, bonus_date=? where worker_ref_id=?";
        PreparedStatement prep = con.prepareStatement(update);
        prep.setInt(1, bonus.getBonusAmount());
        prep.setDate(2, bonus.getBonusDate());
        prep.setInt(3, bonus.getWorkerRefId());

        int rowCount = prep.executeUpdate();
        System.out.println(rowCount + " row updated");        
        return rowCount==1;      
    }
}
