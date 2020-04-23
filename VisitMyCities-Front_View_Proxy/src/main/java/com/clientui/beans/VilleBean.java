package com.clientui.beans;

import java.util.List;


public class VilleBean {




private Long id;
private String vilNom;
private int vilCp;

private List<VisiteurBean> visiteurs;


public VilleBean(Long id, String vilNom, int vilCp, List<VisiteurBean> visiteurs) {
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

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getVilNom() {
	return vilNom;
}

public void setVilNom(String vilNom) {
	this.vilNom = vilNom;
}

public int getVilCp() {
	return vilCp;
}

public void setVilCp(int vilCp) {
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