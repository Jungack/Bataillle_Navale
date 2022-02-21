package ensta.model;
import ensta.model.Board;
import ensta.model.Coords;
import ensta.model.ship.*;
import ensta.util.Orientation;

public class TestBoard {
    public static void main(String[] args) {
        Board Plateau = new Board("Test Board", 25);
        Destroyer destroyer = new Destroyer(Orientation.NORTH);
        Carrier carrier = new Carrier(Orientation.NORTH);
        Coords coords = new Coords(2,3);
        Coords coords2 = new Coords(5,3);
        Plateau.putShip(destroyer, coords);
        Plateau.putShip(carrier, coords2);
        Plateau.print();
    }
}