package ensta.model.ship;
import ensta.model.ship.AbstractShip;
import ensta.util.Orientation;

public class BattleShip extends AbstractShip {
    public BattleShip() {
        setLabel('B');
        setName("BattleShip");
        setLength(4);
    }
    public BattleShip(Orientation orientation) {
        setLabel('B');
        setName("BattleShip");
        setLength(4);
        setOrientation(orientation);
    }
}