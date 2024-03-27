package com.project2.hibernate.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import com.project2.hibernate.idgenerator.AffecterId;

@Entity
@NamedQuery(name = "affecter.findAll", query = "from Affecter affecter")
public class Affecter {  

	@Id
	private AffecterId id;
    
    @Column(name = "dateaffect")
    private LocalDate date;

	public AffecterId getId() {
		return id;
	}

	public void setId(AffecterId id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
    
    public Affecter() {
    	
    }

	public Affecter(AffecterId id, LocalDate dateaffect) {
		this.id = id;
		this.date = dateaffect;
	}
}
