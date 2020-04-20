package fr.lpdaoo.VisitMyCitiesBatiment.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Photo implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pho_id")
	private int id;
	
	@Column(name="pho_titre")
	private String titre;
	
	@Column(name="pho_source")
	private String source;

	@ManyToOne
	private Batiment batiment;
	
	public Photo() {
		super();
	}
	

	public Photo(int id) {
		super();
		this.id = id;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "Photo [id=" + id + ", titre=" + titre + ", source=" + source + "]";
	}
}
