package com.slokam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class StudentHibDAO {

	public void nameupdate(studentpojo sp) {
		
		AnnotationConfiguration ac = new AnnotationConfiguration().configure();
		SessionFactory sf =  ac.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t =  s.beginTransaction();
		s.update(sp);
		t.commit();
		s.close();
	}
	
	public studentpojo getstudentbyid(int id){

		AnnotationConfiguration ac = new AnnotationConfiguration().configure();
		SessionFactory sf =  ac.buildSessionFactory();
		Session s = sf.openSession();
		studentpojo poj = (studentpojo) s.get(studentpojo.class, id);
		
		s.close();
		return poj;
	}
	
	public void delete(int id){
		AnnotationConfiguration ac = new AnnotationConfiguration().configure();
		SessionFactory sf =  ac.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		studentpojo pojo =new studentpojo();
		pojo.setId(id);
		s.delete(pojo);
		t.commit();
		s.close();
	}
	
	/*public studentpojo studentgetdetailes(String name){
		AnnotationConfiguration ac = new AnnotationConfiguration().configure();
		SessionFactory sf =  ac.buildSessionFactory();
		Session s = sf.openSession();
		
		return null;
	}*/
	
	public void studentsave(studentpojo student){
		AnnotationConfiguration ac = new AnnotationConfiguration().configure();
		SessionFactory sf =  ac.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.save(student);
		t.commit();
		s.close();
	}
}
