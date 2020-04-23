package com.clientui.fxview;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.clientui.beans.ProductBean;

import fr.testfx.personnes.model.Personne;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class VilleEndure implements Initializable{

	@FXML
	public ComboBox<String> comboBoxVille;
	
	@FXML
	public ListView<String> ListViewProduct;

	ObservableList<String> listVille  = FXCollections.observableArrayList("Allemagne", "Angleterre", "Belgique",
			"Espagne", "France", "Italie",
			"Pays-Bas", "Portugal", "Suisse");
	
	private ObservableList<String> listVilleBean = FXCollections.observableArrayList();
	private ObservableList<ProductBean> product = FXCollections.observableArrayList();
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		//comboBoxVille.setItems(listVille);
	
		Map<String, Integer>  map = new HashMap<>();
		
		for(Object prod: product) {
			
			System.out.println(" Titre produit " + prod.toString());
			map.put(prod.toString(), 1);
			
		}
		
		comboBoxVille.setItems(listVilleBean);
		//ListViewProduct.setItems();
		
		
	}

	
}
