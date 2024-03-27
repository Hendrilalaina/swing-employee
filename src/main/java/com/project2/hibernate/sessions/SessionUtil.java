package com.project2.hibernate.sessions;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.jboss.logging.Logger;

import com.project2.hibernate.models.Affecter;
import com.project2.hibernate.models.Employe;
import com.project2.hibernate.models.Lieu;

public class SessionUtil {
	private static final SessionUtil instance = new SessionUtil();
	private final SessionFactory factory;
	Logger logger = Logger.getLogger(this.getClass());
	
	private SessionUtil() {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.build();
		factory = new MetadataSources(registry)
				.addAnnotatedClass(Lieu.class)
				.addAnnotatedClass(Employe.class)
				.addAnnotatedClass(Affecter.class)
				.buildMetadata().buildSessionFactory();
	}
	
	public static Session getSession() {
		return getInstance().factory.openSession();
	}
	
	private static SessionUtil getInstance() {
		return instance;
	}
			
}
