package fr.lpdaoo.VisitMyCitiesBatiment.model.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.lpdaoo.VisitMyCitiesBatiment.model.Batiment;

public interface BatimentRepository extends JpaRepository<Batiment, Integer>{

}