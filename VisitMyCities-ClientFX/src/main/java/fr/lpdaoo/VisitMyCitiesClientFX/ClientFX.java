package fr.lpdaoo.VisitMyCitiesClientFX;

import java.io.IOException;
import java.net.URL;

//import fr.lpdaoo.VisitMyCitiesClientFX.fx;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import fr.lpdaoo.VisitMyCitiesClientFX.fx.ChoixVilleMapping;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


@Component
@EnableFeignClients("fr.lpdaoo.VisitMyCitiesClientFX.proxy") 
public class ClientFX extends Application {
	private ConfigurableApplicationContext applicationContext;
	
	@Override
	public void init() {
		String args[] = getParameters().getRaw().toArray(new String [0]);
		this.applicationContext = new SpringApplicationBuilder()
				.sources(SpringBootVMCClientFxApplication.class)
				.run(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception{
		// creation de la fenetre
		FXMLLoader loader = new FXMLLoader();
		URL xmlUrl = getClass().getResource("/fr/lpdaoo/VisitMyCitiesClientFX/fx/Home.fxml");
		//URL xmlUrl = getClass().getResource("/fx/Home.fxml");
		loader.setLocation(xmlUrl);
		
		try {
			
			// initialisation
			Parent root = loader.load();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setWidth(800);
			stage.setHeight(600);
			stage.setTitle("Visit My Cities : LPDAOO");
			stage.show();
			
			// on lie la fenetre avec le controleur
			ChoixVilleMapping controleur = loader.getController();
			controleur.setMainApp(this); //-> soucis
			//stage.show();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void stop() {
		this.applicationContext.close();
	}

	/*
	public static ConfigurableApplicationContext getApplicationContext() {
		return this.applicationContext;
	}
	*/	
}
