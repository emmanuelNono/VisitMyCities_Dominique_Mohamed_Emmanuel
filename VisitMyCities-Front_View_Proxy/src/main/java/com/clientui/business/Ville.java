package com.clientui.business;

import com.clientui.beans.VilleBean;

public class Ville {
	private Long id;
	private String nom;
	private int cp;
	
	public Ville() {
		super();
	}
	
	public Ville(VilleBean vb) {
		this.id = vb.getId().get();
		this.nom = vb.getVilNom().get();
		this.cp = vb.getVilCp().get();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	@Override
	public String toString() {
		return "Ville [id=" + id + ", nom=" + nom + ", cp=" + cp + "]";
	}
	
	
}
