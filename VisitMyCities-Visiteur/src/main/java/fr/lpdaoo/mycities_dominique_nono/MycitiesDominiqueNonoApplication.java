package fr.lpdaoo.mycities_dominique_nono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.lpdaoo.mycities_dominique_nono.dao.VilleRepository;
import fr.lpdaoo.mycities_dominique_nono.dao.VisiteurRepository;
import fr.lpdaoo.mycities_dominique_nono.model.Ville;
import fr.lpdaoo.mycities_dominique_nono.model.Visiteur;

@SpringBootApplication
public class MycitiesDominiqueNonoApplication implements CommandLineRunner {
	
	@Autowired private VisiteurRepository visiteurDAO;
	@Autowired private VilleRepository villeDAO;

	public static void main(String[] args) {
		SpringApplication.run(MycitiesDominiqueNonoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Ville v1 = villeDAO.save(new Ville(null, "Strasbourg", 67000));
		Ville v2 = villeDAO.save(new Ville(null, "Mulhouse", 68000));
		Ville v3 = villeDAO.save(new Ville(null, "Colmar", 68500));

		
		for (int i = 1; i < 5; i++) {
			// String name = f.harryPotter().character();
			Visiteur h = new Visiteur();

			h.setVisNom("NomsVisiteur " + i);
			h.setVisPrenom("PrenomsVisiteur " + i);
			h.setVisCp((int) (Math.random() * 5));
			h.setVisAdresse("Adr " + i);
			h.setVisVille("Code Postale " + i);
			h.setVisEmail("Mail " + i);
			h.setVisMdp("password " + i);
			h.setVille(v3);
			
			visiteurDAO.save(h);
		}

		visiteurDAO.findAll().forEach(h -> {
			System.out.println("nom " + h.getVisNom() + " prenom " + h.getVisPrenom() + " adresse " + h.getVisAdresse()
					+ " ville " + h.getVisEmail() + " ville " + h.getVille().getVilNom());
		});

	}

}
