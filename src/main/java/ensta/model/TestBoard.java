package ensta.model;
import ensta.model.Board;
import ensta.model.Coords;
import ensta.model.ship.*;
import ensta.util.Orientation;
import ensta.model.Player;
import java.io.Serializable;
import java.util.List;
import java.util.Arrays;

public class TestBoard {
    public static void main(String[] args) {
        Board board = new Board("My Board", 25);
        Board opponentBoard = new Board("Opponent board", 25);
        Destroyer destroyer = new Destroyer();
        Submarine submarine1 = new Submarine();
        Submarine submarine2 = new Submarine();
        BattleShip battleship = new BattleShip();
        Carrier carrier = new Carrier();
        List<AbstractShip> ships = Arrays.asList(destroyer, submarine1, submarine2, battleship, carrier);
        Player player = new Player(board, opponentBoard, ships);
        player.putShips();
        board.print();
    }
}