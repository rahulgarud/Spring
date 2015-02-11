package edu.aspire.hibernate;
//Customer.java
/* CREATE TABLE CUSTOMER(CNO NUMBER(5)PRIMARY KEY, CNAME VARCHAR2(20), ADDRESS VARCHAR2(100), PHONE NUMBER(15));*/
import java.io.Serializable;

/*
 * CREATE TABLE CUSTOMER(CNO NUMBER(5)PRIMARY KEY, CNAME VARCHAR2(20), ADDRESS
 * VARCHAR2(100), PHONE NUMBER(15));
 */
public class Customer implements Serializable {
	private int cno;
	private String cname;
	private String address;
	private long phone;

	public Customer() {
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}
}
