package com.project2.hibernate.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project2.hibernate.idgenerator.AffecterId;
import com.project2.hibernate.models.Affecter;
import com.project2.hibernate.models.Employe;
import com.project2.hibernate.models.Lieu;
import com.project2.hibernate.sessions.SessionUtil;

public class AffecterController {
	public void ajouter(String codeEmp, String codeLieu, LocalDate dateaffect) {
		try(Session session = SessionUtil.getSession()) {
			Employe employe = session.byId(Employe.class).getReference(codeEmp);
			Lieu lieu = session.byId(Lieu.class).getReference(codeLieu);
			
			AffecterId id = new AffecterId(employe, lieu);
			Affecter affecter = new Affecter(id, dateaffect);
			
			Transaction tx = session.beginTransaction();
			session.save(affecter);
			tx.commit();
		}
	}
	
	public Affecter affecter(String codeEmp, String codeLieu) {
		try(Session session = SessionUtil.getSession()) {
			Employe employe = session.byId(Employe.class).getReference(codeEmp);
			Lieu lieu = session.byId(Lieu.class).getReference(codeLieu);
			AffecterId affecterId = new AffecterId(employe, lieu);
			Affecter affecter = session.byId(Affecter.class).getReference(affecterId);
			
			return affecter;
		}
	}
	
	public void supprimer(String codeEmp, String codeLieu) {
		try(Session session = SessionUtil.getSession()) {
			Employe employe = session.byId(Employe.class).getReference(codeEmp);
			Lieu lieu = session.byId(Lieu.class).getReference(codeLieu);
			AffecterId affecterId = new AffecterId(employe, lieu);
			Affecter affecter = session.byId(Affecter.class).getReference(affecterId);
			
			Transaction tx = session.beginTransaction();
			session.delete(affecter);
			tx.commit();
		}
	}
	
	public void modifier(String codeEmp,String codeLieu, String designation, LocalDate dateaffect) {
		try(Session session = SessionUtil.getSession()) {
			Query query = session.createQuery("update Affecter set dateaffect = :dateaffect, codelieu = (select codeLieu from Lieu where designation = :designation) where codeemp = :codeEmp and codelieu = :codeLieu");
			query.setParameter("dateaffect", dateaffect);
			query.setParameter("codeEmp", codeEmp);
			query.setParameter("designation", designation);
                        query.setParameter("codeLieu", codeLieu);
			
			Transaction tx = session.beginTransaction();
			query.executeUpdate();
			tx.commit();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Affecter> lister() {
		List<Affecter> affecters = new ArrayList<Affecter>();
		try(Session session = SessionUtil.getSession()) {
			Query query = session.getNamedQuery("affecter.findAll");
			affecters = query.getResultList();
			return affecters;
		}
	}
        
        @SuppressWarnings("unchecked")
        public List<Affecter> chercher(String search) {
            List<Affecter> affecters = new ArrayList<Affecter>();
            try(Session session = SessionUtil.getSession()) {
                String hql = "from Affecter where codeemp like :search or codelieu in (select codeLieu from Lieu where designation like :search) or dateaffect like :search";
                Query query = session.createQuery(hql);
                query.setParameter("search", "%" + search + "%");
                affecters = query.getResultList();
                return affecters;
            }
        }
}