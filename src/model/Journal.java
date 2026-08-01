package model;

public class Journal extends Document {

    private String datePublication;
    
    // Constructeur
    public Journal(String id,
                   String titre,
                   String auteur,
                   int anneePublication,
                   String datePublication) {

        super(id, titre, auteur, anneePublication);

        if (datePublication == null || datePublication.isBlank()) {
            throw new IllegalArgumentException(
                    "La date de publication est obligatoire."
            );
        }

        this.datePublication = datePublication;
    }

    // Getter

    public String getDatePublication() {
        return datePublication;
    }

    // Catégorie du document

    @Override
    public String getCategorie() {
        return "Journal";
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
                        + " | Date publication : " + datePublication
        );
    }

    // Affichage sous forme de texte

    @Override
    public String toString() {

        return "Journal{" +
                "id='" + getId() + '\'' +
                ", titre='" + getTitre() + '\'' +
                ", auteur='" + getAuteur() + '\'' +
                ", anneePublication=" + getAnneePublication() +
                ", datePublication='" + datePublication + '\'' +
                '}';
    }
}