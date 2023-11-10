package com.edu.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstLevelSessionCache {

	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		
		//fetching data from database
		
		
		Student student=session.get(Student.class,103);
		System.out.println(student);
		
		System.out.println("Student object is available in session cache:"+session.contains(student)); //check student object is available in session cache if yes than return True bacause its a boolen function. 
		
		//again fetching same object 
		Student stu=session.get(Student.class,103);
		System.out.println(stu);
		
		session.close();

		
		factory.close();

	}

}
