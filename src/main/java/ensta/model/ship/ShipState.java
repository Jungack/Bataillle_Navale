package ensta.model.ship;
import ensta.model.ship.AbstractShip;
import ensta.util.ColorUtil;

public class ShipState {
    private AbstractShip ship;
    private boolean struck;

    public ShipState() {
        this.struck = false;
        this.ship = new NoShip();
    }
    public ShipState(AbstractShip ship) {
        this.struck = false;
        this.ship = ship;
    }

    public void addStrike() { struck = true; }
    public boolean isStruck() { return struck; }

    public String getLabel() { 
        if (struck) {
            return ColorUtil.colorize(ship.getLabel(), ColorUtil.Color.RED);
        } else {
            return "" + ship.getLabel();
        }
    }

    public boolean isSunk() { return ship.isSunk(); }
    public AbstractShip getShip() { return ship; }
}