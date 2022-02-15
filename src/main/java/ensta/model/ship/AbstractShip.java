package ensta.model;
import ensta.util.Orientation;

public class AbstractShip {
    public AbstractShip(Character label, String nom, int taille, Orientation orientation) {
        this.label = label;
        this.nom = nom;
        this.taille = taille;
        this.orientation = orientation;
    }

    public Character get_label() { return label };
    public String get_nom() { return nom };
    public int get_taille() { return taille };
    public Orientation get_orientation() { return orientation };

    public void change_orientation(Orientation o) { orientation = o };
    
    private Character label;
    private String nom;
    private int taille;
    private Orientation orientation;
}