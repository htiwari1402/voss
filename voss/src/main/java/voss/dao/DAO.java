package voss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;  







import voss.domain.BU;
import voss.domain.ProductMaster;
import voss.domain.UserEntity;
import voss.entity.BankMasterEntity;
import voss.entity.BusinessUnitEntity;

public class DAO {
	
	public DriverManagerDataSource ds= null;
	public JdbcTemplate jt = null;
	public int countOfResults = 0;

	public DAO()
	{
		this.ds = new DriverManagerDataSource();
		this.ds.setDriverClassName("com.mysql.jdbc.Driver");
		this.ds.setUrl("jdbc:mysql://localhost:3306/voss");
		this.ds.setUsername("root");
		this.ds.setPassword("");
		this.jt = new JdbcTemplate(this.ds);
	}
	public void setCountOfResults(int num)
	{
	    this.countOfResults = num;
	}
	public void addUsers(UserEntity user)
	{
		String SQL = "insert into userregistration (userName, name,designation,reportingManager,password) values (?, ?,?,?,?)";
		this.jt.update( SQL, new Object[]{user.getUserName(),user.getName(),user.getDesignation(),user.getReportingManager(),user.getPassword()});
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
	public long insertNewBank(BankMasterEntity bme) throws org.springframework.jdbc.BadSqlGrammarException, SQLException
	{
		String SQL= "insert into bankmaster (`country`, `name`, `desc`, `address`, `accNo`, `swift`, `contactNo`, `emailID`, `status`, `details`)  values(?,?,?,?,?,?,?,?,?,?)";
		
		/*this.jt.update(SQL, new Object[]{bme.getCountry(),bme.getName(),bme.getDesc(),bme.getAddress(),bme.getAccNo(),bme.getSwift()
				,bme.getContactNo(),bme.getEmailID(),bme.getStatus(),bme.getDetails()});*/
		long genId = 0;
		//this.jt.update(SQL, new Object[]{bme.getCode(),bme.getName(),bme.getStatus()});
		Connection conn = this.jt.getDataSource().getConnection();
		PreparedStatement  stmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
		
		stmt.setString(1, bme.getCountry());
		stmt.setString(2, bme.getName());
		stmt.setString(3,bme.getDesc());
		stmt.setString(4, bme.getAddress());
		stmt.setString(5, bme.getAccNo());
		stmt.setString(6,bme.getSwift());
		stmt.setString(7, bme.getContactNo());
		stmt.setString(8,bme.getEmailID());
		stmt.setString(9,bme.getStatus());
		stmt.setString(10,bme.getDetails());
		//stmt
		stmt.executeUpdate();
		try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                genId = generatedKeys.getLong(1);
            }
            else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
		}
		return genId;
		
	}
	@SuppressWarnings("unchecked")
	public void editBank(BankMasterEntity bme) throws org.springframework.jdbc.BadSqlGrammarException
	{
		String SQL= "update bankmaster set `country` = ?, `name` = ?, `desc` = ?, `address` = ?, `accNo` = ?, `swift` = ?,`contactNo` = ?, `emailID` = ?, `status`=?, `details`= ? where `pk_bankID` = ?";
		
		this.jt.update(SQL, new Object[]{bme.getCountry(),bme.getName(),bme.getDesc(),bme.getAddress(),bme.getAccNo(),bme.getSwift()
				,bme.getContactNo(),bme.getEmailID(),bme.getStatus(),bme.getDetails(),bme.getPk_bankID()});
		
		
	}
	@SuppressWarnings("unchecked")
	public long insertNewBU(BU bme) throws org.springframework.jdbc.BadSqlGrammarException, SQLException
	{
		String SQL= "insert into businessunitmaster (`code`,`name`,`status`)  values(?,?,?)";
		long genId = 0;
		//this.jt.update(SQL, new Object[]{bme.getCode(),bme.getName(),bme.getStatus()});
		Connection conn = this.jt.getDataSource().getConnection();
		PreparedStatement  stmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, bme.getCode());
		stmt.setString(2, bme.getName());
		stmt.setString(3, bme.getStatus());
		stmt.executeUpdate();
		try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                genId = generatedKeys.getLong(1);
            }
            else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
            
	}
		return genId;
}
	@SuppressWarnings("unchecked")
    public List<UserEntity> getAuthenticatedUser(String username, String password)
	{
	    //int countOfResults = 0;
	    String SQLInit = "select count(*) from userregistration where userName = ? and password = ?";
	    //ResultSet rs;
	    this.jt.query(SQLInit,new Object[]{username,password},(rs,num)->(this.countOfResults = rs.getInt(1)));
	    System.out.println(this.countOfResults);
	    if(this.countOfResults > 0)	
	    {
	    String SQL = "select * from userregistration where userName = ? and password = ?";
	    return this.jt.query(SQL,new Object[]{username,password},new  RowMapper()
        {

            @Override
            public UserEntity  mapRow(ResultSet rs, int rn) throws SQLException 
            {
                return new UserEntity(rs.getString("designation"),rs.getString("name"),rs.getInt("reportingManager"),rs.getString("userName"),
                        rs.getString("password"),rs.getInt("userId"));
            }
    
        });
	    }
	    else
	        return null;
	    
	}
}
