package com.clientui.fxview.view;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clientui.beans.VilleBean;
import com.clientui.business.Ville;
import com.clientui.fxview.MainAppFront;
import com.clientui.proxies.MicroserviceVilleProxy;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import net.rgielen.fxweaver.core.FxmlView;

//@Component
@FxmlView("Home.fxml")
public class ChoixVilleMapping {
	// référence à notre champ combo qui aura la liste des ville de notre MSA
	@FXML
	//private ComboBox<Ville> comboBoxVille; // pour msa
	private ComboBox<String> comboBoxVilleBean; // pour test en dur
	
	// le lien avec le msa
	//@Autowired
	//private MicroserviceVilleProxy mvp;
	
	// constructeur par défaut
	/*
	public ChoixVilleMapping(){
		mvp = MainAppFront.getApplicationContext().getBean(MicroserviceVilleProxy.class);
	}
	*/
	
	// initialisation avec nos données métiers
	@FXML
	private void initialize() {
		//System.out.println("dans initialize");
		
		// on affecte villes au champ Combo
		// test en dur
		ObservableList<String> listVille  = FXCollections.observableArrayList("Berlin", "Londres", "Bruxelles",
				"Madrid", "Paris", "Malin",
				"Amsterdam", "Lisbonne", "Bâle");
		comboBoxVilleBean.setItems(listVille);
		
		// par msa
		//String jsonVilles = mvp.getListeVilles();
		//ObservableList<VilleBean> villes;
		//villes = (ObservableList<VilleBean>) mvp.getListeVilles();
		//comboBoxVilleBean.setItems(villes);
	//	List<VilleBean> villebean;
	//	villebean = mvp.getListeVilles();
	//	List<Ville> villes = villebean.stream().map(v->new Ville(v)).collect(Collectors.toList());
	//	ObservableList<Ville> villeObservable = FXCollections.observableArrayList(villes);
	//	comboBoxVille.setItems(villeObservable);
	}
}