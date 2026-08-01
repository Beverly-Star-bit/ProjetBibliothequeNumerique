package model;


import interfaces.Empruntable;
import exceptions.DocumentIndisponibleException;



public abstract class Document implements Empruntable {


    private String id;
    private String titre;
    private String auteur;

    private boolean estDisponible;

    private int nbEmprunts;

    private int anneePublication;



    // Constructeur

    public Document(String id,
                    String titre,
                    String auteur,
                    int anneePublication) {


        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;


        // Au départ tous les documents sont disponibles

        this.estDisponible = true;


        // Aucun emprunt au départ

        this.nbEmprunts = 0;

    }




    public String getId() {

        return id;

    }



    public String getTitre() {

        return titre;

    }



    public String getAuteur() {

        return auteur;

    }



    public int getAnneePublication() {

        return anneePublication;

    }



    public boolean isEstDisponible() {

        return estDisponible;

    }



    public int getNbEmprunts() {

        return nbEmprunts;

    }







    // Emprunter un document

    @Override
    public void emprunter()
            throws DocumentIndisponibleException {


        if(!estDisponible) {


            throw new DocumentIndisponibleException(
                    "Le document est déjà emprunté."
            );


        }



        estDisponible = false;



        // IMPORTANT :
        // augmente le nombre d'emprunts

        nbEmprunts++;


    }







    // Retourner un document
    @Override
    public void retourner() {
        estDisponible = true;
    }

    @Override
    public boolean estDisponible() {
        return estDisponible;
    }

    public abstract void afficherInfos();

    public abstract String getCategorie();


}