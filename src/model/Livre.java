package model;

public class Livre extends Document {

    private int nombrePages;


    // Constructeur
    public Livre(String id,
                 String titre,
                 String auteur,
                 int anneePublication,
                 int nombrePages) {

        super(id, titre, auteur, anneePublication);

        if (nombrePages <= 0) {
            throw new IllegalArgumentException(
                    "Le nombre de pages doit être supérieur à 0."
            );
        }

        this.nombrePages = nombrePages;
    }


    // Getter

    public int getNombrePages() {
        return nombrePages;
    }


    // Catégorie du document

    @Override
    public String getCategorie() {
        return "Livre";
    }


    // Affichage des informations

    @Override
    public void afficherInfos() {

        System.out.println(
                "Catégorie : " + getCategorie()
                        + " | ID : " + getId()
                        + " | Titre : " + getTitre()
                        + " | Auteur : " + getAuteur()
                        + " | Année : " + getAnneePublication()
                        + " | Pages : " + nombrePages
        );
    }


    // Affichage sous forme de texte

    @Override
    public String toString() {

        return "Livre{" +
                "id='" + getId() + '\'' +
                ", titre='" + getTitre() + '\'' +
                ", auteur='" + getAuteur() + '\'' +
                ", anneePublication=" + getAnneePublication() +
                ", nombrePages=" + nombrePages +
                '}';
    }
}