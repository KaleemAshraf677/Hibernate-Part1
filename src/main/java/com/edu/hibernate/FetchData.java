package com.edu.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchData {

	public static void main(String[] args) {
		/* we have 2 methods to select data in hibernate get(),load() :
		  
		 get() Method:
		 
		 1. get() method of hibernate session returns null if object is not found in cache as well as on database.
		 2. Use if you are not sure that object exists in database or not.
		 3. get() involves database hit if object doesn't exists in session cache and returns a fully initialized object which may involve several database call.  
		 
		 load():    
		  
		 1. load() method throws ObjectNotFoundException if object is not found on cache as well as on database.  
		 2. Use if you are sure that object exists in database.
		 3. load method can return proxy in place and only initialize the object or hit the database .if any method other than getId() is called on persistent or entity object.This is also known as lazy initialization and it increases the performance.*/ 
		  
		  
		 
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		
		//get Student details where id=103)
		Student student=session.get(Student.class, 103);  
		System.out.println(student.toString());   
		
		//load Address details where id=1
		  Address add=session.load(Address.class,1);
		 // System.out.println(add.toString());
		 System.out.println(add.getCity()+","+add.getStreet()+","+add.getAddeddate());
		 
		session.close();
		factory.close();
		

	}

}
