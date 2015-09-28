package voss.entity;

import java.math.BigInteger;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "businessunitmaster")
public class BusinessUnitEntity {

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "buID", nullable = false)
  public int buID;

  @Column(name = "code")
  public String code;
  
  @Column(name = "name")
  public String name;
  
  @Column(name = "status")
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

public BusinessUnitEntity(int buID, String code, String name, String status) {
	this.buID = buID;
	this.code = code;
	this.name = name;
	this.status = status;
}

public BusinessUnitEntity()
{
	
}
  
  


}
