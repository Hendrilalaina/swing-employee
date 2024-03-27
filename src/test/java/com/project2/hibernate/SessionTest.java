package com.project2.hibernate;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Test;

import com.project2.hibernate.sessions.SessionUtil;

public class SessionTest {

	@Test
	public void testSessionFactory() {
		try(Session session = SessionUtil.getSession()) {
			assertNotNull(session);
		}
	}

}
