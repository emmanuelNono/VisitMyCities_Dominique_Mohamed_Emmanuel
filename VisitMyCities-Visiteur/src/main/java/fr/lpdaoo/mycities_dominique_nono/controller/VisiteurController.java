package fr.lpdaoo.mycities_dominique_nono.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import fr.lpdaoo.mycities_dominique_nono.dao.VisiteurRepository;
import fr.lpdaoo.mycities_dominique_nono.exceptions.VisiteurIntrouvableException;
import fr.lpdaoo.mycities_dominique_nono.model.Ville;
import fr.lpdaoo.mycities_dominique_nono.model.Visiteur;

@Controller
@RequestMapping(path = "/visiteur")
public class VisiteurController {

	@Autowired
	VisiteurRepository visiteurRepository;

	@GetMapping(value = "/")
	public @ResponseBody Iterable<Visiteur> getAllVisiteurs() {
		return visiteurRepository.findAll();
	}

	@GetMapping(value = "/{visId}")
	public @ResponseBody Optional<Visiteur> getVisiteur(@PathVariable(name = "visId") Long visId)
			throws VisiteurIntrouvableException {

		Optional<Visiteur> v = visiteurRepository.findById(visId);

		if (!v.isPresent())
			throw new VisiteurIntrouvableException("Le visiteurs " + visId + " est introuvable");

		return v;
	}

	@PostMapping(value = "/")
	public @ResponseBody ResponseEntity<Void> addVisiteur(@RequestBody Visiteur visiteur) {

		visiteur.setVille(visiteur.getVille());
		Visiteur v = visiteurRepository.save(visiteur);

		if (visiteur == null || visiteur.getVille() == null) {
			return ResponseEntity.noContent().build();
		}

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(v.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping(value = "/{visId}")
	public @ResponseBody ResponseEntity<Void> UpdateVisiteur(@PathVariable Long visId, @RequestBody Visiteur visiteur) {

		visiteur.setVille(visiteur.getVille());
		visiteur.setId(visId);
		Visiteur v = visiteurRepository.save(visiteur);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().
				path("").buildAndExpand(v.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/{visId}")
	public ResponseEntity<Visiteur> deleteVisiteur(@PathVariable Long visId) {
		if (visiteurRepository.findAll().size() < visId) {
			return ResponseEntity.badRequest().build();
		}

		visiteurRepository.deleteById(visId);
		
		return ResponseEntity.ok().build();
	}

}