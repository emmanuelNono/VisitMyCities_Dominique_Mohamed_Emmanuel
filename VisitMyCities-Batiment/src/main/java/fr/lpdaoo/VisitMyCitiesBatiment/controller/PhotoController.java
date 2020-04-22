package fr.lpdaoo.VisitMyCitiesBatiment.controller;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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
import fr.lpdaoo.VisitMyCitiesBatiment.model.Photo;
import fr.lpdaoo.VisitMyCitiesBatiment.model.DAO.PhotoRepository;

@RestController
@RequestMapping(path="/photos")
public class PhotoController {
	@Autowired
	private PhotoRepository photoRepository;
	private EntityManager em;
	
	/**
	 * affichage de toutes les photos
	 * @return toutes les photos sous forme d'un json
	 */
	@GetMapping("/")
	public @ResponseBody Iterable<Photo> getAllPhotos(){
		return photoRepository.findAll();
	}
	
	/** 
	 * affichage d'une photo		
	 * @param id
	 * @return les infos de la photo dont l'id est passée en paramètres
	 */
	@GetMapping("/{id}")
	public @ResponseBody Optional<Photo> getPhoto(@PathVariable Integer id) {
		return photoRepository.findById(id);
	}
	
	/** 
	 * affichage des photos correspondant à un batiment
	 * 
	 */
	@GetMapping("/batiment/{bat_id}")
	public @ResponseBody Iterable<Photo> getPhotosBatiment(@PathVariable Integer bat_id){
		Batiment b = new Batiment(bat_id);
		return photoRepository.findByBatiment(b);
	}
	
	
	/** 
	 * ajout d'une photo 
	 * @param titre
	 * @param source
	 * @return un message qui indique que la photo a bien été ajoutée
	 */
	@PostMapping("/")
	public @ResponseBody String addNewhoto(
			@RequestParam String titre, @RequestParam String source,
			@RequestParam Integer bat_id)
	{
		Photo p = new Photo();
		p.setTitre(titre);
		p.setSource(source);
		Batiment b = new Batiment(bat_id);
		p.setBatiment(b);		
		photoRepository.save(p);
		return "Added";
	}
	
	@PutMapping("/{id}")
	public @ResponseBody String updatePhoto(
			@PathVariable Integer id, 
			@RequestParam String titre, @RequestParam String source,
			@RequestParam Integer bat_id)
	{
		Photo p = new Photo(id);
		p.setTitre(titre);
		p.setSource(source);
		Batiment b = new Batiment(bat_id);
		p.setBatiment(b);
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
