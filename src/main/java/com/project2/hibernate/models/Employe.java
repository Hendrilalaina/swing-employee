package com.project2.hibernate.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.project2.hibernate.idgenerator.CustomGenerator;

@NamedQueries({
	@NamedQuery(name = "employe.findAll", query = "from Employe employe"),
	@NamedQuery(name = "employe.findByName", query = "from Employe employe where employe.nom like :name or employe.prenom like :name"),
	@NamedQuery(name = "employe.findByPoste", query = "from Employe employe where employe.poste like :poste"),
	@NamedQuery(name = "employe.update", query = "update Employe employe set employe.nom = :nom, employe.prenom = :prenom, employe.poste = :poste where employe.codeEmp = :code"),
	
})

@Entity
public class Employe {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employe_seq")
	@GenericGenerator(name = "employe_seq",strategy = "com.project2.hibernate.idgenerator.CustomGenerator", parameters = {
			@Parameter(name = CustomGenerator.VALUE_PREFIX_PARAMETER, value = "EMP_"),
			@Parameter(name = CustomGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")}
	)
    @Column(name = "codeemp", updatable = false, nullable = false)
    private String codeEmp;
    
    @Column(name = "Nom")
    private String nom;
    
    @Column(name = "Prenom")
    private String prenom;
    
    @Column(name = "Poste")
    private String poste;

    public String getCodeEmp() {
		return codeEmp;
	}
    
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}
}
