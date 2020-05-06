package com.clientui.business;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.StringProperty;

public class VilleFX {
	private LongProperty id;
	private StringProperty nom;
	private IntegerProperty cp;
	
	public VilleFX() {
		// TODO Auto-generated constructor stub
	}
	
	public VilleFX(Ville v) {
		id.set(v.getId());
		nom.set(v.getNom());
		cp.set(v.getCp());
	}

	public LongProperty getId() {
		return id;
	}

	public void setId(LongProperty id) {
		this.id = id;
	}

	public StringProperty getNom() {
		return nom;
	}

	public void setNom(StringProperty nom) {
		this.nom = nom;
	}

	public IntegerProperty getCp() {
		return cp;
	}

	public void setCp(IntegerProperty cp) {
		this.cp = cp;
	}	
}
