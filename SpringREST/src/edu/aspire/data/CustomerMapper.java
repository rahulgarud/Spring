package edu.aspire.data;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class CustomerMapper implements RowMapper<Customer> {
	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException{
		Customer c = new Customer();
		c.setCid(rs.getInt(1));
		c.setCname(rs.getString(2));
		c.setEmail(rs.getString(3));
		c.setMobile(rs.getString(4));
		return c;
	}
}
