package fr.lpdaoo.VisitMyCitiesClientFX.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.lpdaoo.VisitMyCitiesClientFX.model.bean.VilleBean;

@Component
@FeignClient(name = "microservice-ville", url = "127.0.0.1:9092")
public interface MicroserviceVilleClient {
	@GetMapping(value = "/ville/all/")
	VilleBean[] getListeVilles();
	
	@GetMapping(value = "/Ville/{id}")
	VilleBean afficherUneVille(@PathVariable("id") int id);
}
