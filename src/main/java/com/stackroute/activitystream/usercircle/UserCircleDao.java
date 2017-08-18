package com.stackroute.activitystream.usercircle;

import java.util.List;



public interface UserCircleDao {
	
	public boolean subscribeToCircle(SubscribeCircle subscribeCircle);
	public boolean unSubscribeCircle(String userEmail, int circleId);
	public List<SubscribeCircle> myCircles(String userId);
	
}
