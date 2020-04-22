package fr.lpdaoo.mycities_dominique_nono.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Visiteur {
	
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String visNom;
	private String visPrenom;
	private String visAdresse;
	private int visCp;
	private String visVille;
	private String visEmail;
	private String visMdp;
	@ManyToOne	@JoinColumn(name = "idVille") 
	private Ville ville; //correspond à la ville de la classe Ville

	public Visiteur() {
		super();
		
	}

	public Visiteur(Long id, String visNom, String visPrenom, String visAdresse, int visCp, String visVille,
			String visEmail, String visMdp, Ville ville) {
		super();
		this.id = id;
		this.visNom = visNom;
		this.visPrenom = visPrenom;
		this.visAdresse = visAdresse;
		this.visCp = visCp;
		this.visVille = visVille;
		this.visEmail = visEmail;
		this.visMdp = visMdp;
		this.ville = ville;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVisNom() {
		return visNom;
	}

	public void setVisNom(String visNom) {
		this.visNom = visNom;
	}

	public String getVisPrenom() {
		return visPrenom;
	}

	public void setVisPrenom(String visPrenom) {
		this.visPrenom = visPrenom;
	}

	public String getVisAdresse() {
		return visAdresse;
	}

	public void setVisAdresse(String visAdresse) {
		this.visAdresse = visAdresse;
	}

	public int getVisCp() {
		return visCp;
	}

	public void setVisCp(int visCp) {
		this.visCp = visCp;
	}

	public String getVisVille() {
		return visVille;
	}

	public void setVisVille(String visVille) {
		this.visVille = visVille;
	}

	public String getVisEmail() {
		return visEmail;
	}

	public void setVisEmail(String visEmail) {
		this.visEmail = visEmail;
	}

	public String getVisMdp() {
		return visMdp;
	}

	public void setVisMdp(String visMdp) {
		this.visMdp = visMdp;
	}
	
	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Visiteur [id=" + id + ", visNom=" + visNom + ", visPrenom=" + visPrenom + ", visAdresse=" + visAdresse
				+ ", visCp=" + visCp + ", visVille=" + visVille + ", visEmail=" + visEmail + ", visMdp=" + visMdp
				+ ", ville=" + ville + "]";
	}

}
