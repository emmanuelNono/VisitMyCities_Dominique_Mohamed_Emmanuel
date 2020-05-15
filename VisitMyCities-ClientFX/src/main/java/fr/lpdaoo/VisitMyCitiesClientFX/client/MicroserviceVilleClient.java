package fr.lpdaoo.VisitMyCitiesClientFX.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.lpdaoo.VisitMyCitiesClientFX.model.bean.VilleBean;


@FeignClient(name = "microservice-ville", url = "127.0.0.1:9092")
public interface MicroserviceVilleClient {
	@GetMapping(value = "/ville/all/")
	List<VilleBean> getListeVilles();
	
	@GetMapping(value = "/Ville/{id}")
	VilleBean afficherUneVille(@PathVariable("id") int id);
}
