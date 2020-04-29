package com.clientui;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.clientui.fxview.MainAppFront;

/**
 * Notre projet application étant un projet Spring 
 * => on crée le lanceur SpringBoot
 * @author dominiquesauvignon
 *
 */
@SpringBootApplication
public class MySpringBootApplication {
	public static void main(String[] args) {
		// on lance l'application JavaFX
		System.out.println("lancement de notre SpringBootApplication");
		Application.launch(MainAppFront.class, args);
	}
}