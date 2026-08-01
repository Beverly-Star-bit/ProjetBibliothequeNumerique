package services;

import model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

   public void chargerDocuments(String chemin, Bibliotheque bibliotheque) {

        try (BufferedReader br = new BufferedReader(new FileReader(chemin))) {
            String ligne;
            // Ignorer l'en-tête
            br.readLine();
            while ((ligne = br.readLine()) != null) {
                try {
                    String[] donnees = ligne.split(";");

                    String type = donnees[0];
                    String id = donnees[1];
                    String titre = donnees[2];
                    String auteur = donnees[3];
                    int annee = Integer.parseInt(donnees[4]);

                    Document document = null;

                    switch (type) {

                        case "Livre":

                            int pagesLivre = Integer.parseInt(donnees[5]);

                            document = new Livre(
                                    id,
                                    titre,
                                    auteur,
                                    annee,
                                    pagesLivre
                            );
                            break;

                        case "Roman":
                            int pagesRoman = Integer.parseInt(donnees[5]);
                            String genre = donnees[6];

                            document = new Roman(
                                    id,
                                    titre,
                                    auteur,
                                    annee,
                                    pagesRoman,
                                    genre
                            );
                            break;

                        case "Ebook":
                            double taille = Double.parseDouble(donnees[5]);
                            document = new Ebook(
                                    id,
                                    titre,
                                    auteur,
                                    annee,
                                    taille
                            );
                            break;

                        case "Magazine":
                            int numero = Integer.parseInt(donnees[5]);
                            document = new Magazine(
                                    id,
                                    titre,
                                    auteur,
                                    annee,
                                    numero
                            );
                            break;

                        case "BandeDessinee":
                            int pagesBD = Integer.parseInt(donnees[5]);
                            String illustrateur = donnees[6];
                            document = new BandeDessinee(
                                    id,
                                    titre,
                                    auteur,
                                    annee,
                                    pagesBD,
                                    illustrateur
                            );
                            break;

                        default:
                            System.out.println(
                                    "Type inconnu : " + type
                            );
                    }
                    // Ajouter le document dans la bibliothèque
                    if (document != null) {
                        bibliotheque.ajouterDocument(document);
                    }

                } catch (Exception e) {
                    System.out.println(
                            "Erreur dans la ligne : "
                                    + ligne
                    );

                    System.out.println(
                            "Message : "
                                    + e.getMessage()
                    );
                }
            }
        } catch (IOException e) {
            System.out.println(
                    "Erreur de lecture du fichier : "
                            + e.getMessage()
            );
        }
    }
}