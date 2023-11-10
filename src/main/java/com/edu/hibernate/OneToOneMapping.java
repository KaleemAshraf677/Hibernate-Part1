//  mappings are both Uni-directional and bi-directional 

package com.edu.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneMapping {
     public static void main(String[] args) {
		
    	Configuration cfg=new Configuration();
 		cfg.configure("hibernate.cfg.xml");
 		SessionFactory factory=cfg.buildSessionFactory();
 		
 		//creating question  object 1
 		Question q1=new Question();
 		q1.setQuestionId(1212);
 		q1.setQuestion("What is Java ?");
 		//creating answer obj 1
 		    Answer answer=new Answer();
 		    answer.setAnswerID(343);
 		    answer.setAnswer("Java is a programming language");
 		    answer.setQuestion(q1);  // bi-directional mapping
 		q1.setAnswer(answer);
 		
 		   
 	   //creating question object 2
 	     Question q2=new Question();
 		 q2.setQuestionId(242);
 		 q2.setQuestion("What is Collection Framework ?");
 	   //creating answer obj 2
 		 Answer answer1=new Answer();
 		      answer1.setAnswerID(344);
 		      answer1.setAnswer("API to work with objects in Java");
 		      answer1.setQuestion(q2);  //bi-directional mapping
 		 q2.setAnswer(answer1);
 		
 		
 		Session session=factory.openSession();
 		Transaction txn=session.beginTransaction();
 		//save sessions
 		session.save(q1);
 		session.save(q2);
 		session.save(answer);
 		session.save(answer1);
		
		txn.commit();
		
		//fetch data.....
		Question ques=session.get(Question.class, 1212);
		System.out.println(ques.getQuestion());
		System.out.println(ques.getAnswer().getAnswer());
		
		session.close();
		factory.close();
				
 		
 		
 		
	}
}
 
