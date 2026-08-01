package interfaces;

import exceptions.DocumentIndisponibleException;

public interface Empruntable {

    void emprunter() throws DocumentIndisponibleException;

    void retourner();

    boolean estDisponible();
}