# Visit My Cities

## par Dominique SAUVIGNON, Emmanuel NONO et Mohammed BENKHALID

### Principe : plusieurs microservices qui font ensemble un projet global

- VisitMyCities-Batiment : Microservice qui génère une API RESTFUL pour la gestion des Bâtiments (port 9090)



### Pour démarrer :

1. cloner le repository github
2. sous MySQL
   1. créer la base de données : VisitMyCities
   2. créer l'utilisateur et lui donner les droits sur la base crée : 
      - username : VisitMyCities
      - password : vmc_67-68
3. import chaque projet du repository
4. démarrer chaque projet en faisant une configuration de run avec :
   1. le projet en répertoire de base
   2. en goals : la commande suivante : clean install spring-boot:run


---------------------------------------------  API BATIMENT  -----------------------------------------------------------------

### Url des API BATIMENT:

- Microservice Batiment (fournir les informations des bâtiments et de leur photos) : port 9090
	- /buildings
		- (GET)	=> retourne tous les batiments
		- /{id} (GET) => retourne les informations correspondant au batiment avec l'id données dans l'url
		- / (POST) ->ajoute le batîment avec les données fournies en paramètres
		- /{id} (PUT) -> modifie le bâtiment
		  - dont l'url est passée dans l'url
		  - avec les données passées en paramètres
		- / (DELETE) -> supprime le bâtiment dont l'id est donnée dans l'url

	- /pictures

	  - / (GET) => retourne toutes les photos
	  - /{id} (GET) => retourne les informations de la photo
	  - / (POST) => ajout la photo avec les infos passées en paramètres
	  - /{id}  (PUT) => modifie les informations de la photo dont l'id est passée dans l'url
	  - /{id} (DELETE) => supprimer la photo dont l'id est passée en paramètres
	  
---------------------------------------------  API VILLE  -----------------------------------------------------------------
	  
- VisitMyCities-Ville : Microservice qui génère une API RESTFUL pour la gestion des Villes (port 9092)
  ## Pour démarrer :
	La config est la meme que pour le microservice Batiment

  ### Url de l'API VILLE:

	- /Ville
	
	- GET	|  http://localhost:9092/ville/		=> retourne la liste des villes.
	
	- GET	|  http://localhost:9092/ville/{id}	=> retourne les informations sur une seule ville correspondant à {id}.
	
	- POST	|  http://localhost:9092/ville/		=> enregistre une ville dans la base avec les infos en parametre et retourne les
								informations sur cette nouvelle vile http://localhost:9092/ville/{id}
	
	- PUT	|  http://localhost:9092/ville/{id}	=> Modifie une ville dans la base avec les infos en parametre et retourne les
							informations sur la ville qui a été modifée http://localhost:9092/ville/{id}
		
	- DELETE|  http://localhost:9092/ville/{id}	=> Supprime la ville correspondant à {id} de la base de données.

