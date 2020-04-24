package com.clientui.fxview;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.clientui.beans.ProductBean;
import com.clientui.beans.VilleBean;
import com.clientui.proxies.MicroserviceProduitsProxy;
import com.clientui.proxies.MicroserviceVilleProxy;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;

public class VilleEndure implements Initializable{

	@FXML
	public ComboBox<String> comboBoxVille;
	
//	@FXML
//	public ComboBox<VilleBean> comboBoxVilleBean;
//	
//	@FXML
//	public ListView<String> ListViewProduct;
	
	

	ObservableList<String> listVille  = FXCollections.observableArrayList("Allemagne", "Angleterre", "Belgique",
			"Espagne", "France", "Italie",
			"Pays-Bas", "Portugal", "Suisse");
	private ObservableList<VilleBean> getListVille = FXCollections.observableArrayList();
	
	
//	private ObservableList<ProductBean> product = FXCollections.observableArrayList();
//	
//	MicroserviceVilleProxy vp;
//	
//	private ObservableList<VilleBean> listVilleBean;
//	
//	private ObservableList<VilleBean> getListVille = FXCollections.observableArrayList(listVilleBean);
//	
//	 public void initialisationContent(VilleBean v) {
//		 
//		 //listVilleBean = (ObservableList<VilleBean>) vp.listVilles();
//		 //comboBoxVilleBean.setItems(v.getVilNom());
//		 //System.out.println(v.getVilNom());
//		 
//		 
//	 }
//	 
	MicroserviceVilleProxy villeproxy;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		//comboBoxVille.getSelectionModel().select(villeproxy.listVilles().toString());
		comboBoxVille.setItems(listVille);
		
		
//		List<VilleBean> villes = villeproxy.listVilles();
//		System.out.println(villes.size());
//		
//		for(VilleBean v: villes) {
//			System.out.println(" Nom de la ville [" + v.getVilNom() + "]");
//		}
		//comboBoxVille.getItems().setAll(villes.toString());
		
		
		
		
	}

	
}
