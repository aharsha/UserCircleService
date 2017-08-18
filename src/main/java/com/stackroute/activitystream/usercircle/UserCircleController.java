package com.stackroute.activitystream.usercircle;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;





@RestController
public class UserCircleController {

	
	@Autowired
	UserCircleDao userCircleDao;
	
	
	
	@PostMapping("/subscribeCircle")
	public ResponseEntity<String> subscribeCircle(@RequestBody SubscribeCircle subscribeCircle)
	{
		
		try
		{
		boolean userStatus=userCircleDao.subscribeToCircle(subscribeCircle);
		if(userStatus==true)
		{
		return new ResponseEntity<String>("user added successfully",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("user not added ",HttpStatus.NOT_MODIFIED);
		}
		}
		catch(Exception exception )
		{
			return new ResponseEntity<String>("user not added",HttpStatus.NOT_MODIFIED);
				
		}
		
	}
		
	
	
	@GetMapping("/unSubscribeCircle/{userId}/{circleId}")
	public ResponseEntity<String> unSubscribeCircle(@PathVariable String userEmail,@PathVariable Integer circleId)
	{
	
	
		boolean deleterUserStatus;
		try
		{
		 deleterUserStatus=userCircleDao.unSubscribeCircle(userEmail, circleId);
		if(deleterUserStatus==true)
		{
		return new ResponseEntity<String>("deleted successfully",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("not deleted",HttpStatus.NOT_FOUND);
				}
		}
		catch(Exception exception )
		{
			exception.printStackTrace();
			
			return new ResponseEntity<String>("not deleted",HttpStatus.NOT_MODIFIED);
				
		}
		
		}



		
		@GetMapping("/getMyCircles/{userId}")
		public ResponseEntity<List<SubscribeCircle>> retrieveMyCircles(@PathVariable String userId)
		{
		System.out.println(userId);
			List<SubscribeCircle> myCircles=null;
			try
			{
			 myCircles=userCircleDao.myCircles(userId);
			 
			
			 
			
			 
			if(myCircles!=null)
			{
			return new ResponseEntity<List<SubscribeCircle>>(myCircles,HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<List<SubscribeCircle>>(myCircles,HttpStatus.BAD_REQUEST);
			}
			}
			catch(Exception exception )
			{
				exception.printStackTrace();
				
				return new ResponseEntity<List<SubscribeCircle>>(myCircles,HttpStatus.CONFLICT);
					
			}
			
			}

		
		

		}
	
	
	

