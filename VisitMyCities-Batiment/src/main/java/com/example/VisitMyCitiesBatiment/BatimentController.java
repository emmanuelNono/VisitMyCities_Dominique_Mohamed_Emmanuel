package com.example.VisitMyCitiesBatiment;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/batiments")
public class BatimentController {

	@Autowired
	private BatimentRepository batimentRepository;
	
	@GetMapping("/all")
	public @ResponseBody Iterable<Batiment> getAllBatiments(){
		return batimentRepository.findAll();
	}
	
	@GetMapping("/{bat_id}")
	public @ResponseBody Optional<Batiment> getBatiment(@PathVariable Integer bat_id) {
		return batimentRepository.findById(bat_id);
	}
	
	@PostMapping("/add")
	public @ResponseBody String addNewBatiment(
			@RequestParam String bat_nom, @RequestParam String bat_adresse, 
			@RequestParam String bat_coord_gps_ns, 
			@RequestParam String bat_coord_gps_oe, @RequestParam Integer bat_annee_construction, 
			@RequestParam String bat_couleur, 
			@RequestParam String bat_description, @RequestParam String bat_architecte, 
			@RequestParam Integer bat_ville
			)
	{
		Batiment b = new Batiment();
		b.setBat_nom(bat_nom);
		b.setBat_adresse(bat_adresse);
		b.setBat_coord_gps_ns(bat_coord_gps_ns);
		b.setBat_coord_gps_oe(bat_coord_gps_oe);
		b.setBat_annee_construction(bat_annee_construction);
		b.setBat_couleur(bat_couleur);
		b.setBat_description(bat_description);
		b.setBat_architecte(bat_architecte);
		b.setBat_ville(bat_ville);
		batimentRepository.save(b);
		return "Saved";
	}
	
}
