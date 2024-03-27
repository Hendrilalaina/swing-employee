package com.project2.hibernate.idgenerator;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.project2.hibernate.models.Employe;
import com.project2.hibernate.models.Lieu;

@SuppressWarnings("serial")
@Embeddable
public class AffecterId implements Serializable {
	@ManyToOne
    @JoinColumn(name = "codeemp")
    private Employe employe;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "codelieu")
    private Lieu lieu;
    
    public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Lieu getLieu() {
		return lieu;
	}

	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}
	
	public AffecterId() {
		super();
	}
	
	public AffecterId(Employe employe, Lieu lieu) {
		this.employe = employe;
		this.lieu = lieu;
		
	}

	@Override
    public boolean equals(Object o) {
    	if(this == o) return true;
    	if(!(o instanceof AffecterId)) return false;
    	
    	AffecterId id = (AffecterId) o;
    	
    	if(employe != id.getEmploye()) return false;
    	if(lieu != id.getLieu()) return false;
    	return true;
    }
    
    
}
