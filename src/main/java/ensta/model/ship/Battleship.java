package ensta.model;
import ensta.model.AbstractShip;

public class Battleship extends AbstractShip {
    public Battleship(Orientation orientation) {
        this.label = 'B';
        this.nom = "BattleShip";
        this.taille = 4;
        this.orientation = orientation;
    }
}