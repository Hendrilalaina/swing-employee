package com.project2.hibernate.controllers;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.project2.hibernate.models.Affecter;
import com.project2.hibernate.models.Employe;
import com.project2.hibernate.models.Lieu;

public class ControllerTest {

	@Test
	public void test() {
//		EmployeController employeController = new EmployeController();
////		employeController.ajouter("John", "Doe", "Developper");
//		List<Employe> employes = employeController.lister();
//		for (Employe emp : employes) {
//			System.out.println(emp.getNom());
//		}
		
//		LieuController lieuController = new LieuController();
//		lieuController.ajouter("301", "Fianarantsoa", "Fianarantsoa");
//		List<Lieu> lieux = lieuController.lister();
//		for(Lieu lieu : lieux) {
//			System.out.println(lieu.getCodeLieu());
//		}
//		AffecterController affecterController = new AffecterController();
//		List<Affecter> affecters = affecterController.lister();
//		for(Affecter affecter : affecters) {
//			System.out.println(affecter.getId().getLieu().getCodeLieu());
//		}
//		EmployeController employeController = new EmployeController();
//		Employe employe = employeController.employe("EMP_0004");
//		System.out.println(employe.getPrenom());
		
		LieuController lieuController = new LieuController();
		Lieu lieu = lieuController.lieu("301");
		System.out.println(lieu.getDesignation());
		
	}

}
