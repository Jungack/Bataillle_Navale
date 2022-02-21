package ensta.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import ensta.model.Board;
import ensta.model.Coords;
import ensta.model.Hit;
import ensta.model.Player;
import ensta.model.ship.AbstractShip;
import ensta.model.ship.BattleShip;
import ensta.model.ship.Carrier;
import ensta.model.ship.Destroyer;
import ensta.model.ship.Submarine;
import ensta.util.ColorUtil;
import ensta.ai.BattleShipsAI;

public class TestGame {
    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Board board = new Board("AI board");
        board.print();
        Destroyer destroyer = new Destroyer();
        Submarine submarine1 = new Submarine();
        Submarine submarine2 = new Submarine();
        BattleShip battleship = new BattleShip();
        Carrier carrier = new Carrier();
        AbstractShip ships[] = new AbstractShip[]{destroyer, submarine1, submarine2, battleship, carrier};
        BattleShipsAI ai = new BattleShipsAI(board, board);
        ai.putShips(ships);
        int destroyedShips = 0;
        while (destroyedShips < 5) {
            Coords coords = new Coords();
            Hit hit = ai.sendHit(coords);
            System.out.println("Coordonnées du hit : (" + coords.getX() + ", " + coords.getY() + ")");
            if (hit != Hit.STRIKE && hit != Hit.MISS) {
                System.out.println(hit.toString() + " coulé");
                destroyedShips += 1;
            } else {
                System.out.println(hit.toString());
            }
            board.print();
        }
    }
}