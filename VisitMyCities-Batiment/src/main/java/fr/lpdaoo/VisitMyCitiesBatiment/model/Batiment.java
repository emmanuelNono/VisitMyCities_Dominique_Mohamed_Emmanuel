package fr.lpdaoo.VisitMyCitiesBatiment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Batiment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bat_id")
	private Integer id; 
	
	@Column(name="bat_nom")
	private String nom;
	
	@Column(name="bat_adresse")
	private String adresse;
	
	@Column(name="bat_coord_gps_ns")
	private String coord_gps_ns;
	
	@Column(name="bat_coord_gps_oe")
	private String coord_gps_oe;
	
	@Column(name="bat_annee_construction")
	private Integer annee_construction;
	
	@Column(name="bat_couleur")
	private String couleur;
	
	@Column(name="bat_description")
	private String description;
	
	@Column(name="bat_architecte")
	private String architecte;
	
	@Column(name="bat_ville")
	private Integer ville;
	
	
	
	public Batiment() {
		super();
	}
	
	public Batiment(Integer bat_id) {
		super();
		this.id = bat_id;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer bat_id) {
		this.id = bat_id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String bat_nom) {
		this.nom = bat_nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String bat_adresse) {
		this.adresse = bat_adresse;
	}
	public String getCoord_gps_ns() {
		return coord_gps_ns;
	}
	public void setCoord_gps_ns(String bat_coord_gps_ns) {
		this.coord_gps_ns = bat_coord_gps_ns;
	}
	public String getCoordGpsOe() {
		return coord_gps_oe;
	}
	public void setCoord_gps_oe(String bat_coord_gps_oe) {
		this.coord_gps_oe = bat_coord_gps_oe;
	}
	public Integer getAnneeConstruction() {
		return annee_construction;
	}
	public void setAnnee_construction(Integer bat_annee_construction) {
		this.annee_construction = bat_annee_construction;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String bat_couleur) {
		this.couleur = bat_couleur;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String bat_description) {
		this.description = bat_description;
	}
	public String getArchitecte() {
		return architecte;
	}
	public void setArchitecte(String bat_architecte) {
		this.architecte = bat_architecte;
	}
	public Integer getVille() {
		return ville;
	}
	public void setVille(Integer bat_ville) {
		this.ville = bat_ville;
	}

	@Override
	public String toString() {
		return "Batiment [bat_id=" + id + ", bat_nom=" + nom + ", bat_adresse=" + adresse
				+ ", bat_coord_gps_ns=" + coord_gps_ns + ", bat_coord_gps_oe=" + coord_gps_oe
				+ ", bat_annee_construction=" + annee_construction + ", bat_couleur=" + couleur
				+ ", bat_description=" + description + ", bat_architecte=" + architecte + ", bat_ville="
				+ ville + "]";
	}	
}
