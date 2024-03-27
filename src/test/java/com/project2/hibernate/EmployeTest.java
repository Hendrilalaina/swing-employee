package com.project2.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.project2.hibernate.models.Employe;
import com.project2.hibernate.sessions.SessionUtil;

public class EmployeTest {

	@Test
	public void test() {
		try(Session session = SessionUtil.getSession()) {
			Transaction tx = session.beginTransaction();
			Employe employe1 = new Employe();
			Employe employe2 = new Employe();
			
			employe1.setNom("John");
			employe1.setPrenom("Doe");
			employe1.setPoste("DevOps");
			
			employe2.setNom("Mike");
			employe2.setPrenom("Durant");
			employe2.setPoste("Player");
			
			session.save(employe1);
			session.save(employe2);
			tx.commit();
			
		}
	}

}
