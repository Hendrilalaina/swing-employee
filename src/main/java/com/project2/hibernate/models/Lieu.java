package com.project2.hibernate.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "lieu.findAll", query = "from Lieu lieu"),
	@NamedQuery(name = "lieu.findByDesignation",query = "from Lieu lieu where lieu.designation = :designation"),
	@NamedQuery(name = "lieu.findByProvince", query = "from Lieu lieu where lieu.province = :province"),
	@NamedQuery(name = "lieu.update", 
	query = "update Lieu lieu set lieu.codeLieu = :newCode, lieu.designation = :designation, lieu.province = :province where lieu.codeLieu = :lastCode"),
})
public class Lieu {
	@Id
    @Column(name = "codelieu", nullable = false)
    private String codeLieu;

	@Column(name = "Designation")
    private String designation;
    
    @Column(name = "Province")
    private String province;
    
    public String getCodeLieu() {
		return codeLieu;
	}

	public void setCodeLieu(String codeLieu) {
		this.codeLieu = codeLieu;
	}
    
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
}


