package com.project2.hibernate.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project2.hibernate.models.Employe;
import com.project2.hibernate.sessions.SessionUtil;

public class EmployeController {
	public Employe employe (String codeEmp) {
		try (Session session = SessionUtil.getSession()) {
			Employe emp =  session.load(Employe.class, codeEmp);
			emp.getCodeEmp();
			emp.getNom();
			emp.getPrenom();
			emp.getPoste();
			return emp;
		}
	}
	public void ajouter(String nom, String prenom, String poste) {
		try(Session session = SessionUtil.getSession()) {
			Employe employe = new Employe();
			
			employe.setNom(nom);
			employe.setPrenom(prenom);
			employe.setPoste(poste);
			
			Transaction tx = session.beginTransaction();
			session.save(employe);
			tx.commit();
		}
	}
	
	public void modifier(String code, String nom, String prenom, String poste) {
		try(Session session = SessionUtil.getSession()) {
//			Employe employe = session.byId(Employe.class).getReference(code);
			
			Query query = session.getNamedQuery("employe.update");
			query.setParameter("nom", nom);
			query.setParameter("prenom", prenom);
			query.setParameter("poste", poste);
			query.setParameter("code", code);
			
			Transaction tx = session.beginTransaction();
			query.executeUpdate();
			tx.commit();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Employe> lister() {
		List<Employe> employes = new ArrayList<Employe> ();
		
		try(Session session = SessionUtil.getSession()) {
			Query query = session.getNamedQuery("employe.findAll");
			employes = query.getResultList();
			return employes;
		}
	}
        
	@SuppressWarnings("unchecked")
        public List<Employe> chercher(String search) {
            List<Employe> employes = new ArrayList<Employe>();
            
            try (Session session = SessionUtil.getSession()) {
                String hql = "from Employe where codeemp like :search or nom like :search or prenom like :search or poste like :search";
                Query query = session.createQuery(hql);
                query.setParameter("search", "%" + search + "%");
                employes = query.getResultList();
                return employes;
            }
        }
        
	public void supprimer(String codeEmp) {
		try(Session session = SessionUtil.getSession()) {
			Employe employe = session.byId(Employe.class).getReference(codeEmp);
			
			Transaction tx = session.beginTransaction();
			session.delete(employe);
			tx.commit();
		}
	}
        
}
