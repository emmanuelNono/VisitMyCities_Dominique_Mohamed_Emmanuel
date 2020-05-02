package fr.lpdaoo.mycities_dominique_nono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.lpdaoo.mycities_dominique_nono.dao.AVisiterRepository;
import fr.lpdaoo.mycities_dominique_nono.dao.VilleRepository;
import fr.lpdaoo.mycities_dominique_nono.dao.VisiteurRepository;
import fr.lpdaoo.mycities_dominique_nono.model.AVisiter;
import fr.lpdaoo.mycities_dominique_nono.model.Ville;
import fr.lpdaoo.mycities_dominique_nono.model.Visiteur;

@SpringBootApplication
public class MycitiesDominiqueNonoApplication implements CommandLineRunner {
	
	@Autowired private VisiteurRepository visiteurDAO;
	@Autowired private VilleRepository villeDAO;
	@Autowired private AVisiterRepository aVisiterRepository;

	public static void main(String[] args) {
		SpringApplication.run(MycitiesDominiqueNonoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Création de Ville
		Ville ville1 = villeDAO.save(new Ville(null, "Strasbourg", 67000));
		Ville ville2 = villeDAO.save(new Ville(null, "Mulhouse", 68000));
		Ville ville3 = villeDAO.save(new Ville(null, "Colmar", 68500));

		//Création de Visiteur
		Visiteur visiteur1 = visiteurDAO.save(new Visiteur(null, "nomVisiteur1", "prenomVisiteur1", "Adr 1", (int)(Math.random()*5),  "CP 1", "email 1", "mdp 1", ville1));
		Visiteur visiteur2 = visiteurDAO.save(new Visiteur(null, "nomVisiteur2", "prenomVisiteur2", "Adr 2", (int)(Math.random()*5),  "CP 2", "email 2", "mdp 2", ville2));
		Visiteur visiteur3 = visiteurDAO.save(new Visiteur(null, "nomVisiteur3", "prenomVisiteur3", "Adr 3", (int)(Math.random()*5),  "CP 3", "email 3", "mdp 3", ville3));
		Visiteur visiteur4 = visiteurDAO.save(new Visiteur(null, "nomVisiteur4", "prenomVisiteur4", "Adr 4", (int)(Math.random()*5),  "CP 4", "email 4", "mdp 4", ville2));
				
		//Création de AVisiter
		AVisiter aVisiter1 = aVisiterRepository.save(new AVisiter(null, 1, visiteur1));
		AVisiter aVisiter2 = aVisiterRepository.save(new AVisiter(null, 2, visiteur4));
		AVisiter aVisiter3 = aVisiterRepository.save(new AVisiter(null, 3, visiteur4));
		
		visiteurDAO.findAll().forEach(h -> {
			System.out.println("nom " + h.getVisNom() + " prenom " + h.getVisPrenom() + " adresse " + h.getVisAdresse()
					+ " ville " + h.getVisEmail() + " ville " + h.getVille().getVilNom());
		});

	}

}
