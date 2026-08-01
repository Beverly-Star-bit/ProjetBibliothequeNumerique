package model;

public class Roman extends Livre {

    private String genre;


    // Constructeur
    public Roman(String id,
                 String titre,
                 String auteur,
                 int anneePublication,
                 int nombrePages,
                 String genre) {

        super(id, titre, auteur, anneePublication, nombrePages);
        if (genre == null || genre.isBlank()) {
            throw new IllegalArgumentException(
                    "Le genre du roman est obligatoire."
            );
        }

        this.genre = genre;
    }


    // Getter
    public String getGenre() {
        return genre;
    }


    // Catégorie
    @Override
    public String getCategorie() {
        return "Roman";
    }


    // Affichage
    @Override
    public void afficherInfos() {

        System.out.println(
                "Catégorie : " + getCategorie()
                        + " | ID : " + getId()
                        + " | Titre : " + getTitre()
                        + " | Auteur : " + getAuteur()
                        + " | Année : " + getAnneePublication()
                        + " | Pages : " + getNombrePages()
                        + " | Genre : " + genre
        );
    }
    @Override
    public String toString() {

        return "Roman{" +
                "id='" + getId() + '\'' +
                ", titre='" + getTitre() + '\'' +
                ", auteur='" + getAuteur() + '\'' +
                ", anneePublication=" + getAnneePublication() +
                ", nombrePages=" + getNombrePages() +
                ", genre='" + genre + '\'' +
                '}';
    }
}