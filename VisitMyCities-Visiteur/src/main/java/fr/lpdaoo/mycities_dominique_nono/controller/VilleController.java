package fr.lpdaoo.mycities_dominique_nono.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import fr.lpdaoo.mycities_dominique_nono.dao.VilleRepository;
import fr.lpdaoo.mycities_dominique_nono.exceptions.VilleIntrouvableException;
import fr.lpdaoo.mycities_dominique_nono.model.Ville;

@Controller
@RequestMapping(path = "/ville")
public class VilleController {

	@Autowired
	VilleRepository villeRepository;

	@GetMapping(value = "/all")
	public @ResponseBody Iterable<Ville> getAllVilles() {
		return villeRepository.findAll();
	}

	@GetMapping(value = "/all/{visId}")
	public @ResponseBody Optional<Ville> getVille(@PathVariable(name = "visId") Long vilId)
			throws VilleIntrouvableException {

		Optional<Ville> v = villeRepository.findById(vilId);

		if (!v.isPresent())
			throw new VilleIntrouvableException("Le villes " + vilId + " est introuvable");

		return v;
	}

	@PostMapping(value = "/list")
	public @ResponseBody ResponseEntity<Void> addVille(@RequestBody Ville ville) {

		Ville v = villeRepository.save(ville);

		if (ville == null) {
			return ResponseEntity.noContent().build();
		}

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(v.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping(value = "/list/{vilId}")
	public @ResponseBody ResponseEntity<Void> UpdateVille(@PathVariable Long vilId, @RequestBody Ville ville) {

		ville.setId(vilId);
		Ville v = villeRepository.save(ville);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("").buildAndExpand(v.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/{vilId}")
	public ResponseEntity<Ville> deleteVille(@PathVariable Long vilId) {
		if (villeRepository.findAll().size() < vilId) {
			return ResponseEntity.badRequest().build();
		}

		villeRepository.deleteById(vilId);
		
		return ResponseEntity.ok().build();
	}

}