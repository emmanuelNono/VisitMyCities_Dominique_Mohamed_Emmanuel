package fr.lpdaoo.VisitMyCitiesBatiment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Batiment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer bat_id;
	private String bat_nom;
	private String bat_adresse;
	private String bat_coord_gps_ns;
	private String bat_coord_gps_oe;
	private Integer bat_annee_construction;
	private String bat_couleur;
	private String bat_description;
	private String bat_architecte;
	private Integer bat_ville;
	
	
	
	public Batiment() {
		super();
	}
	
	public Batiment(Integer bat_id) {
		super();
		this.bat_id = bat_id;
	}
	
	
	public Integer getBat_id() {
		return bat_id;
	}
	public void setBat_id(Integer bat_id) {
		this.bat_id = bat_id;
	}
	public String getBat_nom() {
		return bat_nom;
	}
	public void setBat_nom(String bat_nom) {
		this.bat_nom = bat_nom;
	}
	public String getBat_adresse() {
		return bat_adresse;
	}
	public void setBat_adresse(String bat_adresse) {
		this.bat_adresse = bat_adresse;
	}
	public String getBat_coord_gps_ns() {
		return bat_coord_gps_ns;
	}
	public void setBat_coord_gps_ns(String bat_coord_gps_ns) {
		this.bat_coord_gps_ns = bat_coord_gps_ns;
	}
	public String getBat_coord_gps_oe() {
		return bat_coord_gps_oe;
	}
	public void setBat_coord_gps_oe(String bat_coord_gps_oe) {
		this.bat_coord_gps_oe = bat_coord_gps_oe;
	}
	public Integer getBat_annee_construction() {
		return bat_annee_construction;
	}
	public void setBat_annee_construction(Integer bat_annee_construction) {
		this.bat_annee_construction = bat_annee_construction;
	}
	public String getBat_couleur() {
		return bat_couleur;
	}
	public void setBat_couleur(String bat_couleur) {
		this.bat_couleur = bat_couleur;
	}
	public String getBat_description() {
		return bat_description;
	}
	public void setBat_description(String bat_description) {
		this.bat_description = bat_description;
	}
	public String getBat_architecte() {
		return bat_architecte;
	}
	public void setBat_architecte(String bat_architecte) {
		this.bat_architecte = bat_architecte;
	}
	public Integer getBat_ville() {
		return bat_ville;
	}
	public void setBat_ville(Integer bat_ville) {
		this.bat_ville = bat_ville;
	}

	@Override
	public String toString() {
		return "Batiment [bat_id=" + bat_id + ", bat_nom=" + bat_nom + ", bat_adresse=" + bat_adresse
				+ ", bat_coord_gps_ns=" + bat_coord_gps_ns + ", bat_coord_gps_oe=" + bat_coord_gps_oe
				+ ", bat_annee_construction=" + bat_annee_construction + ", bat_couleur=" + bat_couleur
				+ ", bat_description=" + bat_description + ", bat_architecte=" + bat_architecte + ", bat_ville="
				+ bat_ville + "]";
	}	
}
