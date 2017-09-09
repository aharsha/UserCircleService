package com.stackroute.activitystream.usercircle;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.activitystream.dao.UserCircleDao;
import com.stackroute.activitystream.model.SubscribeCircle;








@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT,classes=UserCircleServiceApplication.class)
public class UserCircleServiceApplicationTests {

	@Autowired
	UserCircleDao userCircleDao;
	
	@Test
	public void subscribeCircleTestCase() {
		
		
SubscribeCircle subscribeCircle=new SubscribeCircle();
subscribeCircle.setUserid("harsha@gmail.com");
subscribeCircle.setCircleid(37756);
subscribeCircle.setSubscriberid((int)(Math.random()*100000));

subscribeCircle.setDataofjoin(new Date());
subscribeCircle.setStatus("A");
		assertEquals("success",true,userCircleDao.subscribeToCircle(subscribeCircle));
	}
	
	
	
	@Test
	public void unSubscribeCircleTestCase() {
		
		

		assertEquals("success",true,userCircleDao.unSubscribeCircle("harsha@gmail.com",37756));
	}
	
	
	@Test
	public void myCirclesTestCase() 
	{

		 
	List<SubscribeCircle> subscribeCircles= userCircleDao.myCircles("harsha@gmail.com");

			for (SubscribeCircle subscribeCircle :subscribeCircles )
			{
				System.out.println("Subscribed user  mailid  = "+subscribeCircle.getUserid());
				System.out.println("Subscribed circle id  = "+subscribeCircle.getCircleid());
				
			}
	}
	
	
}
