package voss.domain;

public class BU {
	
	public int buID;
	public String code;
	public String name;
	public String status;
	public int getBuID() {
		return buID;
	}
	public void setBuID(int buID) {
		this.buID = buID;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BU(int buID, String code, String name, String status) {
		//super();
		this.buID = buID;
		this.code = code;
		this.name = name;
		this.status = status;
	}
	public BU()
	{}
	
	
}
