package edu.aspire.hibernate;
//CustomerDao.java
public interface CustomerDao {
	public void save(Customer e);

	public void update(Customer e);

	public void delete(int eno);

	public Customer get(int eno);
}
