package fr.lpdaoo.VisitMyCitiesClientFX;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.lpdaoo.VisitMyCitiesClientFX.client.MicroserviceVilleClient;
import fr.lpdaoo.VisitMyCitiesClientFX.model.bean.VilleBean;

@Controller
public class MonControleurLecteur {
	@Autowired
	private MicroserviceVilleClient msaVille;
	
	@GetMapping("/")
	public String accueil(Model model) {
		VilleBean[] listeVilles = msaVille.getListeVilles();
		System.out.println("taille " + listeVilles.length);
		
		for (VilleBean v : listeVilles ) {
			System.out.println(v.getVilCp() + " - " + v.getVilNom());
		}
		return "Accueil";
		
		
	}
}
