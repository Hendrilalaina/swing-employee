package com.project2.hibernate;

import java.util.List;

import javax.persistence.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.project2.hibernate.controllers.EmployeController;
import com.project2.hibernate.models.Employe;
import com.project2.hibernate.sessions.SessionUtil;
import java.util.Date;

public class QueryTest {	
	@Test
	public void test() {
		try(Session session = SessionUtil.getSession()) {
//			Query query = session.getNamedQuery("lieu.findByProvince");
//			query.setParameter("province", "%"+"F"+"%");
			
//			Query query = session.getNamedQuery("employe.findByName");
//			query.setParameter("name", "%"+"n"+"%");
			
//			Transaction tx = session.beginTransaction();
//			Query update = session.getNamedQuery("lieu.updateCode");
//			update.setParameter("newCode", 302);
//			update.setParameter("lastCode", 301);
//			update.executeUpdate();
//			tx.commit();
			
//			Lieu lieu = session.byId(Lieu.class).load(302);
//			if(lieu == null)
//				System.out.print("Aucune correspondance");
//			else 
//			System.out.print(lieu.getCodeLieu());
//			Employe employe = session.byId(Employe.class).getReference("EMP_0001");
//			
//			Query update = session.getNamedQuery("employe.updateNom");
//			
//			Transaction tx = session.beginTransaction();
//			update.setParameter("nom", "Bob");
//			update.setParameter("code", "EMP_0001");
//			update.executeUpdate();
//			tx.commit();
			
//			Query query = session.getNamedQuery("lieu.findByCode");
//			query.setParameter("code", 301);
//			
//			Query query = session.getNamedQuery("lieu.findAll");
//			@SuppressWarnings("unchecked")
//			List<Lieu> lieux = query.getResultList();
//			
//			for(Lieu l : lieux) {
//				System.out.println(l.getDesignation());
//			}
			
//			@SuppressWarnings("unchecked")
//			List<Employe> employes = query.getResultList();
//			
//			for(Employe e : employes) System.out.println(e.getCodeEmp());
//			String hql = "from Employe where codeemp like :search";
//			String search = "E";
//			Query query = session.createQuery(hql);
//			query.setParameter("search", "%" + search + "%");
////			query.setParameter(0, query);
//			@SuppressWarnings("unchecked")
//			List<Employe> employees = query.getResultList();
//			for (Employe employe : employees) {
//				System.out.println(employe.getNom());
//			}
			String search = "o";
			List<Employe> employes = new EmployeController().chercher(search);
			for (Employe employe : employes) {
				System.out.println(employe.getCodeEmp());
			}
		}
	}

}
