package fr.lpdaoo.mycities_dominique_nono.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AVisiter {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int idBat;
	
	@ManyToOne	@JoinColumn(name = "idVis")
	private Visiteur visiteur;

	public AVisiter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AVisiter(Long id, int idBat, Visiteur visiteur) {
		super();
		this.id = id;
		this.idBat = idBat;
		this.visiteur = visiteur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public int getIdBat() {
		return idBat;
	}

	public void setIdBat(int idBat) {
		this.idBat = idBat;
	}

	public Visiteur getVisiteur() {
		return visiteur;
	}

	public void setVisiteur(Visiteur visiteur) {
		this.visiteur = visiteur;
	}
	
	
}
