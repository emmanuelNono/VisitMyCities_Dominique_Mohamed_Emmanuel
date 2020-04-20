package fr.lpdaoo.VisitMyCitiesBatiment.model.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.lpdaoo.VisitMyCitiesBatiment.model.Batiment;

public interface BatimentRepository extends JpaRepository<Batiment, Integer>{
}