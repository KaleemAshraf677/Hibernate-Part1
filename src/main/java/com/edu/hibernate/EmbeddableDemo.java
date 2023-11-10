package com.edu.hibernate;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddableDemo {

	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		
		//Student Class object
		Student s1=new Student();
		s1.setId(110);
		s1.setName("Sifat Zehra");
		s1.setCity("Ambedkar Nagar");
		// Certificate Class object
		Certificate certi=new Certificate();
		certi.setCourse("Java Full stack developer");
		certi.setDuration("4.5 Months");
		s1.setCertificate(certi);
		
		// Student Class 2nd object
		Student s2=new Student();
		s2.setId(111);
		s2.setName("Kaleem Ashraf");
		s2.setCity("Lucknow");
		// Certificate Class 2nd object
		Certificate certi2=new Certificate();
		certi2.setCourse("SpingBoot developer");
		certi2.setDuration("2.5 Months");
		s2.setCertificate(certi2);
		
		Session session=factory.openSession();
		Transaction txn=session.beginTransaction();
		// save objects
		session.save(s1);
		session.save(s2);
		txn.commit();
		session.clear();
		factory.close();
		
		
	}

}
