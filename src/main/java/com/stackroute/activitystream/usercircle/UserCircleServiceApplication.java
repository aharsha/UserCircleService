package com.stackroute.activitystream.usercircle;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@EntityScan(basePackages={"com.stackroute.activitystream.usercircle"})
@ComponentScan("com.stackroute.activitystream")
@SpringBootApplication
@EnableAutoConfiguration
public class UserCircleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserCircleServiceApplication.class, args);
	}
	
	/*@Bean
	public SessionFactory getSessionFactory(HibernateEntityManagerFactory hibernateEntityManagerFactory)
	{
		
		SessionFactory sessionFactory=hibernateEntityManagerFactory.getSessionFactory();
		
		
return sessionFactory;
	}
*/
}
