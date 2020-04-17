package fr.lpdaoo.visitmycitiesVille.controller;


import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import fr.lpdaoo.visitmycitiesVille.dao.VilleDao;
import fr.lpdaoo.visitmycitiesVille.modele.Ville;

@RestController
public class VilleController {
	
	
	@Autowired
	private VilleDao villeDao;
	
	@GetMapping(value = "/Villes")
	public List<Ville> listVilles() {
		
		return villeDao.findAll();
	}
	
	@GetMapping(value = "/Ville/{id}")
	public Ville afficherUneVille(@PathVariable int id) {
		
		Ville ville = new Ville(1, "Strasbourg", 67000);
		//return villeDao.findById(id);
		
		return ville;
		
	}
	
	@PostMapping(value = "/Villes")
	public ResponseEntity<Void> ajouterVille(@RequestBody Ville ville) {
		
		Ville ville1 = villeDao.save(ville);
		if(ville == null) {
			
			return ResponseEntity.noContent().build();
		}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ville1.getIdVille()).toUri();
		return ResponseEntity.created(location).build();
	}

}
