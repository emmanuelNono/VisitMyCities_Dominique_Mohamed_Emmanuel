-- generation of the occurence of Batiment
INSERT INTO Batiment(bat_id, bat_nom, bat_adresse, bat_coord_gps_ns, bat_coord_gps_oe, bat_annee_construction, 
bat_couleur, bat_description, bat_architecte, bat_ville ) VALUES (1, "Le Parlement Européen", "1 Avenue du Président Robert Schuman",
"nord", "ouest", 1999, "transparent", "Un très bel édifice", "Architecture Studio", 1);

INSERT INTO Ville (vil_nom, vil_cp) VALUES ("Strasbourg", "67000");

INSERT INTO Photo (pho_id, pho_titre, pho_source) VALUES (1, "Un sacré batiment", "http://");

