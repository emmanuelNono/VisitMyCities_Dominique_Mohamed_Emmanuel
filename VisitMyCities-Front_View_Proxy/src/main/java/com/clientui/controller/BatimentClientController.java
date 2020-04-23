package com.clientui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clientui.beans.BatimentBean;
import com.clientui.proxies.MicroserviceBatimentsProxy;

@Controller
public class BatimentClientController {
	
	@Autowired
	private MicroserviceBatimentsProxy BatimentProxy;
	 
	@RequestMapping("/")
	 public String accueil(Model model){
		
		List<BatimentBean> batiment = BatimentProxy.getAllBatiments();
		
			model.addAttribute("batiment", batiment);
			
		for(BatimentBean b: batiment) {
			
			System.out.println(" Nom de bâtiment " + b.getNom());
			
			}
			
	        return "Bâtiment";
	    }
}
