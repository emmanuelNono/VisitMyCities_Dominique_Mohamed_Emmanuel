package com.clientui.model;

import javafx.beans.Observable;

public enum Villes_zz {
	STRASBOURG("Strasbourg"),
	COLMAR("Colmar"),
	INCONNU("Inconnu");
	
	private String name = "";
	
	Villes_zz(String n) { 
		name = n;
	}
	public String toString() { 
		return name;
	}

}
