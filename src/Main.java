import model.Document;

import services.Bibliotheque;
import services.CSVReader;
import services.Statistiques;
import services.Rapport;


import exceptions.DocumentIndisponibleException;


import java.util.Scanner;



public class Main {


    public static void main(String[] args) {



        Bibliotheque bibliotheque =
                new Bibliotheque();



        CSVReader lecteur =
                new CSVReader();



        lecteur.chargerDocuments(
                "data/documents.csv",
                bibliotheque
        );





        System.out.println(
                "===== DOCUMENTS CHARGES ====="
        );


        bibliotheque.afficherDocuments();






        Scanner scanner =
                new Scanner(System.in);



        int choix;






        do {



            System.out.println(
                    "\n===== MENU BIBLIOTHEQUE ====="
            );


            System.out.println(
                    "1. Rechercher un document"
            );


            System.out.println(
                    "2. Emprunter un document"
            );


            System.out.println(
                    "3. Retourner un document"
            );


            System.out.println(
                    "4. Statistiques et rapport"
            );


            System.out.println(
                    "5. Quitter"
            );



            System.out.print(
                    "Votre choix : "
            );



            choix = scanner.nextInt();

            scanner.nextLine();







            switch(choix) {



                case 1:


                    System.out.print(
                            "Titre, auteur ou ID : "
                    );


                    String recherche =
                            scanner.nextLine();



                    bibliotheque.rechercherDocument(
                            recherche
                    );


                    break;









                case 2:



                    System.out.print(
                            "ID du document : "
                    );


                    String idEmprunt =
                            scanner.nextLine();




                    try {


                        bibliotheque.emprunterDocument(
                                idEmprunt
                        );



                        System.out.println(
                                "Emprunt effectué."
                        );



                    }
                    catch(DocumentIndisponibleException e){


                        System.out.println(
                                "Erreur : "
                                        + e.getMessage()
                        );


                    }



                    break;









                case 3:



                    System.out.print(
                            "ID du document : "
                    );


                    String idRetour =
                            scanner.nextLine();




                    bibliotheque.retournerDocument(
                            idRetour
                    );



                    System.out.println(
                            "Retour effectué."
                    );



                    break;









                case 4:



                    Statistiques stats =
                            new Statistiques(
                                    bibliotheque.getDocuments()
                            );



                    System.out.println(
                            "\n===== STATISTIQUES ====="
                    );



                    System.out.println(
                            "Nombre total : "
                                    +
                                    stats.nombreTotalDocuments()
                    );





                    System.out.println(
                            "\n===== JAMAIS EMPRUNTES ====="
                    );



                    for(Document document :
                            stats.documentsJamaisEmpruntes()) {



                        System.out.println(
                                "- "
                                        + document.getTitre()
                        );

                    }







                    Document meilleur =
                            stats.documentLePlusEmprunte();



                    System.out.println(
                            "\n===== PLUS EMPRUNTE ====="
                    );



                    if(meilleur != null){


                        System.out.println(
                                meilleur.getTitre()
                                        +
                                        " : "
                                        +
                                        meilleur.getNbEmprunts()
                                        +
                                        " emprunt(s)"
                        );


                    }







                    System.out.println(
                            "\nTaux utilisation : "
                                    +
                                    stats.tauxUtilisation()
                                    +
                                    " %"
                    );








                    Rapport rapport =
                            new Rapport();



                    rapport.genererRapport(
                            bibliotheque,
                            stats,
                            "rapport_bibliotheque.txt"
                    );



                    break;









                case 5:



                    System.out.println(
                            "Fermeture..."
                    );


                    break;

                default:


                    System.out.println(
                            "Choix invalide."
                    );

            }

        }
        while(choix != 5);
        scanner.close();
    }
}