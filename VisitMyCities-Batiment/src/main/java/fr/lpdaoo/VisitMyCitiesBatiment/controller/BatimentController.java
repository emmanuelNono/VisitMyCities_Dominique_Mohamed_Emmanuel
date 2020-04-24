package fr.lpdaoo.VisitMyCitiesBatiment.controller;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import fr.lpdaoo.VisitMyCitiesBatiment.exceptions.BatimentIntrouvableException;
import fr.lpdaoo.VisitMyCitiesBatiment.model.Batiment;
import fr.lpdaoo.VisitMyCitiesBatiment.model.DAO.BatimentRepository;


@RestController
@RequestMapping(path="/batiments")
public class BatimentController {

	@Autowired
	BatimentRepository batimentRepository;
	
	/** 
	 * 
	 * @return tous les bâtiments
	 */
	@GetMapping("/")
	public @ResponseBody Iterable<Batiment> getAllBatiments(){
		return batimentRepository.findAll();
	}
	
	/**
	 * @param id
	 * @return le batiment dont l'id a été passé
	 */
	
	@GetMapping("/{id}")
	public Optional<Batiment> getBatiment(@PathVariable Integer id) throws BatimentIntrouvableException  {
		Optional<Batiment> b = batimentRepository.findById(id);
		if (b.isPresent()) {
			return b;
		}
		else {
			throw new BatimentIntrouvableException("Le batiment avec l'id " + id + " n'existe pas.");
		}
	}
	
	/*
	@GetMapping("/ville/{id}")
	public @ResponseBody Optional<Batiment> getBatimentVille(@PathVariable Integer id) {
		return batimentRepository.findByVille(id);
	}
	*/
	
	/**
	 * creation d'un bâtiment
	 * @param nom
	 * @param adresse
	 * @param coord_gps_ns
	 * @param coord_gps_oe
	 * @param annee_construction
	 * @param couleur
	 * @param description
	 * @param architecte
	 * @param ville
	 * @return une chaîne indiquand que le bâtiment a bien été crée
	 */
	@PostMapping("/")
	public @ResponseBody ResponseEntity<Object> addNewBatiment(
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
		
		return ResponseEntity.ok().build();
	}
	
	/**
	 * modification d'un bâtiment
	 * @param id
	 * @param nom
	 * @param adresse
	 * @param coord_gps_ns
	 * @param coord_gps_oe
	 * @param annee_construction
	 * @param couleur
	 * @param description
	 * @param architecte
	 * @param ville
	 * @return un message qui indique que la bâtiment a bien été mise à jour
	 */
	@PutMapping("/{id}")
	public @ResponseBody ResponseEntity<Object> updateBatiment(
			@PathVariable Integer id, 
			@RequestParam String nom, @RequestParam String adresse, 
			@RequestParam String coord_gps_ns, 
			@RequestParam String coord_gps_oe, @RequestParam Integer annee_construction, 
			@RequestParam String couleur, 
			@RequestParam String description, @RequestParam String architecte, 
			@RequestParam Integer ville)
	{
		// verif du batiment
		if (batimentRepository.findById(id).isPresent()) {
			// on va chercher la batiment
			Batiment b = batimentRepository.findById(id).get();
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
			
			URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("").buildAndExpand(b.getId()).toUri();
			
			return ResponseEntity.ok().build();
		}
		else
		{
			throw new BatimentIntrouvableException("Le batiment avec l'id " + id + " n'existe pas.");
		}	
	}
	
	
	/**
	 * suppression de bâtiment
	 * @param id
	 * @return un mmessage indiquant que le bâtiment a bien été supprimé
	 */
	/*
	@DeleteMapping("/{id}")
	public ResponseEntity <Batiment> deleteBatiment(@PathVariable int id) {
		if (batimentRepository.findById(id).isPresent())  {
			System.out.println("present");
			batimentRepository.deleteById(id);
			return ResponseEntity.ok().build();		
		}
		else {
			return ResponseEntity.badRequest().build();
		}
	}
	*/
}