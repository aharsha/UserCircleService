package com.stackroute.activitystream.usercircle;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {UserCircleServiceApplication.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT,classes=UserCircleServiceApplication.class)
public class UserCircleControllerTestCase {
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
	
	@Before
	public void initMock() throws Exception 
	{
		
	    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}

	@Test
	public void subscribeCircleTestCase()throws Exception
	{
		
	    this.mockMvc.perform(post("http://localhost:7070/subscribeCircle")).andExpect(status().isOk());
	    	}
	
	
	
	
	@Test
	public void  UnSubscribeCircleTestCase()throws Exception
	{
		
	    this.mockMvc.perform(post("http://localhost:7070/unSubscribeCircle/harsha@gmail.com/37756")).andExpect(status().isOk());
	    	}
	
	
	@Test
	public void  myCirclesTestCase()throws Exception
	{
		
	    this.mockMvc.perform(post("http://localhost:7070/getMyCircles/harsha@gmail.com")).andExpect(status().isOk());
	    	}

}
