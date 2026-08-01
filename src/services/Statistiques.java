package services;


import model.Document;

import java.util.ArrayList;
import java.util.HashMap;



public class Statistiques {



    private ArrayList<Document> documents;





    // Constructeur

    public Statistiques(ArrayList<Document> documents) {


        this.documents = documents;


    }







    // Nombre total de documents

    public int nombreTotalDocuments() {


        return documents.size();


    }









    // Nombre de documents par catégorie

    public HashMap<String,Integer>
    nombreDocumentsParCategorie() {


        HashMap<String,Integer> categories =
                new HashMap<>();



        for(Document document : documents) {


            String categorie =
                    document.getCategorie();



            categories.put(

                    categorie,

                    categories.getOrDefault(
                            categorie,
                            0
                    ) + 1

            );

        }


        return categories;

    }









    // Documents jamais empruntés

    public ArrayList<Document>
    documentsJamaisEmpruntes() {


        ArrayList<Document> resultat =
                new ArrayList<>();



        for(Document document : documents) {



            if(document.getNbEmprunts() == 0) {


                resultat.add(document);


            }


        }



        return resultat;


    }









    // Document le plus emprunté

    public Document documentLePlusEmprunte() {


        Document meilleur = null;



        for(Document document : documents) {


            if(meilleur == null ||

                    document.getNbEmprunts()
                            >
                            meilleur.getNbEmprunts()) {



                meilleur = document;


            }


        }



        return meilleur;


    }









    // Taux d'utilisation

    public double tauxUtilisation() {



        int compteur = 0;



        for(Document document : documents) {


            if(document.getNbEmprunts() > 0) {
               compteur++;
            }
        }
        if(documents.size() == 0) {
            return 0;
        }
        return (double) compteur
                / documents.size()
                * 100;
   }


}