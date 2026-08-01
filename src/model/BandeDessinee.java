package model;

public class BandeDessinee extends Livre {

    private String illustrateur;

    // Constructeur
    public BandeDessinee(String id,
                         String titre,
                         String auteur,
                         int anneePublication,
                         int nombrePages,
                         String illustrateur) {

        super(id, titre, auteur, anneePublication, nombrePages);

        if (illustrateur == null || illustrateur.isBlank()) {
            throw new IllegalArgumentException(
                    "L'illustrateur est obligatoire."
            );
        }
        this.illustrateur = illustrateur;
    }

    // Getter

    public String getIllustrateur() {
        return illustrateur;
    }


    // Catégorie du document
    @Override
    public String getCategorie() {
        return "Bande Dessinee";
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
                        + " | Pages : " + getNombrePages()
                        + " | Illustrateur : " + illustrateur
        );
    }


    // Conversion en texte
    @Override
    public String toString() {
        return "BandeDessinee{" +
                "id='" + getId() + '\'' +
                ", titre='" + getTitre() + '\'' +
                ", auteur='" + getAuteur() + '\'' +
                ", anneePublication=" + getAnneePublication() +
                ", nombrePages=" + getNombrePages() +
                ", illustrateur='" + illustrateur + '\'' +
                '}';
    }
}