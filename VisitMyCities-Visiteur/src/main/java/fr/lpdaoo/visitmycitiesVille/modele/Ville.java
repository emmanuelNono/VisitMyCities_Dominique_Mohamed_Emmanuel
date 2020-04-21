package fr.lpdaoo.visitmycitiesVille.modele;

public class Ville {

	private int idVille;
	private String nomVille;
	private int codePostal;
	
	public Ville() {
		
	}

	public Ville(int idVille, String nomVille, int codePostal) {
		super();
		this.idVille = idVille;
		this.nomVille = nomVille;
		this.codePostal = codePostal;
	}

	public int getIdVille() {
		return idVille;
	}

	public void setIdVille(int idVille) {
		this.idVille = idVille;
	}

	public String getNomVille() {
		return nomVille;
	}

	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	@Override
	public String toString() {
		return "Ville [idVille=" + idVille + ", nomVille=" + nomVille + ", codePostal=" + codePostal + "]";
	}
	
	
	
	
	
	
}
