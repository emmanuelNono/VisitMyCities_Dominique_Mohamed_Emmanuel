package fr.lpdaoo.VisitMyCitiesClientFX.fx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import fr.lpdaoo.VisitMyCitiesClientFX.ClientFX;
import fr.lpdaoo.VisitMyCitiesClientFX.client.MicroserviceVilleClient;
import fr.lpdaoo.VisitMyCitiesClientFX.model.bean.VilleBean;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;


@Component
@FxmlView("Home.fxml")
public class ChoixVilleMapping {
	private ClientFX main;
	
	// on procèdre aux associations
	// référence à notre champ combo qui aura la liste des ville de notre MSA
	@FXML
	private ComboBox<String> comboBoxVille; // pour test en dur
	//private ComboBox<VilleBean> comboBoxVille; // pour msa
	
	@FXML
	private Text texte;
	
	// le lien avec le msa
	//@Autowired
	//private MicroserviceVilleClient mvc;
	
	private static final Logger log = LoggerFactory.getLogger(ChoixVilleMapping.class);
	
	// pour ligne de commande
	VilleBean[] villesb;
	
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	// initialisation avec nos données métiers
	@FXML
	private void initialize() {
		// on affecte villes au champ Combo
		// test en dur
		ObservableList<String> listVille  = FXCollections.observableArrayList("Berlin", "Londres", "Bruxelles",
				"Madrid", "Paris", "Malin",
				"Amsterdam", "Lisbonne", "Bâle");
		comboBoxVille.setItems(listVille);
		
		//ville_api = mvc.getListeVilles();
		
	}	
	
	// en parsant le json
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		
		//ville_api = mvc.getListeVilles();
		return args -> {
			villesb = restTemplate.
					getForObject("http://127.0.0.1:9092/ville/all", VilleBean[].class);
			//System.out.println("villes: \n"+ villes.toString());
			System.out.println("villes : ");
			for (VilleBean v : villesb) {
				System.out.println(v.getVilNom());
			}
			//ObservableList<String> o_ville = FXCollections.observableArrayList(villesb.toString()); 
			//comboBoxVille.setItems(o_ville);
			
			//ville_api = mvc.getListeVilles();
			
			
		};
	}
	
	/**
	 * utilisée dans l'initialisation de l'ihm
	 * @param mainApp
	 */
	
	public void setMainApp(ClientFX mainApp) {
		this.main = mainApp;
	}
	
	public void start() {
		System.out.println("dans start");
	}
}