package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;



public class SQL_NativeQuery {

	public static void main(String[] args) {
	
         SessionFactory factory=new Configuration().configure().buildSessionFactory();
         Session session=factory.openSession();
         
         // SQL Query or Native query
         NativeQuery q =session.createSQLQuery("SELECT*FROM STUDENT");
         
                List<Object[]> list=q.list();
               
                for(Object[] student:list) {
                	System.out.println(Arrays.toString(student));
                }
         
         
	}

}
