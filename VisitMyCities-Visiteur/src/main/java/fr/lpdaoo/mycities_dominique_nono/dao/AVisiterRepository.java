package fr.lpdaoo.mycities_dominique_nono.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.lpdaoo.mycities_dominique_nono.model.AVisiter;

public interface AVisiterRepository extends JpaRepository<AVisiter, Long> {
	
	public AVisiter findById(int id); // return aVisiter trouvé avec cet l'index

}
