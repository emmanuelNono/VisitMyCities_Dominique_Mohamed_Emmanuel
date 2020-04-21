# Visit My Cities

## par Dominique SAUVIGNON, Emmanuel NONO et Mohamed BENKHALID

Principe : plusieurs microservices qui font ensemble un projet global

- VMC : Batiment : Microservice qui génère une API RESTFUL pour la gestion des Bâtiments (port 9090)


 
## paramètres
en cas de soucis avec le timeZone, deux solutions : 
- sous MySQL, faire la commande SQL suivante : SET GLOBAL time_zone = '+2:00';
- **MAIS** j'ai corrigé le fichier de configuration et ajouté au bout de la ligne de connexion : ?serverTimezone=Europe/Paris