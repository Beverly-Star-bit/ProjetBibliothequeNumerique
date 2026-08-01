package services;


import model.Document;
import exceptions.DocumentIndisponibleException;

import java.util.ArrayList;



public class Bibliotheque {


    private ArrayList<Document> documents;



    public Bibliotheque() {

        documents = new ArrayList<>();

    }



    public void ajouterDocument(Document document) {

        documents.add(document);

    }




    public ArrayList<Document> getDocuments() {

        return documents;

    }





    // Recherche par ID

    public Document trouverDocumentParId(String id) {


        for(Document document : documents) {


            if(document.getId()
                    .equalsIgnoreCase(id)) {


                return document;

            }
        }


        return null;

    }





    // Recherche titre auteur ID

    public void rechercherDocument(String critere) {


        boolean trouve = false;



        for(Document document : documents) {


            if(document.getTitre()
                    .toLowerCase()
                    .contains(critere.toLowerCase())

                    ||

                    document.getAuteur()
                            .toLowerCase()
                            .contains(critere.toLowerCase())

                    ||

                    document.getId()
                            .equalsIgnoreCase(critere)) {



                System.out.println(
                        "\n===== DETAIL DOCUMENT ====="
                );


                document.afficherInfos();



                System.out.println(
                        "Disponible : "
                                +
                                (document.estDisponible()
                                        ? "Oui"
                                        : "Non")
                );


                System.out.println(
                        "Nombre d'emprunts : "
                                +
                                document.getNbEmprunts()
                );


                System.out.println(
                        "=========================="
                );


                trouve = true;

            }

        }



        if(!trouve) {

            System.out.println(
                    "Aucun document trouvé."
            );

        }

    }





    public void emprunterDocument(String id)
            throws DocumentIndisponibleException {


        Document document =
                trouverDocumentParId(id);



        if(document != null) {


            document.emprunter();



        } else {


            System.out.println(
                    "Document introuvable."
            );

        }

    }





    public void retournerDocument(String id) {


        Document document =
                trouverDocumentParId(id);



        if(document != null) {


            document.retourner();



        } else {


            System.out.println(
                    "Document introuvable."
            );

        }

    }





    public void afficherDocuments() {


        for(Document document : documents) {


            document.afficherInfos();

        }

    }

}