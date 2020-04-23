

package com.clientui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clientui.beans.ProductBean;
import com.clientui.beans.VilleBean;
import com.clientui.proxies.MicroserviceProduitsProxy;
import com.clientui.proxies.MicroserviceVilleProxy;



@Controller
public class VilleClientController {

	
	@Autowired
	private MicroserviceVilleProxy VilleProxy;
	 
	@RequestMapping("/")
	 public String accueil(Model model){
		
		List<VilleBean> villes = VilleProxy.listVilles();
		
			model.addAttribute("produits", villes);
			
		for(VilleBean v: villes) {
			
			System.out.println(" Prix produit " + v.getNomVille());
			
			}
			
	        return "Ville";
	    }
}
