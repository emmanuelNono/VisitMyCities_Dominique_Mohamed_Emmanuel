package fr.lpdaoo.VisitMyCitiesBatiment.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.lpdaoo.VisitMyCitiesBatiment.model.Batiment;
import fr.lpdaoo.VisitMyCitiesBatiment.model.DAO.*;

@RestController
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
		b.setNom(bat_nom);
		b.setAdresse(bat_adresse);
		b.setCoord_gps_ns(bat_coord_gps_ns);
		b.setCoord_gps_oe(bat_coord_gps_oe);
		b.setAnnee_construction(bat_annee_construction);
		b.setCouleur(bat_couleur);
		b.setDescription(bat_description);
		b.setArchitecte(bat_architecte);
		b.setVille(bat_ville);
		batimentRepository.save(b);
		return "Saved";
	}
	
	@PutMapping("/{id}")
	public @ResponseBody String updateBatiment(
			@PathVariable Integer id, 
			@RequestParam String bat_nom, @RequestParam String bat_adresse, 
			@RequestParam String bat_coord_gps_ns, 
			@RequestParam String bat_coord_gps_oe, @RequestParam Integer bat_annee_construction, 
			@RequestParam String bat_couleur, 
			@RequestParam String bat_description, @RequestParam String bat_architecte, 
			@RequestParam Integer bat_ville)
	{
		Batiment b = new Batiment(id);
		b.setNom(bat_nom);
		b.setAdresse(bat_adresse);
		b.setCoord_gps_ns(bat_coord_gps_ns);
		b.setCoord_gps_oe(bat_coord_gps_oe);
		b.setAnnee_construction(bat_annee_construction);
		b.setCouleur(bat_couleur);
		b.setDescription(bat_description);
		b.setArchitecte(bat_architecte);
		b.setVille(bat_ville);
		batimentRepository.save(b);
		return "Updated";
	}	
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity <Batiment> deleteBatiment(@PathVariable int id) {
		if (batimentRepository.findById(id).isEmpty())  {
			return ResponseEntity.badRequest().build();
		}
		batimentRepository.deleteById(id);
		return ResponseEntity.ok().build();		
	} 
}