package model;

public class Ebook extends Document {
    private double tailleMo;

    // Constructeur
    public Ebook(String id,
                 String titre,
                 String auteur,
                 int anneePublication,
                 double tailleMo) {

        super(id, titre, auteur, anneePublication);

        if (tailleMo <= 0) {
            throw new IllegalArgumentException(
                    "La taille du fichier doit être supérieure à 0 Mo."
            );
        }

        this.tailleMo = tailleMo;
    }

    // Getter

    public double getTailleMo() {
        return tailleMo;
    }

    // Catégorie du document

    @Override
    public String getCategorie() {
        return "Ebook";
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
                        + " | Taille : " + tailleMo + " Mo"
        );
    }

    // Affichage sous forme de texte

    @Override
    public String toString() {

        return "Ebook{" +
                "id='" + getId() + '\'' +
                ", titre='" + getTitre() + '\'' +
                ", auteur='" + getAuteur() + '\'' +
                ", anneePublication=" + getAnneePublication() +
                ", tailleMo=" + tailleMo +
                '}';
    }
}