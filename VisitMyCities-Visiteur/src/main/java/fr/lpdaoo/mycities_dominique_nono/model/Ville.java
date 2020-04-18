package fr.lpdaoo.mycities_dominique_nono.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ville {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String vilNom;
	private int vilCp;
	@OneToMany(mappedBy = "ville")
	private List<Visiteur> visiteurs;

	public Ville() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ville(Long id, String vilNom, int vilCp) {
		super();
		this.id = id;
		this.vilNom = vilNom;
		this.vilCp = vilCp;
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

	@Override
	public String toString() {
		return "Ville [id=" + id + ", vilNom=" + vilNom + ", vilCp=" + vilCp + "]";
	}

}
