package com.clientui.fxview.view;

import com.clientui.fxview.MainAppFront;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class VMCMenuMapping {
	private MainAppFront main;
	
	public void setMainApp(MainAppFront mainApp) {
		this.main = mainApp;
	}
	/** 
	 * Menu > Quitter
	 */
	@FXML
	public void fermer() {
		Alert bye = new Alert(AlertType.INFORMATION);
		bye.setTitle("Au revoir !");
		bye.setHeaderText("See you soon...");
		bye.setContentText("Et erci d'avoir suivi ce cours");
		bye.showAndWait();
		
		//Et on clos le stage principal, donc l'application
		this.main.getStage().close();
	}
	
	/**
	 * Menu > Nouveau
	 */
	@FXML
	public void nouveau() {
		//this.main.affichePersonneDialogue(new Personne(), "Création d'une personne");
	}
	
	
}
