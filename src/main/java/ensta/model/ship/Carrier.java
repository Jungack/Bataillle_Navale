package ensta.model.ship;
import ensta.model.ship.AbstractShip;
import ensta.util.Orientation;

public class Carrier extends AbstractShip {
    public Carrier() {
        setLabel('C');
        setName("Aircraft-Carrier");
        setLength(5);
    }
    public Carrier(Orientation orientation) {
        setLabel('C');
        setName("Aircraft-Carrier");
        setLength(5);
        setOrientation(orientation);
    }
}