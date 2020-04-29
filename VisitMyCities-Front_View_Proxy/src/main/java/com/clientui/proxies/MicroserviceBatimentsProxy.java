//package com.clientui.proxies;
//
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import com.clientui.beans.BatimentBean;
//
//
//
//	@FeignClient(name = "microservice-batiment", url = "localhost:9090")
//	public interface MicroserviceBatimentsProxy {
//
//		@GetMapping("/batiments/")
//		Iterable<BatimentBean> getAllBatiments();
//		
//		@GetMapping("/{bat_id}")
//		BatimentBean getBatiment(@PathVariable("bat_id") int bat_id);
//		
//	}
//
//	
