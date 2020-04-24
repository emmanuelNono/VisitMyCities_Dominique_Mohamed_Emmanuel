package com.clientui.fxview;

import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainAppFront extends Application {

	private Stage stagePrincipal;
	private BorderPane conteneurPrincipal;
	
	@Override
	public void start(Stage primaryStage) {
		stagePrincipal = primaryStage;
		
	
		
		//Ca ne vous rappelle pas une JFrame ?
		stagePrincipal.setTitle("Application de gestion de personnes");
		
		
		//Nous allons utiliser nos fichier FXML dans ces deux méthodes
		initialisationConteneurPrincipal();
		initialisationContenu();
	}

	private void initialisationConteneurPrincipal() {
		//On créé un chargeur de FXML
		FXMLLoader loader = new FXMLLoader();
		//On lui spécifie le chemin relatif à notre classe
		//du fichier FXML a charger : dans le sous-dossier view
		loader.setLocation(MainAppFront.class.getResource("Menu.fxml"));
		try {
			//Le chargement nous donne notre conteneur
			conteneurPrincipal = (BorderPane) loader.load();
			//On définit une scène principale avec notre conteneur
			Scene scene = new Scene(conteneurPrincipal);
			//Que nous affectons à notre Stage
			stagePrincipal.setScene(scene);
			//Pour l'afficher
			stagePrincipal.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void initialisationContenu() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainAppFront.class.getResource("Ville.fxml"));
		try {
			//Nous récupérons notre conteneur qui contiendra les données
			//Pour rappel, c'est un AnchorPane...
			AnchorPane conteneurPersonne = (AnchorPane) loader.load();
			//Qui nous ajoutons à notre conteneur principal
			//Au centre, puisque'il s'agit d'un BorderPane
			conteneurPrincipal.setCenter(conteneurPersonne);
			
			//PersonneMapping controleur = loader.getController();
			
			//controleur.setMainApp(this);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		launch(args);
	}
}
