package com.clientui.fxview;

import java.io.IOException;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

import com.clientui.MySpringBootApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;

@SpringBootApplication
@EnableFeignClients
public class MainAppFront extends Application {

	private ConfigurableApplicationContext applicationcontext;
	private Stage stagePrincipal;
	private BorderPane conteneurPrincipal;
	/*
	@FXML
	public ComboBox<String> comboBoxVille; 
	MicroserviceVilleProxy mvp;
	
	*/
	@Override
	public void start(Stage primaryStage) {
		System.out.println("dans JavaFX : start");
		String[] args = getParameters().getRaw().toArray( new String[0]);
		this.applicationcontext = new SpringApplicationBuilder()
											.sources(MySpringBootApplication.class)
											.run(args);
		
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
			// on passe par Spring
			//Parent root = loader.load();
			
			//Le chargement nous donne notre conteneur
			conteneurPrincipal = (BorderPane) loader.load();
			
			// on affecte la scene au stage
			// on passe par Spring
			FxWeaver fxWeaver = applicationcontext.getBean(FxWeaver.class);
			Parent root = fxWeaver.loadView(MainAppFront.class);
			
			//On définit une scène principale avec notre conteneur
			//Scene scene = new Scene(conteneurPrincipal);

			// on passe par Spring
			Scene scene = new Scene(root);
			
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
	
	public void init() {
		System.out.println("dans JavaFX : init");
		/*
		  String[] args = getParameters().getRaw().toArray( new String[0]);
		 
		
		this.applicationcontext = new SpringApplicationBuilder()
										.sources(MySpringBootApplication.class)
										.run(args);
										
										*/
	}
}
