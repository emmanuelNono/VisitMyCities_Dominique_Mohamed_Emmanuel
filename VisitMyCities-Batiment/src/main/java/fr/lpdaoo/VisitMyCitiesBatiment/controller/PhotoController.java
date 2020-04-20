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

import fr.lpdaoo.VisitMyCitiesBatiment.model.Photo;
import fr.lpdaoo.VisitMyCitiesBatiment.model.DAO.PhotoRepository;

@RestController
@RequestMapping(path="/photos")
public class PhotoController {
	@Autowired
	private PhotoRepository photoRepository;
	
	@GetMapping("/")
	public @ResponseBody Iterable<Photo> getAllPhotos(){
		return photoRepository.findAll();
	}
	
		
	@GetMapping("/{id}")
	public @ResponseBody Optional<Photo> getPhoto(@PathVariable Integer id) {
		return photoRepository.findById(id);
	}
	
	@PostMapping("/add")
	public @ResponseBody String addNewhoto(
			@RequestParam String titre, @RequestParam String source)
	{
		Photo p = new Photo();
		p.setTitre(titre);
		p.setSource(source);
		photoRepository.save(p);
		return "Saved";
	}
	
	@PutMapping("/{id}")
	public @ResponseBody String updatePhoto(
			@PathVariable Integer id, 
			@RequestParam String titre, @RequestParam String source)
	{
		Photo p = new Photo(id);
		p.setTitre(titre);
		p.setSource(source);
		photoRepository.save(p);
		return "Updated";
	}	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity <Photo> deletePhoto(@PathVariable int id) {
		if (photoRepository.findById(id).isEmpty())  {
			return ResponseEntity.badRequest().build();
		}
		photoRepository.deleteById(id);
		return ResponseEntity.ok().build();		
	} 
}
