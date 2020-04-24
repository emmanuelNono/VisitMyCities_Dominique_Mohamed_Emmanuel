package com.clientui.fxview;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.clientui.beans.ProductBean;
import com.clientui.beans.VilleBean;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class VilleEndure implements Initializable{

	@FXML
	public ComboBox<VilleBean> comboBoxVille;
	
	@FXML
	public ListView<String> ListViewProduct;

	ObservableList<String> listVille  = FXCollections.observableArrayList("Allemagne", "Angleterre", "Belgique",
			"Espagne", "France", "Italie",
			"Pays-Bas", "Portugal", "Suisse");
	
	
	private ObservableList<ProductBean> product = FXCollections.observableArrayList();
	
	private ObservableList<VilleBean> listVilleBean = FXCollections.observableArrayList();
	
	private ObservableList<VilleBean> getListVille = FXCollections.observableArrayList(listVilleBean);
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		//comboBoxVille.setItems(listVille);
	
		
		
		
		comboBoxVille.setItems(getListVille);
	
		
		
	}

	
}
