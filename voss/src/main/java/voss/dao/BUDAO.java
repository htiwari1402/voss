package voss.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import voss.domain.BU;
import voss.domain.Request;
import voss.domain.UserEntity;

public class BUDAO extends DAO {

	  public int getBUMasterSize()
	  {
		  String sql = "select count(*) as cnt  from businessunitmaster";
		  @SuppressWarnings("unchecked")
		int cnt =  (int) this.jt.query(sql,new Object[]{},new  RowMapper()
	        {

	            @Override
	            public Integer  mapRow(ResultSet rs, int rn) throws SQLException 
	            {
	                return rs.getInt("cnt");
	            }
	    
	        }).get(0);
		  return cnt;
	  }
	  
	  @SuppressWarnings("unchecked")
	public List<BU> getBUMaster()
	  {
		  String sql = "select *  from businessunitmaster";
		  
		  return this.jt.query(sql,new Object[]{},new  RowMapper()
	        {

	            @Override
	            public BU  mapRow(ResultSet rs, int rn) throws SQLException 
	            {
	                return new BU(rs.getInt("buID"),rs.getString("code"),rs.getString("name"),rs.getString("status"));
	            }
	    
	        });
	  }
	  public void updateBU(BU bu)
	  {
		  String sql = "update businessunitmaster set code = ?, name = ?, status = ? where buID = ?";
		  this.jt.update(sql, new Object[]{bu.getCode(),bu.getName(),bu.getStatus(),bu.getBuID()});
	  }
}
