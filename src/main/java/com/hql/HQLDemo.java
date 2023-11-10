package com.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.edu.hibernate.Student;

public class HQLDemo {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		
 // HQL query for Fetching Data
		
		//String query="from Student Where city='Lucknow' ";
		// String query="from Student Where city=:X and name=:Y";
		String query="from Student as s Where s.city=:X and s. name=:Y";
		 Query q =session.createQuery(query);
		 
		 q.setParameter("X","Lucknow");
		 q.setParameter("Y", "Laraib Hassan");
		
		// If we need singleValue than use uniqueResult() method.
		// When we need multipleValue than use list() or getResultList()  method.
		  
		        List<Student> list =q.list();
		        for(Student student:list) {
		        	System.out.println(student.getId()+","+student.getName()+","+student.getCertificate()+","+student.getCity());
		        }
		
	System.out.println("________________________________________________________");	
	
// delete query in HQL
	
	     Transaction txn=session.beginTransaction();
	   
	    /* Query q2 =session.createQuery("Delete from Student s Where s.city=:X");
	       q2.setParameter("X","Bangalore");
	     
	       int rowsAffected=q2.executeUpdate();    //checking no of updates perform in q2 query
	       System.out.println("Data deleted successfully in database and no.of rows affected : "+rowsAffected);   */

// update query in HQL     
	     
 Query q3=session.createQuery("Update Student Set city=:C,duration=:D Where name=:N");
	  q3.setParameter("C","New Dehli");
	  q3.setParameter("D","2 months");
	  q3.setParameter("N","Laraib Hassan");
	  
	  int affectedRows=q3.executeUpdate();
	  System.out.println("Data Updated successfully in database and no. of rows affected: "+affectedRows);
	     

	     txn.commit();
		 session.close();
		 factory.close();

	}

}
