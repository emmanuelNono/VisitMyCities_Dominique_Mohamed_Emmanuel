

package com.clientui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clientui.beans.ProductBean;
import com.clientui.beans.VilleBean;
import com.clientui.proxies.MicroserviceProduitsProxy;
import com.clientui.proxies.MicroserviceVilleProxy;



@Controller
public class VilleClientController {

	
	@Autowired
	private MicroserviceVilleProxy VilleProxy;
	 
	@GetMapping(value = "/Villes")
	 public String accueil(Model model){
		
		List<VilleBean> villes = VilleProxy.listVilles();
		
		for(VilleBean v: villes) {
			
			System.out.println(" Prix produit " + v.getVilNom());
			
			}
			
		
		
			model.addAttribute("produits", villes);
			
		
	        return "Ville";
	    }
}
