-- filling of the database

-- filling of the table Ville
--INSERT INTO Ville (id, vil_nom, vil_cp) VALUES 
--(1, "Strasbourg", "67000"),
--(2, "Schiltigheim", "67300");



-- fillingf of the table Batiment
INSERT INTO batiment(bat_id, bat_nom, bat_adresse, bat_coord_gps_ns, bat_coord_gps_oe, bat_annee_construction, bat_couleur, bat_description, bat_architecte, bat_ville ) VALUES
(1, "Le Parlement Européen", "1 Avenue du Président Robert Schuman", "nord", "ouest", 1999, "transparent", "Un très bel édifice", "Architecture Studio", 1),
(2, "La Mairie de Schiltigheim", "110 Route de Bischwiller, 67300 Schiltigheim", "nord", "ouest", 1969, "translucide", "Le nouvel hôtel de ville de Schiltigheim est construit de 1964 à 19691. Il est inauguré le 15 mars 19691. Les architectes en charge du projet sont alors Louis Schneider, de Strasbourg et Henri-Jean Calsat, de Paris1, ce dernier est également l'auteur de la Tour du square à Schiltigheim. De la même façon que la Tour du Square avait pris place sur l'emplacement d'une ancienne malterie, la nouvelle mairie est érigée sur le site de la malterie Lévy2, détruite en 1975 avec le Coq d'Or1 et la 'maison du directeur'. La nouvelle Mairie figure également au Plan de Rénovation du centre-ville de l'époque, dit 'Plan Calsat'1", "Louis Schneider", 2),
(3, "Cathédrale Notre Dame de Strasbourg", "2 Place de la Cathédrale", "nord", "ouest", 1180, "Grés des vosges", "La cathédrale de Strasbourg avec sa flèche unique de 142 mètres est le plus haut monument et le plus célèbre de la ville. Sur un sol mou, argileux, on a enfoncé des pieux de bois puis un mur de fondations. Les édifices se succèdent, de plus en plus lourds, reprenant d’anciens tracés. Ces chantiers ont tous été parmi les plus remarquables de l’Empire Germanique tant par les dimensions des édifices que par la puissance de leurs architectures1. ", "Des architectes", 1),
(4, "La CCI", "234 Avenue de Colmar", "nord", "ouest", 2000, "blanc", "Un lieu de formation à Strasbourg.", "Un architecte", 1);


-- filling of the table Photo
INSERT INTO photo (pho_id, pho_titre, pho_source, batiment_bat_id) VALUES
(1, "De l'extérieur", "https://www.challenges.fr/assets/img/2019/02/26/cover-r4x3w1000-5c9128900ad90-0ecd1063ad1bf594c59f7cdd03c93bda39684607-jpg.jpg",1),
(2, "L'hémicycle", "https://www.google.fr/url?sa=i&url=https%3A%2F%2Fwww.touteleurope.eu%2Factualite%2Fle-parlement-europeen-2019-2024.html&psig=AOvVaw33VcHff-q4m2DtXA4TuLDv&ust=1587646220349000&source=images&cd=vfe&ved=0CA0QjhxqFwoTCLjls5yJ_OgCFQAAAAAdAAAAABAI",1),
(3, "La fierté de l'Alsace :)", "https://commons.wikimedia.org/wiki/File:Strasbourg_Cathedral_Exterior_-_Diliff.jpg?uselang=fr",3),
(4, "La mairie de la 3e ville du Bash-Rhin", "https://www.archi-wiki.org/images/1/15/110_route_de_Bischwiller_Schiltigheim_29302.jpg",2);
--(5, "L'entrée", "https://www.alsacecongres.fr/wp-inside/uploads/sites/1/2019/08/cci-campus-strasbourg-copyright-yves-trotzier-720x440.jpg",4);