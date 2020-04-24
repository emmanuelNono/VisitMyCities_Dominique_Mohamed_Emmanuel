# Visit My Cities

## par Dominique SAUVIGNON, Emmanuel NONO et Mohammed BENKHALID

### Principe : plusieurs microservices qui font ensemble un projet global

- VisitMyCities-Batiment : Microservice qui génère une API RESTFUL pour la gestion des Bâtiments (port 9090)



### Pour démarrer :

1. cloner le repository github
2. import chaque projet du repository
3. démarrer chaque projet en faisant une configuration de run avec :
   1. le projet en répertoire de base
   2. en goals : la commande suivante : clean install spring-boot:run


### Url des API :

- Microservice Batiment (fournir les informations des bâtiments et de leur photos) : port 9090
	- /batiments
		- / (GET)	=> retourne tous les batiments
		- /{id} (GET) => retourne les informations correspondant au batiment avec l'id données dans l'url
		- / (POST) ->ajoute le batîment avec les données fournies en paramètres
		- /{id} (PUT) -> modifie le bâtiment
		  - dont l'url est passée dans l'url
		  - avec les données passées en paramètres
		- / (DELETE) -> supprime le bâtiment dont l'id est donnée dans l'url

	- /photos

	  - / (GET) => retourne toutes les photos
	  - /{id} (GET) => retourne les informations de la photo
	  - / (POST) => ajout la photo avec les infos passées en paramètres
	  - /{id}  (PUT) => modifie les informations de la photo dont l'id est passée dans l'url
	  - /{id} (DELETE) => supprimer la photo dont l'id est passée en paramètres
