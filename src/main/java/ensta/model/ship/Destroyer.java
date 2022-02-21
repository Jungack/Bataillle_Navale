package ensta.model.ship;
import ensta.model.ship.AbstractShip;
import ensta.util.Orientation;

public class Destroyer extends AbstractShip {
    public Destroyer() {
        setLabel('D');
        setName("Destroyer");
        setLength(2);
    }
    public Destroyer(Orientation orientation) {
        setLabel('D');
        setName("Destroyer");
        setLength(2);
        setOrientation(orientation);
    }
}