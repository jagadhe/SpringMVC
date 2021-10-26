package com.springboot.crud.task;



import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.springboot.crud.task.entity.User;
import com.springboot.crud.task.repository.UserRepository;
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest

class SpringBootCrudTaskApplicationTests {

	@Autowired
	private UserRepository repository;
	private RestTemplate restTemplate;
	
	@Test
	public void testgetdetails() {
		
		restTemplate = new RestTemplate();
		User object = restTemplate.getForObject("http://localhost:8082/userById/2",User.class);
		assertNotNull(object);
		assertEquals("sai", object.getName());
		assertEquals("achari", object.getSurName());
		assertEquals("2020-09-06", object.getJoiningDate());
		assertEquals("tn",object.getState());
		assertEquals("1987-05-18", object.getDob());
		assertEquals("517490", object.getPincode());
		
		
	}
	
	@Test
	public void testcreateDetails() {
		RestTemplate restTemplate = new RestTemplate();
		User user= new User();
	user.setName("sai");
	user.setSurName("achari");
	user.setJoiningDate("2020-09-06");
	user.setDob("1987-05-18");
	user.setState("tn");
	user.setPincode("517490");
		
		Object newDetail = restTemplate.postForObject("http://localhost:8082/addUser",user, User.class);
		assertNotNull(newDetail);
		assertNotNull(user.getId());
		assertEquals("sai", user.getName());
		assertEquals("achari",user.getSurName());
		assertEquals("2020-09-06",user.getJoiningDate());
		assertEquals("1987-05-18", user.getDob());
		assertEquals("tn", user.getState());
		assertEquals("517490",user.getPincode());
		
	}
		
	@Test
	public void testupdatedetails() {
		
		restTemplate = new RestTemplate();
		User object = restTemplate.getForObject("http://localhost:8082/userById/2", User.class);
		object.setName("sai");
		object.setSurName("achari");
	
		
		restTemplate.put("http://localhost:8082/update", object);
	}
	
	
	@Test
	public void testdeletedetails() {
		
		restTemplate = new RestTemplate();
		User object = restTemplate.getForObject("http://localhost:8082/userById/2", User.class);
		object.setName("sai");
		object.setSurName("achari");
	
		
		restTemplate.delete("http://localhost:8082/delete/2", object);
	}
	
	

}
