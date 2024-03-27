package com.project2.hibernate.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project2.hibernate.models.Lieu;
import com.project2.hibernate.sessions.SessionUtil;

public class LieuController {
	public Lieu lieu(String codeLieu) {
		try(Session session = SessionUtil.getSession()) {
			Lieu l = session.load(Lieu.class, codeLieu);
			l.getCodeLieu();
			l.getProvince();
			l.getDesignation();
			return l;
		}
	}
        
        public Lieu lieuByDesignation(String designation) {
            try (Session session = SessionUtil.getSession()) {
                Query query = session.getNamedQuery("lieu.findByDesignation");
                query.setParameter("designation", designation);
                Lieu lieu = (Lieu) query.getSingleResult();
                return lieu;
            }
        }
	
	@SuppressWarnings("unchecked")
	public List<Lieu> lister() {
		
		List<Lieu> lieux = new ArrayList<Lieu>();
		try(Session session = SessionUtil.getSession()) {
			Query query = session.getNamedQuery("lieu.findAll");
			lieux = query.getResultList();
			return lieux;
		}
	}
        
        @SuppressWarnings("unchecked")
        public List<Lieu> chercher(String search) {
            List<Lieu> lieux = new ArrayList<Lieu>();
            try (Session session = SessionUtil.getSession()) {
                String hql = "from Lieu where codelieu like :search or designation like :search or province like :search";
                Query query = session.createQuery(hql);
                query.setParameter("search", "%" + search + "%");
                lieux = query.getResultList();
                return lieux;
            }
        }
        
	public void ajouter(String code, String designation, String province) {
		try(Session session = SessionUtil.getSession()) {
			Lieu lieu = new Lieu();
			
			lieu.setCodeLieu(code);
			lieu.setDesignation(designation);
			lieu.setProvince(province);
			
			Transaction tx = session.beginTransaction();
			session.save(lieu);
			tx.commit();
		}
	}
	
	public void modifier(String lastCode, String newCode, String designation, String province) {
		try(Session session = SessionUtil.getSession()) {
//			Lieu lieu = session.byId(Lieu.class).getReference(lastCode);
			
			Query query = session.getNamedQuery("lieu.update");
			query.setParameter("newCode", newCode);
			query.setParameter("lastCode", lastCode);
			query.setParameter("designation", designation);
			query.setParameter("province", province);
			
			Transaction tx = session.beginTransaction();
			query.executeUpdate();
			tx.commit();			
		}
	}
	
	public void supprimer(String code) {
		try(Session session = SessionUtil.getSession()) {
			Lieu lieu = session.load(Lieu.class, code);
			
			Transaction tx = session.beginTransaction();
			session.delete(lieu);
			tx.commit();
		}
	}
}
