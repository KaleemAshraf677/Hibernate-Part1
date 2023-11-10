package com.edu.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		 
		System.out.println("Project Started.....");
	       
	       // SessionFactory factory=new Configuration().configure().buildSessionFactory();
	       
	       Configuration cfg=new Configuration();
	       cfg.configure("hibernate.cfg.xml");
	       SessionFactory factory=cfg.buildSessionFactory();
	       
	     //  System.out.println(factory);
	     //  System.out.println(factory.isClosed());
	       
	       // creating object of Student class for creating table in database and inserting values also...
	       Student s1=new Student();
	       s1.setId(103);
	       s1.setName("Kaleem Ashraf");
	       s1.setCity("Bangalore");
	       System.out.println(s1.toString());
	       
	       // create an object of Address class for creating table in database and inserting values .... 
	       Address add=new Address();
	       add.setStreet("Nanda Farm");
	       add.setCity("Lucknow");
	       add.setOpen(true);
	       add.setAddeddate(new Date());
	       add.setX(123456);
	       
	       
	      
	       
	       Session session=factory.openSession();
	       Transaction tx= session.beginTransaction();
	       session.save(s1);
	       session.save(add);
	       tx.commit();
	       
	       session.close();
	       factory.close();
	       System.out.println("successfully saved in database.....");

	}

}
