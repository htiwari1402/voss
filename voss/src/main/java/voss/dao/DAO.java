package voss.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.core.RowMapper;  

import voss.domain.ProductMaster;
import voss.domain.UserEntity;

public class DAO {
	
	private DriverManagerDataSource ds= null;
	private JdbcTemplate jt = null;

	public DAO()
	{
		this.ds = new DriverManagerDataSource();
		this.ds.setDriverClassName("com.mysql.jdbc.Driver");
		this.ds.setUrl("jdbc:mysql://localhost:3306/voss");
		this.ds.setUsername("vossDB");
		this.ds.setPassword("pass");
		
		this.jt = new JdbcTemplate(this.ds);
	}
	public void addUsers(UserEntity user)
	{
		String SQL = "insert into userregistration (userName, name,designation,reportingManager) values (?, ?,?,?)";
		this.jt.update( SQL, new Object[]{user.getUserName(),user.getName(),user.getDesignation(),user.getReportingManager()});
	}
	@SuppressWarnings("unchecked")
	public List<ProductMaster> getProducts()
	{
		String SQL= "select * from productmaster";
		return this.jt.query(SQL,new  RowMapper()
				{

					@Override
					public ProductMaster  mapRow(ResultSet rs, int rn) throws SQLException 
					{
					    return new ProductMaster(rs.getString("name"),rs.getString("desc"),rs.getString("status"),
					    		rs.getString("grade"),rs.getString("specification"));
					}
			
				});
	}
}
