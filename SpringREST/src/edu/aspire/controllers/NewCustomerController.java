package edu.aspire.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.aspire.data.Customer;
import edu.aspire.data.CustomerMapper;

@Controller
@RequestMapping("/customers")
public class NewCustomerController{
	@Autowired
	private SimpleJdbcTemplate simpleJdbcTemplate;

	@RequestMapping(method=RequestMethod.POST, headers={"Content-Type=application/xml, application/json"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void insertCustomer(@RequestBody Customer customer) throws Exception {
		int cid = simpleJdbcTemplate.queryForInt("SELECT MAX(CID) FROM CUSTOMER");
		String cname = customer.getCname().trim();
		String email = customer.getEmail().trim();
		String mobile = customer.getMobile().trim();

		// Primary key increment
		cid++;
		simpleJdbcTemplate.getJdbcOperations().execute("INSERT INTO CUSTOMER VALUES(" + cid + ",'" + cname + "','"
				+ email + "','" + mobile + "')");
		customer.setCid(cid);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, headers={"Accept=application/xml, application/json"})
	public @ResponseBody Customer readCustomer(@PathVariable("id") int id){
		String query = "SELECT * FROM CUSTOMER WHERE CID=?";
		Customer cust = simpleJdbcTemplate.queryForObject(query, new CustomerMapper(), id);
		return cust;
	}
}
