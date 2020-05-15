package fr.lpdaoo.VisitMyCitiesClientFX.model.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VilleBean {
	private Long id;
	private String vilNom;
	private int vilCp;
	public VilleBean() {
		super();
	}
	public VilleBean(Long id, String vilNom, int vilCp) {
		super();
		this.id = id;
		this.vilNom = vilNom;
		this.vilCp = vilCp;
	}
	public VilleBean(VilleBean v) {
		this.id = v.getId();
		this.vilNom = v.getVilNom();
		this.vilCp = v.getVilCp();
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
