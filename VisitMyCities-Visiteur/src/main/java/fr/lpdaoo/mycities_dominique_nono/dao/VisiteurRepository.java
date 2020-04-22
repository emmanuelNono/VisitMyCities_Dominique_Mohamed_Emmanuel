package fr.lpdaoo.mycities_dominique_nono.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lpdaoo.mycities_dominique_nono.model.Visiteur;

public interface VisiteurRepository extends JpaRepository<Visiteur, Long> {
	
	public Visiteur findById(int id); // return Visiteur trouvé avec cet l'index

}
