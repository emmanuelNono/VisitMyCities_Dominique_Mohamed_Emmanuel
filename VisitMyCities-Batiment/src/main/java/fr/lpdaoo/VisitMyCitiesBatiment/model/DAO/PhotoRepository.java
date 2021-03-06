package fr.lpdaoo.VisitMyCitiesBatiment.model.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lpdaoo.VisitMyCitiesBatiment.model.Batiment;
import fr.lpdaoo.VisitMyCitiesBatiment.model.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Integer>{
	Iterable<Photo> findByBatiment(Batiment b);
}