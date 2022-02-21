package ensta.model.ship;
import ensta.util.Orientation;

public abstract class AbstractShip {
    public AbstractShip() {}
    public AbstractShip(Character label, String nom, int taille, Orientation orientation) {
        this.label = label;
        this.nom = nom;
        this.taille = taille;
        this.orientation = orientation;
    }

    public Character getLabel() { return label; }
    public String getName() { return nom; }
    public int getLength() { return taille; }
    public Orientation getOrientation() { return orientation; }

    public void setLabel(Character label) { this.label = label; }
    public void setName(String nom) { this.nom = nom; }
    public void setLength(int taille) { this.taille = taille; }
    public void setOrientation(Orientation orientation) { this.orientation = orientation; }

    public boolean isSunk() { return true; }
    
    private Character label;
    private String nom;
    private int taille;
    private Orientation orientation;
}