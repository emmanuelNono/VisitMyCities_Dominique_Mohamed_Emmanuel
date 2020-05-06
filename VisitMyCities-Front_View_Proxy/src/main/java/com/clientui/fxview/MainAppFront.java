package com.clientui.fxview;

import java.io.IOException;
import java.net.URL;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

import com.clientui.MySpringBootApplication;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;

public class MainAppFront extends Application {
	private static ConfigurableApplicationContext applicationcontext;
	
	//private Stage stagePrincipal;
	//private BorderPane conteneurPrincipal;
	
	private Stage stage;
	
	//@FXML
	//public ComboBox<String> comboBoxVille; 
	//MicroserviceVilleProxy mvp;
	
	@Override
	public void init() {
	 	String[] args = getParameters().getRaw().toArray(new String[0]);
	 	this.applicationcontext = new SpringApplicationBuilder()
	 			.sources(MySpringBootApplication.class)
	 			.run(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		// on définit le stage
		//stagePrincipal = primaryStage;
		//stagePrincipal.setTitle("LP DAOO - VisitMyCities");
		
		// le conteneur
		//initialisationConteneurPrincipal();
		// le contenu
		//initialisationContenu();
		
		FXMLLoader loader = new FXMLLoader();
		URL xmlUrl = getClass().getResource("/fx/Home.fxml");
		loader.setLocation(xmlUrl);
		
		try {
			Parent root = loader.load();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setWidth(800);
			stage.setHeight(600);
			stage.setTitle("Visit My Cities : Dominique, Emmanuel et Mohamed");
			stage.show();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	
	/*
	private void initialisationConteneurPrincipal() {
		// on va chercher le fxml
		FXMLLoader loader = new FXMLLoader();
		URL xmlUrl = getClass().getResource("/fx/Menu.fxml");
		//loader.setLocation(MainAppFront.class.getResource("/fx/Menu.fxml"));
		loader.setLocation(xmlUrl);
		
	/*	try {
			
			// on passe par Spring
			//Parent root = loader.load();
			
			//Le chargement nous donne notre conteneur
			
			//conteneurPrincipal = (BorderPane) loader.load();
			
			// on affecte la scene au stage
			// on passe par Spring
			//FxWeaver fxWeaver = applicationcontext.getBean(FxWeaver.class);
			//Parent root = fxWeaver.loadView(MainAppFront.class);
			
			Parent conteneurPrincipal = loader.load();
			
			//On définit une scène principale avec notre conteneur
		//	Scene scene = new Scene(conteneurPrincipal);

			// on assigne la scene
			// on passe par Spring
			//Scene scene = new Scene(root);
			// directement
		//	stagePrincipal.setScene(scene);
			
			// on personnalise le stage
		//	stagePrincipal.setWidth(800);
		//	stagePrincipal.setHeight(600);
			// on la rend visible
		//	stagePrincipal.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
*/
	
	
	/*
	private void initialisationContenu() {
		// on va chercher le fxml du contenu
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainAppFront.class.getResource("view/Home.fxml"));
		try {
			// on récupère le chargeur qui incluera les données => anchorpane
			AnchorPane conteneurHome = (AnchorPane) loader.load();
			// on ajout l'anchorpane conteurHome dans le borderpane conteneurPrincipal
			//conteneurHome.setCenter(conteneurHome);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	*/
	
	@Override
	public void stop() {
		this.applicationcontext.close();
	}

	/*
	public Stage getStage() {
		return this.root;
	}
	*/
}
