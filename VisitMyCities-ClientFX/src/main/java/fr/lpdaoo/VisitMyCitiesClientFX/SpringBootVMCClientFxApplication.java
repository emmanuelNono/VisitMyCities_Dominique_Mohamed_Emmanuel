package fr.lpdaoo.VisitMyCitiesClientFX;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javafx.application.Application;

@SpringBootApplication
@EnableFeignClients
public class SpringBootVMCClientFxApplication {

	public static void main(String[] args) {
		Application.launch(ClientFX.class, args);
	}
}