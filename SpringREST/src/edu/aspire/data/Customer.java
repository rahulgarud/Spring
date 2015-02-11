package edu.aspire.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="customer")
//CREATE TABLE CUSTOMER(CID NUMBER(3)PRIMARY KEY, CNAME VARCHAR2(100), EMAIL VARCHAR2(100), MOBILE VARCHAR2(20));
public class Customer {
	private int cid;
	private String cname;
	private String email;
	private String mobile;

	public Customer() {
	}
	@XmlElement
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	@XmlElement
	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	@XmlElement
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@XmlElement
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
