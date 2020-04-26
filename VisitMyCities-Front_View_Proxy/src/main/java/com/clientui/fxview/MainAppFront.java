package com.clientui.fxview;

import java.io.IOException;

import com.clientui.fxview.view.ChoixVilleMapping;
import com.clientui.fxview.view.VMCMenuMapping;
import com.clientui.model.Villes;
import com.clientui.proxies.MicroserviceVilleProxy;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainAppFront extends Application {

	private Stage stagePrincipal;
	private BorderPane conteneurPrincipal;
	@FXML
	public ComboBox<String> comboBoxVille; 
	MicroserviceVilleProxy mvp;
	
	/*
	ObservableList<String> listDeVilles  = FXCollections.observableArrayList("Allemagne", "Angleterre", "Belgique",
			"Espagne", "France", "Italie",
			"Pays-Bas", "Portugal", "Suisse");
	
	*/
	/*
	public ObservableList<String> getListOfVille() {
		return listDeVilles;
	}
	*/
	
	@Override
	public void start(Stage primaryStage) {
		// les stages
		stagePrincipal = primaryStage;
		stagePrincipal.setTitle("LP DAOO - VisitMyCities");
		
		// les conteneur
		initialisationConteneurPrincipal();
		// le contenu
		initialisationContenu();
	}

	private void initialisationConteneurPrincipal() {
		FXMLLoader loader = new FXMLLoader();
		
		loader.setLocation(MainAppFront.class.getResource("view/Menu.fxml"));
		try {
			//Le chargement nous donne notre conteneur
			conteneurPrincipal = (BorderPane) loader.load();
			//On définit une scène principale avec notre conteneur
			Scene scene = new Scene(conteneurPrincipal);
		
			stagePrincipal.setScene(scene);
			stagePrincipal.setWidth(800);
			stagePrincipal.setHeight(600);
		
			stagePrincipal.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void initialisationContenu() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainAppFront.class.getResource("view/Home.fxml"));
		try {
			AnchorPane conteneurHome = (AnchorPane) loader.load();
			conteneurPrincipal.setCenter(conteneurHome);
			
			ChoixVilleMapping controleur = loader.getController();
			controleur.setMainApp(this);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		launch(args);
	}
	
	public Stage getStage() {
		return this.stagePrincipal;
	}
}
