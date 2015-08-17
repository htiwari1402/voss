package voss.domain;

public class UserEntity {

    public String  userName;
    public String name;
    public String designation;
    public String reportingManager;
    
    public UserEntity(String userName, String name, String designation,
			String reportingManager) {
		super();
		this.userName = userName;
		this.name = name;
		this.designation = designation;
		this.reportingManager = reportingManager;
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
	public String getReportingManager() {
		return reportingManager;
	}
	public void setReportingManager(String reportingManager) {
		this.reportingManager = reportingManager;
	}
	
}
