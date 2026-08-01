package model;

public class Magazine extends Document {

    private int numero;


    // Constructeur
    public Magazine(String id,
                    String titre,
                    String auteur,
                    int anneePublication,
                    int numero) {

        super(id, titre, auteur, anneePublication);

        if (numero <= 0) {
            throw new IllegalArgumentException(
                    "Le numéro du magazine doit être supérieur à 0."
            );
        }

        this.numero = numero;
    }


    // Getter

    public int getNumero() {
        return numero;
    }


    // Catégorie du document

    @Override
    public String getCategorie() {
        return "Magazine";
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
                        + " | Numéro : " + numero
        );
    }


    // Affichage sous forme de texte

    @Override
    public String toString() {

        return "Magazine{" +
                "id='" + getId() + '\'' +
                ", titre='" + getTitre() + '\'' +
                ", auteur='" + getAuteur() + '\'' +
                ", anneePublication=" + getAnneePublication() +
                ", numero=" + numero +
                '}';
    }
}