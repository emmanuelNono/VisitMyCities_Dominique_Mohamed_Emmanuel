package fr.lpdaoo.VisitMyCitiesClientFX;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javafx.application.Application;

@SpringBootApplication
public class SpringBootVMCClientFxApplication {

	public static void main(String[] args) {
		Application.launch(ClientFX.class, args);
	}

}
