package ensta.model;
import ensta.model.AbstractShip;

public class Submarine extends AbstractShip {
    public Submarine(Orientation orientation) {
        this.label = 'S';
        this.nom = "Submarine";
        this.taille = 3;
        this.orientation = orientation;
    }
}