//CREATE TABLE CUSTOMER(CID NUMBER(3)PRIMARY KEY, CNAME VARCHAR2(100), EMAIL VARCHAR2(100), MOBILE VARCHAR2(20));
package edu.aspire.controllers;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.aspire.data.Customer;

@Controller
@RequestMapping("/customers")
public class NewCustomerController{
	@Autowired
	private SimpleJdbcTemplate simpleJdbcTemplate;

	@RequestMapping(method=RequestMethod.GET, params="new")
	public String createCustomerProfile(Model model){
		model.addAttribute(new Customer());
		return "NewCustomer";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String insertCustomer(@Valid Customer customer, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){ //In case of validation errors
			return "NewCustomer"; //redirected back to request page
		}
		int cid = simpleJdbcTemplate.queryForInt("SELECT MAX(CID) FROM CUSTOMER");
		String cname = customer.getCname().trim();
		String email = customer.getEmail().trim();
		String mobile = customer.getMobile().trim();

		// Primary key increment
		cid++;
		simpleJdbcTemplate.getJdbcOperations().execute("INSERT INTO CUSTOMER VALUES(" + cid + ",'" + cname + "','"
				+ email + "','" + mobile + "')");
		customer.setCid(cid);
		return "success";
	}
}
