package edu.aspire.hibernate;
//CustomerDaoImpl.java
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component("customerdao")
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public CustomerDaoImpl() {}

	@Override
	public void save(final Customer c) {
		//anonymous approach
		hibernateTemplate.execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Integer iRef = (Integer) session.save(c);
				return iRef;
			}
		});

		// short cut approach
		// hibernateTemplate.save(c);
	}

	@Override
	public void delete(int eno) {
	}

	@Override
	public Customer get(int eno) {
		return null;
	}

	@Override
	public void update(Customer e) {
	}
}
