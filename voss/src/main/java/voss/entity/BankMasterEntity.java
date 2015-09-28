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
@Table(name = "bankmaster")
public class BankMasterEntity {

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "pk_bankID", nullable = false)
  public int bankID;

  @Column(name = "country")
  public String country;
  
  @Column(name = "name")
  public String name;
  
  @Column(name = "desc")
  public String desc;
  
  @Column(name = "address")
  public String address;
  
  @Column(name = "accNo")
  public String accNo;
  
  @Column(name = "swift")
  public String swift;
  
  @Column(name = "contactNo")
  public BigInteger contactNo;
  
  @Column(name = "emailID")
  public String emailID;
  
  @Column(name = "status")
  public String status;
  
  @Column(name = "details")
  public String details;

public int getPk_bankID() {
	return bankID;
}

public void setPk_bankID(int pk_bankID) {
	this.bankID = pk_bankID;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
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

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getAccNo() {
	return accNo;
}

public void setAccNo(String accNo) {
	this.accNo = accNo;
}

public String getSwift() {
	return swift;
}

public void setSwift(String swift) {
	this.swift = swift;
}

public BigInteger getContactNo() {
	return contactNo;
}

public void setContactNo(BigInteger contactNo) {
	this.contactNo = contactNo;
}

public String getEmailID() {
	return emailID;
}

public void setEmailID(String emailID) {
	this.emailID = emailID;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public String getDetails() {
	return details;
}

public void setDetails(String details) {
	this.details = details;
}

public BankMasterEntity( String country, String name,
		String desc, String address, String accNo, String swift,
		BigInteger contactNo, String emailID, String status, String details) {
	//super();
	this.country = country;
	this.name = name;
	this.desc = desc;
	this.address = address;
	this.accNo = accNo;
	this.swift = swift;
	this.contactNo = contactNo;
	this.emailID = emailID;
	this.status = status;
	this.details = details;
}

public BankMasterEntity() {
	// TODO Auto-generated constructor stub
}


}
