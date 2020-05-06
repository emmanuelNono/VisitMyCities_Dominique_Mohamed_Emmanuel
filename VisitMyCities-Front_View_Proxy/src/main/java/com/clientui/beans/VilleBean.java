package com.clientui.beans;

import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.StringProperty;


public class VilleBean {

private LongProperty id;
private StringProperty vilNom;
private IntegerProperty vilCp;
private List<VisiteurBean> visiteurs;


public VilleBean(LongProperty id, StringProperty vilNom, IntegerProperty vilCp, List<VisiteurBean> visiteurs) {
	super();
	this.id = id;
	this.vilNom = vilNom;
	this.vilCp = vilCp;
	this.visiteurs = visiteurs;
}

public VilleBean() {
	super();
	// TODO Auto-generated constructor stub
}

public LongProperty getId() {
	return id;
}

public void setId(LongProperty id) {
	this.id = id;
}

public StringProperty getVilNom() {
	return vilNom;
}

public void setVilNom(StringProperty vilNom) {
	this.vilNom = vilNom;
}

public IntegerProperty getVilCp() {
	return vilCp;
}

public void setVilCp(IntegerProperty vilCp) {
	this.vilCp = vilCp;
}

public List<VisiteurBean> getVisiteurs() {
	return visiteurs;
}

public void setVisiteurs(List<VisiteurBean> visiteurs) {
	this.visiteurs = visiteurs;
}

@Override
public String toString() {
	return "VilleBean [id=" + id + ", vilNom=" + vilNom + ", vilCp=" + vilCp + "]";
}
}