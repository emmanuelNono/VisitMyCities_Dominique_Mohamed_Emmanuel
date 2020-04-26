package com.clientui.fxview.view;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;

import com.clientui.beans.VilleBean;
import com.clientui.fxview.MainAppFront;
import com.clientui.model.Villes;
import com.clientui.proxies.MicroserviceVilleProxy;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class ChoixVilleMapping {
	@FXML
	//public ComboBox<VilleBean> comboBoxVilleBean;
	public ComboBox<String> comboBoxVilleBean;
	
	// référence à notre classe principae => pour récupérer les objects
	private MainAppFront main;
	
	@Autowired
	private MicroserviceVilleProxy mvp;
	
	// constructeur par défaut
	public ChoixVilleMapping(){}
	
	// initialisation avec nos données métiers
	@FXML
	private void initialize() {
		System.out.println("dans initialize");
		
	}
	
	
	// sera utilisée dans l'initalisation de l'ihm
	// dans notre classe principale
	public void setMainApp(MainAppFront m) {
		this.main = m;
		
		// avec donnes des microservices
		this.main = m;
		//comboBoxVilleBean.setItems((ObservableList<VilleBean>) mvp.listVilles());
		
		// avec donnes en dur
		/*
		  ObservableList<String> listVille  = FXCollections.observableArrayList("Allemagne", "Angleterre", "Belgique",
		 
				"Espagne", "France", "Italie",
				"Pays-Bas", "Portugal", "Suisse");
				*/
		
		
		//comboBoxVilleBean.setItems(main.getListOfVille());
		//comboBoxVilleBean.setItems(Villes.values());
		// on affecte à comboBoxVille ?
		System.out.println("ici ?");
		//ObservableList<VilleBean> villes = mvp.listVilles();
		//System.out.println("nb ville : " + mvp.listVilles().get(0).toString());
		//comboBoxVilleBean.setItems(mvp.listVilles());
		/*
		((Object) comboBoxVilleBean).setCellRenderer(new DefaultListCellRender() {
								mvp.listVilles();	
						});
		*/
	}

	
}
