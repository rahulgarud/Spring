package edu.aspire.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	private SimpleJdbcTemplate simpleJdbcTemplate;

	public EmployeeDaoImpl() {}

	@Override
	public void save(final Employee emp) {
		//Anonymous approach
		simpleJdbcTemplate.getJdbcOperations().update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				String query = "INSERT INTO employee(eno, ename, desig, sal) VALUES (?,?,?,?)";
				PreparedStatement pstmt =con.prepareStatement(query);
				pstmt.setInt(1, emp.getEno());
				pstmt.setString(2, emp.getEname());
				pstmt.setString(3, emp.getDesig());
				pstmt.setDouble(4, emp.getSal());
				return pstmt;
			}
		});
		
		//Short cut approach
		/*String query = "INSERT INTO employee(eno, ename, desig, sal) VALUES (?,?,?,?)";
		Object[] data = {emp.getEno(), emp.getEname(), emp.getDesig(), emp.getSal()};
		simpleJdbcTemplate.update(query, data);*/
	}
	@Override
	public Employee get(int eno) {
		String query = "SELECT * FROM EMPLOYEE WHERE ENO=?";
		//Employee emp = simpleJdbcTemplate.queryForObject(query, ParameterizedBeanPropertyRowMapper.newInstance(Employee.class), eno); //deprecated
		Employee emp = simpleJdbcTemplate.queryForObject(query, new EmployeeRowMapper(), eno); 
		return emp;
	}
	
	@Override
	public void delete(int eno) {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(Employee e) {
		// TODO Auto-generated method stub
	}
}

