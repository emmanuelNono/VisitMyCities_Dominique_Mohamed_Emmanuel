package fr.lpdaoo.visitmycitiesVille.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.lpdaoo.visitmycitiesVille.modele.Ville;

@Repository
public interface VilleDao extends JpaRepository<Ville, Integer>{
	
	Ville findById(int id);

	

}
