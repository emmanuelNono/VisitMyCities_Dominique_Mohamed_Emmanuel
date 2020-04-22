package fr.lpdaoo.VisitMyCitiesBatiment.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Batiment implements Serializable{
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
	
	@Column(name="bat_description", columnDefinition = "TEXT")
	private String description;
	
	@Column(name="bat_architecte")
	private String architecte;
	
	@Column(name="bat_ville")
	private Integer ville;
	
	@OneToMany @JoinColumn(name="pho_id")
	private Collection<Photo> photos;
	
	public Batiment() {
		super();
	}
	
	public Batiment(Integer id) {
		super();
		this.id = id;
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
	public Integer getAnneeConstruction() {
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
		return "Batiment [id=" + this.id + ", nom=" + this.nom + ", adresse=" + this.adresse
				+ ", coord_gps_ns=" + this.coord_gps_ns + ", coord_gps_oe=" + this.coord_gps_oe
				+ ", annee_construction=" + this.annee_construction + ", couleur=" + this.couleur
				+ ", description=" + this.description + ", architecte=" + this.architecte 
				+ ", ville=" + this.ville + "]";
	}	
}
