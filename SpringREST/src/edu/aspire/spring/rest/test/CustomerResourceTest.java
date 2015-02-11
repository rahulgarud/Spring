package edu.aspire.spring.rest.test;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import edu.aspire.data.Customer;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerResourceTest{
   @Test
   public void testInsertCustomer() throws Exception{
      System.out.println("*** Create a new Customer ***");
	  Customer cust = new Customer();
	  cust.setCname("Ramesh");
	  cust.setEmail("ramesh@java2aspire.com");
	  cust.setMobile("7799108899");
	  
	  HttpHeaders headers = new HttpHeaders();
	  headers.setContentType(MediaType.APPLICATION_XML);
	  HttpEntity<Customer> entity = new HttpEntity<Customer>(cust, headers);
	  new RestTemplate().postForLocation("http://localhost:9090/SpringREST/customers", entity);
   }

   @Test
   public void testReadCustomer() throws Exception{
	   Customer c = new RestTemplate().getForObject("http://localhost:9090/SpringREST/customers/{cid}", Customer.class, 1); //The default Accept values are application/xml and application/json
	   
	   
	   //The following method gave us the resulting resource wrapped inside ResponseEntity from which we could retrieve response headers and status codes.
		/*ResponseEntity<Customer> respentity = new RestTemplate().getForEntity("http://localhost:9090/SpringREST/customers/{cid}", Customer.class, 1);
		HttpHeaders httpHeaders = respentity.getHeaders();
		System.out.println(respentity.getStatusCode());
		System.out.println(httpHeaders.getContentType());
		Customer c = respentity.getBody();*/
	   
	   //The exchange() method is used to set headers on the request sent to the server.
	   /*HttpHeaders headers = new HttpHeaders();
	   headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	   HttpEntity<String> entity = new HttpEntity<String>(headers);

	   ResponseEntity<Customer> response = new RestTemplate().exchange("http://localhost:9090/SpringREST/customers/{cid}", HttpMethod.GET, entity, Customer.class, 1);
	   Customer c = response.getBody();*/
	  
       System.out.println(c.getCid()+"\t"+c.getCname()+"\t"+c.getEmail()+"\t"+c.getMobile());
   }
}
