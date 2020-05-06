package com.clientui;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.clientui.fxview.MainAppFront;

/**
 * Notre projet application étant un projet Spring 
 * => on crée le lanceur SpringBoot
 * @author dominiquesauvignon
 *
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "com.clientui.proxies")
public class MySpringBootApplication{
	public static void main(String[] args) {
		// on lance l'application JavaFX
		Application.launch(MainAppFront.class, args);
	}

	
}