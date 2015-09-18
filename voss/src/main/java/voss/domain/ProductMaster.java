package voss.domain;

public class ProductMaster {
	
	public String name;
	public String desc;
	public String status;
	public String grade;
	public String spec;
	
	public ProductMaster(String name, String desc, String status, String grade,String spec) {
		this.name = name;
		this.desc = desc;
		this.status = status;
		this.grade = grade;
		this.spec = spec;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	
}
