package fr.lpdaoo.VisitMyCitiesBatiment.controller;

import java.util.Optional;

import javax.persistence.EntityManager;

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

import fr.lpdaoo.VisitMyCitiesBatiment.exceptions.BatimentIntrouvableException;
import fr.lpdaoo.VisitMyCitiesBatiment.exceptions.PhotoIntrouvableException;
import fr.lpdaoo.VisitMyCitiesBatiment.model.Batiment;
import fr.lpdaoo.VisitMyCitiesBatiment.model.Photo;
import fr.lpdaoo.VisitMyCitiesBatiment.model.DAO.BatimentRepository;
import fr.lpdaoo.VisitMyCitiesBatiment.model.DAO.PhotoRepository;

@RestController
@RequestMapping(path="/photos")
public class PhotoController {
	@Autowired
	private PhotoRepository photoRepository;
	private EntityManager em;
	private BatimentRepository batimentRepository;
	
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
	 * @throws PhotoIntrouvableException 
	 */
	@GetMapping("/{id}")
	public @ResponseBody Optional<Photo> getPhoto(@PathVariable Integer id) throws PhotoIntrouvableException {
		if (photoRepository.findById(id).isPresent()){
			return photoRepository.findById(id);
		}
		else {
			throw new PhotoIntrouvableException("La photo avec l'id " + id + " n'existe pas.");
		}
	}
	
	/** 
	 * affichage des photos correspondant à un batiment
	 * 
	 */
	@GetMapping("/batiment/{bat_id}")
	public @ResponseBody Iterable<Photo> getPhotosBatiment(@PathVariable Integer bat_id){
		
		
		//Batiment b = new Batiment(bat_id);
		Batiment b = batimentRepository.findById(bat_id).get();
		System.out.println(b.toString());
		return photoRepository.findByBatiment(b);
		
		
		
		//	if (batimentRepository.findById(bat_id).isPresent()) {
	//		System.out.println("present");
	//		Batiment b = batimentRepository.findById(bat_id).get();
	//		return photoRepository.findByBatiment(b);
	//	}
	//	else {
	//		throw new BatimentIntrouvableException("Le batiment avec l'id " + bat_id + " n'existe pas.");
	//	}
	}
	
	
	/** 
	 * ajout d'une photo 
	 * @param titre
	 * @param source
	 * @param bat_id : l'id du batiment dont c'est la photo
	 * @return un message qui indique que la photo a bien été ajoutée
	 */
	/*
	@PostMapping("/")
	public @ResponseBody ResponseEntity<Object> addNewhoto (
			@RequestParam String titre, @RequestParam String source,
			@RequestParam Integer bat_id) throws BatimentIntrouvableException
	{
		Photo p = new Photo();
		p.setTitre(titre);
		p.setSource(source);
		
		//Batiment b = new Batiment(bat_id);
		// verif du batiment
		if (!batimentRepository.findById(bat_id).isPresent()) {
			throw new BatimentIntrouvableException("Le batiment avec l'id " + bat_id + " n'existe pas.");
		}
		else {
			Batiment b = batimentRepository.findById(bat_id).get();
			p.setBatiment(b);
			photoRepository.save(p);
			return ResponseEntity.ok().build();
		}
	*/
	
	
	/*
	@PutMapping("/{id}")
	public @ResponseBody ResponseEntity<Object> updatePhoto(
			@PathVariable Integer id, 
			@RequestParam String titre, @RequestParam String source,
			@RequestParam Integer bat_id)
	{
		
		//Photo p = new Photo(id);
		Photo p = photoRepository.findById(id).get();
		p.setTitre(titre);
		p.setSource(source);
		Batiment b = batimentRepository.findById(bat_id).get();
		//Batiment b = new Batiment(bat_id);
		p.setBatiment(b);
		photoRepository.save(p);
		
		return ResponseEntity.ok().build();
	}	
	*/
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity <Photo> deletePhoto(@RequestParam int id) {
		if (photoRepository.findById(id).isPresent())  {
			photoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.badRequest().build();
		}		
	} 
}
