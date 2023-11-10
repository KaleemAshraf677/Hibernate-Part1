package com.hql;

import org.hibernate.query.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.edu.hibernate.Student;

public class HQL_Pagination {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session=factory.openSession();
		
		// Query<Student> q=session.createQuery("from Student",Student.class);   // It is Generic,we can also write HQL query like this. 
		Query q=session.createQuery("from Student");
		
		//q.setFirstResult(0);
		//q.setMaxResults(5);
		
		q.setFirstResult(6);
		q.setMaxResults(7);
		
		List<Student> list=q.list();
		
		for(Student student:list) {
			System.out.println(student.getId()+","+student.getName());
		}
		
		
		
		session.close();
		factory.close();
	}

}
