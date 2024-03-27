package com.project2.hibernate;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.project2.hibernate.idgenerator.AffecterId;
import com.project2.hibernate.models.Affecter;
import com.project2.hibernate.models.Employe;
import com.project2.hibernate.models.Lieu;
import com.project2.hibernate.sessions.SessionUtil;

public class AffecterTest {

	@Test
	public void test() {
		try(Session session = SessionUtil.getSession()) {
			Transaction tx = session.beginTransaction();
			Employe employe = new Employe();
			Lieu lieu = new Lieu();
			Affecter affect = new Affecter();
			
//			employe = session.byId(Employe.class).getReference(1);
//			lieu = session.byId(Lieu.class).getReference(1);
			
//			employe = session.load(Employe.class, 1);
//			lieu = session.load(Lieu.class, 1);
//			
//			System.out.println(employe.getNom() + " " + employe.getPrenom());
//			System.out.println(lieu.getDesignation() + " " + lieu.getProvince());
			employe.setNom("John");employe.setPrenom("Doe");employe.setPoste("DevOps");
//			lieu.setDesignation("Fianarantsoa");lieu.setProvince("Fianarantsoa");
			
			lieu.setDesignation("Antananarivo"); lieu.setProvince("Antananarivo");lieu.setCodeLieu("101");
			
			affect.setId(new AffecterId(employe, lieu));
			affect.setDate(LocalDate.now());
//			session.delete(affect);
			
			session.save(employe);
//			session.save(lieu);
//			session.update(lieu);
			session.save(affect);
			tx.commit();
		}
	}

}
