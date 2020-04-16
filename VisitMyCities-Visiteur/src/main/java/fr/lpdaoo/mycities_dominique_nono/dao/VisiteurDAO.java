package fr.lpdaoo.mycities_dominique_nono.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lpdaoo.mycities_dominique_nono.model.Visiteur;

public interface VisiteurDAO extends JpaRepository<Visiteur, Long> {

}
