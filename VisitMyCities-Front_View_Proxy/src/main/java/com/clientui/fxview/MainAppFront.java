package com.clientui.fxview;

import java.io.IOException;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

@SpringBootApplication
@EnableFeignClients
public class MainAppFront extends Application {

	private Stage stagePrincipal;
	private BorderPane conteneurPrincipal;
	/*
	@FXML
	public ComboBox<String> comboBoxVille; 
	MicroserviceVilleProxy mvp;
	
	*/
	@Override
	public void start(Stage primaryStage) {
		// on définit le stage
		stagePrincipal = primaryStage;
		stagePrincipal.setTitle("LP DAOO - VisitMyCities");
		
		// le conteneur
		initialisationConteneurPrincipal();
		// le contenu
		initialisationContenu();
	}

	private void initialisationConteneurPrincipal() {
		// on va chercher le fxml
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainAppFront.class.getResource("view/Menu.fxml"));
		try {
			//Le chargement nous donne notre conteneur
			conteneurPrincipal = (BorderPane) loader.load();
			//On définit une scène principale avec notre conteneur
			Scene scene = new Scene(conteneurPrincipal);
			// on affecte la scene au stage
			stagePrincipal.setScene(scene);
			// on personnalise le stage
			stagePrincipal.setWidth(800);
			stagePrincipal.setHeight(600);
			// on la rend visible
			stagePrincipal.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void initialisationContenu() {
		// on va chercher le fxml du contenu
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainAppFront.class.getResource("view/Home.fxml"));
		try {
			// on récupère le chargeur qui incluera les données => anchorpane
			AnchorPane conteneurHome = (AnchorPane) loader.load();
			// on ajout l'anchorpane conteurHome dans le borderpane conteneurPrincipal
			conteneurPrincipal.setCenter(conteneurHome);
			
			
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
