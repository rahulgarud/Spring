//CREATE TABLE CUSTOMER(CID NUMBER(3)PRIMARY KEY, CNAME VARCHAR2(100), EMAIL VARCHAR2(100), MOBILE VARCHAR2(20));
package edu.aspire.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class NewCustomerController implements Controller {
	@Autowired
	private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		String cname = req.getParameter("cname").trim();
		String email = req.getParameter("email").trim();
		String mobile = req.getParameter("mobile").trim();
		
		int cid = simpleJdbcTemplate.queryForInt("SELECT MAX(CID) FROM CUSTOMER");
		// Primary key increment
		cid++;
		simpleJdbcTemplate.getJdbcOperations().execute("INSERT INTO CUSTOMER VALUES(" + cid + ",'" + cname + "','"
				+ email + "','" + mobile + "')");
		return new ModelAndView("success", "cid", new Integer(cid));
	}
}
