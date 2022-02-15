package ensta.model;
import ensta.model.AbstractShip;

public class Carrier extends AbstractShip {
    public Carrier(Orientation orientation) {
        this.label = 'C';
        this.nom = "Aircraft-Carrier";
        this.taille = 5;
        this.orientation = orientation;
    }
}