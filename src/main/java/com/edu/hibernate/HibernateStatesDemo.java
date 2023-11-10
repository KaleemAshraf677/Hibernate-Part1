package com.edu.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateStatesDemo {

	public static void main(String[] args) {
		/* In hibernate there are 4 states of storing object data in database.
		  1. Transient state
		  2. Persistent State
		  3. Detached State
		  4. Removed State  */
		 
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		
		//object Student Class                              
		Student s1=new Student();    // Transient State 
		s1.setId(112);
		s1.setName("Mohammad Ashraf");
		s1.setCity("Lucknow");
		
		// object of Certificate class
		    Certificate certi=new Certificate();
		    certi.setCourse("Web Development");
		    certi.setDuration("4.5 Months");
		    
		s1.setCertificate(certi);
		
		Session session =factory.openSession();
		Transaction txn=session.beginTransaction();
		// save objects
		session.save(s1);   //Persistent State:In this state our data is connected(Present) to database as well as session and we can also change this data in database as per our need.
		
		//again set the student name
		s1.setName("Laraib Hassan");
		
		txn.commit();
		session.close();   // Detached State: In detached State session will be close no transaction is allowed to permitted in database.Session values will be removed but in database previous data successfully stored. 
		s1.setCity("Bangalore");
		
	}

}
