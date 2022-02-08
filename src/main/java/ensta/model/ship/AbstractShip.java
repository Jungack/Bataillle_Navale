package ensta.model;
import ensta.util.Orientation;

public class AbstractShip {
    public AbstractShip(Character label, String nom, int taille, Orientation orientation) {
        this.label = label;
        this.nom = nom;
        this.taille = taille;
        this.orientation = orientation;
    }
    private Character label;
    private String nom;
    private int taille;
    private Orientation orientation;
}