package services;


import model.Document;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;



public class Rapport {


    public void genererRapport(
            Bibliotheque bibliotheque,
            Statistiques statistiques,
            String nomFichier) {



        try (PrintWriter writer =
                     new PrintWriter(
                             new FileWriter(nomFichier)
                     )) {



            // Titre du rapport

            writer.println(
                    "===== RAPPORT DE LA BIBLIOTHEQUE NUMERIQUE ====="
            );

            writer.println();



            // Nombre total de documents

            writer.println(
                    "===== INFORMATIONS GENERALES ====="
            );


            writer.println(
                    "Nombre total de documents : "
                            + statistiques.nombreTotalDocuments()
            );


            writer.println();





            // Documents par catégorie

            writer.println(
                    "===== DOCUMENTS PAR CATEGORIE ====="
            );


            HashMap<String, Integer> categories =
                    statistiques.nombreDocumentsParCategorie();



            for(String categorie : categories.keySet()) {


                writer.println(
                        categorie
                                + " : "
                                + categories.get(categorie)
                                + " document(s)"
                );

            }


            writer.println();





            // Document le plus emprunté

            writer.println(
                    "===== DOCUMENT LE PLUS EMPRUNTE ====="
            );


            Document meilleur =
                    statistiques.documentLePlusEmprunte();



            if(meilleur != null) {


                writer.println(
                        "Titre : "
                                + meilleur.getTitre()
                );


                writer.println(
                        "Auteur : "
                                + meilleur.getAuteur()
                );


                writer.println(
                        "Nombre d'emprunts : "
                                + meilleur.getNbEmprunts()
                );


            } else {


                writer.println(
                        "Aucun emprunt enregistré."
                );

            }



            writer.println();






            // Documents jamais empruntés

            writer.println(
                    "===== DOCUMENTS JAMAIS EMPRUNTES ====="
            );


            ArrayList<Document> jamais =
                    statistiques.documentsJamaisEmpruntes();



            if(jamais.isEmpty()) {


                writer.println(
                        "Tous les documents ont déjà été empruntés."
                );


            } else {


                for(Document document : jamais) {


                    writer.println(
                            "- "
                                    + document.getTitre()
                                    + " ("
                                    + document.getCategorie()
                                    + ")"
                    );

                }

            }



            writer.println();







            // Taux utilisation

            writer.println(
                    "===== TAUX D'UTILISATION ====="
            );


            writer.println(
                    statistiques.tauxUtilisation()
                            + " %"
            );


            writer.println();








            // Documents disponibles

            writer.println(
                    "===== DOCUMENTS DISPONIBLES ====="
            );



            boolean disponible = false;



            for(Document document :
                    bibliotheque.getDocuments()) {



                if(document.estDisponible()) {


                    writer.println(
                            "- "
                                    + document.getTitre()
                                    + " ("
                                    + document.getCategorie()
                                    + ")"
                    );


                    disponible = true;

                }

            }



            if(!disponible) {


                writer.println(
                        "Aucun document disponible."
                );

            }




            writer.println();







            // Documents empruntés

            writer.println(
                    "===== DOCUMENTS EMPRUNTES ====="
            );



            boolean emprunte = false;



            for(Document document :
                    bibliotheque.getDocuments()) {


                if(!document.estDisponible()) {


                    writer.println(
                            "- "
                                    + document.getTitre()
                                    + " ("
                                    + document.getCategorie()
                                    + ")"
                    );


                    emprunte = true;

                }

            }



            if(!emprunte) {


                writer.println(
                        "Aucun document emprunté."
                );

            }





            writer.println();


            writer.println(
                    "===== FIN DU RAPPORT ====="
            );



            System.out.println(
                    "Rapport généré avec succès : "
                            + nomFichier
            );



        } catch(IOException e) {


            System.out.println(
                    "Erreur lors de la génération du rapport : "
                            + e.getMessage()
            );

        }

    }

}