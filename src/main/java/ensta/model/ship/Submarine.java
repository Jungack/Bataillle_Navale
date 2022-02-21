package ensta.model.ship;
import ensta.model.ship.AbstractShip;
import ensta.util.Orientation;

public class Submarine extends AbstractShip {
    public Submarine() {
        setLabel('S');
        setName("Submarine");
        setLength(3);
    }
    public Submarine(Orientation orientation) {
        setLabel('S');
        setName("Submarine");
        setLength(3);
        setOrientation(orientation);
    }
}