package com.clientui.model;

import javafx.beans.Observable;

public enum Villes {
	STRASBOURG("Strasbourg"),
	COLMAR("Colmar"),
	INCONNU("Inconnu");
	
	private String name = "";
	
	Villes(String n) { 
		name = n;
	}
	public String toString() { 
		return name;
	}

}
