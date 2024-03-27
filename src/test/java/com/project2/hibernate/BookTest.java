package com.project2.hibernate;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.project2.hibernate.models.Book;
import com.project2.hibernate.sessions.SessionUtil;

public class BookTest {

	@Test
	public void test() {
		try(Session session = SessionUtil.getSession()) {
			Transaction tx = session.beginTransaction();
			
			Book book1 = new Book();
			Book book2 = new Book();
			
			book1.setTitle("Lavakombarika");
			book2.setTitle("Ho avy ny maraina");
			session.save(book1);
			session.save(book2);
			tx.commit();
		}
	}

}
