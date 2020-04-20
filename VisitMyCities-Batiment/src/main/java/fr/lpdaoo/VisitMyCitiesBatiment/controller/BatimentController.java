package fr.lpdaoo.VisitMyCitiesBatiment.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.lpdaoo.VisitMyCitiesBatiment.model.Batiment;
import fr.lpdaoo.VisitMyCitiesBatiment.model.DAO.BatimentRepository;



@RestController
@RequestMapping(path="/batiments")
public class BatimentController {

	@Autowired
	private BatimentRepository batimentRepository;
	
	@GetMapping("/all")
	public @ResponseBody Iterable<Batiment> getAllBatiments(){
		return batimentRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Optional<Batiment> getBatiment(@PathVariable Integer id) {
		return batimentRepository.findById(id);
	}
	
	/*
	@GetMapping("/ville/{id}")
	public @ResponseBody Optional<Batiment> getBatimentVille(@PathVariable Integer id) {
		return batimentRepository.findByVille(id);
	}
	*/
	
	@PostMapping("/add")
	public @ResponseBody String addNewBatiment(
			@RequestParam String nom, @RequestParam String adresse, 
			@RequestParam String coord_gps_ns, 
			@RequestParam String coord_gps_oe, @RequestParam Integer annee_construction, 
			@RequestParam String couleur, 
			@RequestParam String description, @RequestParam String architecte, 
			@RequestParam Integer ville
			)
	{
		Batiment b = new Batiment();
		b.setNom(nom);
		b.setAdresse(adresse);
		b.setCoord_gps_ns(coord_gps_ns);
		b.setCoord_gps_oe(coord_gps_oe);
		b.setAnnee_construction(annee_construction);
		b.setCouleur(couleur);
		b.setDescription(description);
		b.setArchitecte(architecte);
		b.setVille(ville);
		batimentRepository.save(b);
		return "Saved";
	}
	
	@PutMapping("/{id}")
	public @ResponseBody String updateBatiment(
			@PathVariable Integer id, 
			@RequestParam String nom, @RequestParam String adresse, 
			@RequestParam String coord_gps_ns, 
			@RequestParam String coord_gps_oe, @RequestParam Integer annee_construction, 
			@RequestParam String couleur, 
			@RequestParam String description, @RequestParam String architecte, 
			@RequestParam Integer ville)
	{
		Batiment b = new Batiment(id);
		b.setNom(nom);
		b.setAdresse(adresse);
		b.setCoord_gps_ns(coord_gps_ns);
		b.setCoord_gps_oe(coord_gps_oe);
		b.setAnnee_construction(annee_construction);
		b.setCouleur(couleur);
		b.setDescription(description);
		b.setArchitecte(architecte);
		b.setVille(ville);
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