package voss.domain;

public class Designation {
	
	public String designation;
	public int id;
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Designation(String designation, int id) {
		super();
		this.designation = designation;
		this.id = id;
	}
	
	

}
