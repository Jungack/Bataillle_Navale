package ensta.model;
import ensta.model.AbstractShip;

public class Destroyer extends AbstractShip {
    public Destroyer(Orientation orientation) {
        this.label = 'D';
        this.nom = "Destroyer";
        this.taille = 2;
        this.orientation = orientation;
    }
}