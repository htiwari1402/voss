package voss.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import voss.domain.Designation;
import voss.domain.UserEntity;

public class userRegDao extends DAO {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Designation> getAllDesign()
	{
		String SQL= "select * from designations";
		return this.jt.query(SQL,new  RowMapper()
				{

					@Override
					public Designation  mapRow(ResultSet rs, int rn) throws SQLException 
					{
					    return new Designation(rs.getString("designation"),rs.getInt("designationId"));
					}
			
				});
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<UserEntity> getAllUsers()
	{
		String SQL= "select * from userregistration";
		return this.jt.query(SQL,new  RowMapper()
				{

					@Override
					public UserEntity  mapRow(ResultSet rs, int rn) throws SQLException 
					{
					    return new UserEntity(rs.getString("designation"),rs.getString("name"),rs.getString("reportingManager"),rs.getString("userName"),
					    		rs.getString("password"));
					}
			
				});
	}

}
