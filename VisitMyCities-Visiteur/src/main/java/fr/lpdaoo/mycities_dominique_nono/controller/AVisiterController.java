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

import fr.lpdaoo.mycities_dominique_nono.dao.AVisiterRepository;
import fr.lpdaoo.mycities_dominique_nono.exceptions.AVisiterIntrouvableException;
import fr.lpdaoo.mycities_dominique_nono.model.AVisiter;

@Controller
@RequestMapping(path = "/avisiter")
public class AVisiterController {

	@Autowired
	AVisiterRepository aVisiterRepository;

	@GetMapping(value = "/")
	public @ResponseBody Iterable<AVisiter> getAllAVisiter() {
		return aVisiterRepository.findAll();
	}

	@GetMapping(value = "/{aVisId}")
	public @ResponseBody Optional<AVisiter> getAVisiter(@PathVariable(name = "aVisId") Long aVisId)
			throws AVisiterIntrouvableException {

		Optional<AVisiter> v = aVisiterRepository.findById(aVisId);

		if (!v.isPresent())
			throw new AVisiterIntrouvableException("La ligne a visiter numéro " + aVisId + " est introuvable");

		return v;
	}

	@PostMapping(value = "/")
	public @ResponseBody ResponseEntity<Void> addAVisiter(@RequestBody AVisiter aVisiter) {

		AVisiter v = aVisiterRepository.save(aVisiter);

		if (aVisiter == null) {
			return ResponseEntity.noContent().build();
		}

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(v.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping(value = "/{aVisId}")
	public @ResponseBody ResponseEntity<Void> UpdateAVisiter(@PathVariable Long aVisId, @RequestBody AVisiter aVisiter) {

		aVisiter.setId(aVisId);
		AVisiter v = aVisiterRepository.save(aVisiter);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("").buildAndExpand(v.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/{aVisId}")
	public ResponseEntity<AVisiter> deleteAVisiter(@PathVariable Long aVisId) {
		if (aVisiterRepository.findAll().size() < aVisId) {
			return ResponseEntity.badRequest().build();
		}

		aVisiterRepository.deleteById(aVisId);
		
		return ResponseEntity.ok().build();
	}

}