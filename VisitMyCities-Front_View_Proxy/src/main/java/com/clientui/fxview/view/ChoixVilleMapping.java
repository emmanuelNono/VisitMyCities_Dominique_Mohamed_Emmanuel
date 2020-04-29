package com.clientui.fxview.view;

import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clientui.beans.VilleBean;
import com.clientui.proxies.MicroserviceVilleProxy;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("Home.fxml")
public class ChoixVilleMapping {
	// référence à notre champ combo qui aura la liste des ville de notre MSA
	@FXML
	//private ComboBox<VilleBean> comboBoxVilleBean; // pour msa
	private ComboBox<String> comboBoxVilleBean; // pour test en dur
	
	// le lien avec le msa
	@Autowired
	private MicroserviceVilleProxy mvp;
	
	// constructeur par défaut
	public ChoixVilleMapping(){}
	
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
		ObservableList<VilleBean> villes;
		villes = (ObservableList<VilleBean>) mvp.getListeVilles();
		//comboBoxVilleBean.setItems(villes);
	}
}