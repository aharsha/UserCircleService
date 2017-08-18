package com.stackroute.activitystream.usercircle;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@EntityScan(basePackages={"com.stackroute.activitystream.usercircle"})
@SpringBootApplication
public class UserCircleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserCircleServiceApplication.class, args);
	}
	
	@Bean
	public SessionFactory getSessionFactory(HibernateEntityManagerFactory hibernateEntityManagerFactory)
	{
		
		SessionFactory sessionFactory=hibernateEntityManagerFactory.getSessionFactory();
		
		
return sessionFactory;
	}
}
