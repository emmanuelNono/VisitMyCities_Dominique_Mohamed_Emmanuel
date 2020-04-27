package com.clientui.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.clientui.beans.VilleBean;

import javafx.collections.ObservableList;
	
@FeignClient(name = "vmc-ville", url = "127.0.0.1:9091")
public interface MicroserviceVilleProxy {
	@GetMapping(value = "/ville/all")
	ObservableList<VilleBean> getListeVilles();
	
	@GetMapping(value = "/Ville/{id}")
	VilleBean afficherUneVille(@PathVariable("id") int id);	
}