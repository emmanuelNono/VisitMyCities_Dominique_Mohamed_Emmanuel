package com.clientui.beans;



public class BatimentBean {

	private Integer id; 
	private String nom;
	private String adresse;
	private String coord_gps_ns;
	private String coord_gps_oe;
	private Integer annee_construction;
	private String couleur;
	private String description;
	private String architecte;
	private Integer ville;
	
	
	public BatimentBean() {
		super();
		
	}
	public BatimentBean(Integer id, String nom, String adresse, String coord_gps_ns, String coord_gps_oe,
			Integer annee_construction, String couleur, String description, String architecte, Integer ville) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.coord_gps_ns = coord_gps_ns;
		this.coord_gps_oe = coord_gps_oe;
		this.annee_construction = annee_construction;
		this.couleur = couleur;
		this.description = description;
		this.architecte = architecte;
		this.ville = ville;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCoord_gps_ns() {
		return coord_gps_ns;
	}
	public void setCoord_gps_ns(String coord_gps_ns) {
		this.coord_gps_ns = coord_gps_ns;
	}
	public String getCoord_gps_oe() {
		return coord_gps_oe;
	}
	public void setCoord_gps_oe(String coord_gps_oe) {
		this.coord_gps_oe = coord_gps_oe;
	}
	public Integer getAnnee_construction() {
		return annee_construction;
	}
	public void setAnnee_construction(Integer annee_construction) {
		this.annee_construction = annee_construction;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getArchitecte() {
		return architecte;
	}
	public void setArchitecte(String architecte) {
		this.architecte = architecte;
	}
	public Integer getVille() {
		return ville;
	}
	public void setVille(Integer ville) {
		this.ville = ville;
	}
	@Override
	public String toString() {
		return "BatimentBean [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", coord_gps_ns=" + coord_gps_ns
				+ ", coord_gps_oe=" + coord_gps_oe + ", annee_construction=" + annee_construction + ", couleur="
				+ couleur + ", description=" + description + ", architecte=" + architecte + ", ville=" + ville + "]";
	}
}
