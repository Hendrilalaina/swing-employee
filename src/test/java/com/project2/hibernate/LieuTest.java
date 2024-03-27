package com.project2.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.project2.hibernate.models.Lieu;
import com.project2.hibernate.sessions.SessionUtil;

public class LieuTest {

	@Test
	public void test() {
		try(Session session = SessionUtil.getSession()) {
			Transaction tx = session.beginTransaction();
			
			Lieu lieu = new Lieu();
			
			lieu.setCodeLieu("301");
			lieu.setDesignation("Fianarantsoa");
			lieu.setProvince("Fianarantsoa");
			
			session.save(lieu);
			tx.commit();
		}
	}

}
