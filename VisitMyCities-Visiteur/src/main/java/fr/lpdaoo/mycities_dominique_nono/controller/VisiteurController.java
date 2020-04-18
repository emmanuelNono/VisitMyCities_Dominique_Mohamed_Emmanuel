package fr.lpdaoo.mycities_dominique_nono.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.lpdaoo.mycities_dominique_nono.dao.VisiteurRepository;
import fr.lpdaoo.mycities_dominique_nono.model.Visiteur;

@Controller
@RequestMapping(path = "/visiteur")
public class VisiteurController {

	@Autowired
	VisiteurRepository visiteurRepository;

	@GetMapping(value = "/all")
	public @ResponseBody Iterable<Visiteur> getAllVisiteurs() {
		return visiteurRepository.findAll();
	}


}