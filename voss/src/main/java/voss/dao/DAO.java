package voss.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.core.RowMapper;  

import voss.domain.ProductMaster;
import voss.domain.UserEntity;
import voss.entity.BankMasterEntity;
import voss.entity.BusinessUnitEntity;

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
	@SuppressWarnings("unchecked")
	public void insertNewBank(BankMasterEntity bme) throws org.springframework.jdbc.BadSqlGrammarException
	{
		String SQL= "insert into bankmaster (`country`, `name`, `desc`, `address`, `accNo`, `swift`, `contactNo`, `emailID`, `status`, `details`)  values(?,?,?,?,?,?,?,?,?,?)";
		
		this.jt.update(SQL, new Object[]{bme.getCountry(),bme.getName(),bme.getDesc(),bme.getAddress(),bme.getAccNo(),bme.getSwift()
				,bme.getContactNo(),bme.getEmailID(),bme.getStatus(),bme.getDetails()});
		
		
	}
	@SuppressWarnings("unchecked")
	public void editBank(BankMasterEntity bme) throws org.springframework.jdbc.BadSqlGrammarException
	{
		String SQL= "update bankmaster set `country` = ?, `name` = ?, `desc` = ?, `address` = ?, `accNo` = ?, `swift` = ?,`contactNo` = ?, `emailID` = ?, `status`=?, `details`= ? where `pk_bankID` = ?";
		
		this.jt.update(SQL, new Object[]{bme.getCountry(),bme.getName(),bme.getDesc(),bme.getAddress(),bme.getAccNo(),bme.getSwift()
				,bme.getContactNo(),bme.getEmailID(),bme.getStatus(),bme.getDetails(),bme.getPk_bankID()});
		
		
	}
	@SuppressWarnings("unchecked")
	public void insertNewBU(BusinessUnitEntity bme) throws org.springframework.jdbc.BadSqlGrammarException
	{
		String SQL= "insert into businessunitmaster (`code`,`name`,`status`)  values(?,?,?)";
		
		this.jt.update(SQL, new Object[]{bme.getCode(),bme.getName(),bme.getStatus()});
		
		
	}
}
