package voss.domain;

public class UserEntity {

    public String  userName;
    public String name;
    public String designation;
    public int reportingManager;
    public String password;
    public int userId;
    
/*    public UserEntity(String userName, String name, String designation,
			String reportingManager) {
		this.userName = userName;
		this.name = name;
		this.designation = designation;
		this.reportingManager = reportingManager;
	}*/
    public UserEntity( String designation,String name,
			int reportingManager,String userName, String password,int userId) {
		this.userName = userName;
		this.name = name;
		this.designation = designation;
		this.reportingManager = reportingManager;
		this.password = password;
		this.userId = userId;
	}
    public UserEntity()
    { 	 
    }
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getReportingManager() {
		return reportingManager;
	}
	public void setReportingManager(int reportingManager) {
		this.reportingManager = reportingManager;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
