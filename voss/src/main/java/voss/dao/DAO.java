package voss.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

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
}
