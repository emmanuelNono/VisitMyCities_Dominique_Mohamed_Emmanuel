package fr.lpdaoo.mycities_dominique_nono.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lpdaoo.mycities_dominique_nono.model.Ville;

public interface VilleRepository extends JpaRepository<Ville, Long> {

}
