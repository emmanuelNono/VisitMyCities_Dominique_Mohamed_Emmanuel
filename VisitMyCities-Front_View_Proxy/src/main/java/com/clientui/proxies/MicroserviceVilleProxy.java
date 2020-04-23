package com.clientui.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.clientui.beans.VilleBean;

	
	public class MicroserviceVilleProxy {
		@FeignClient(name = "microservice-ville", url = "localhost:9001")
		public interface MicroserviceProduitsProxy {

		
		@GetMapping(value = "/Villes")
		public List<VilleBean> listVilles();
		
		@GetMapping(value = "/Ville/{id}")
		VilleBean afficherUneVille(@PathVariable("id") int id);
		
		
		}

		

		
	}



