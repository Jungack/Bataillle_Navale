package ensta.model;

import java.io.Serializable;
import java.util.List;

import ensta.model.ship.AbstractShip;
import ensta.util.Orientation;
import ensta.view.InputHelper;

public class Player {
	/*
	 * ** Attributs
	 */
	private Board board;
	protected Board opponentBoard;
	private int destroyedCount;
	protected AbstractShip[] ships;
	private boolean lose;

	/*
	 * ** Constructeur
	 */
	public Player(Board board, Board opponentBoard, List<AbstractShip> ships) {
		this.setBoard(board);
		this.ships = ships.toArray(new AbstractShip[0]);
		this.opponentBoard = opponentBoard;
	}

	/*
	 * ** Méthodes
	 */

	/**
	 * Read keyboard input to get ships coordinates. Place ships on given
	 * coodrinates.
	 */
	public void putShips() {
		boolean done = false;
		int i = 0;

		do {
			AbstractShip ship = ships[i];
			String msg = String.format("placer %d : %s(%d)", i + 1, ship.getName(), ship.getLength());
			System.out.println(msg);
			InputHelper.ShipInput res = InputHelper.readShipInput();
			// TODO set ship orientation
			// TODO put ship at given position
			// TODO when ship placement successful
			if (res.x >= 0 && res.y >= 1 && res.x < this.board.getSize() && res.y <= this.board.getSize()) {
				Orientation tempOrientation = Orientation.randomOrientation();
				if (res.orientation.toLowerCase().equals("north")) {
					tempOrientation = Orientation.NORTH;
				} else if (res.orientation.toLowerCase().equals("south")) {
					tempOrientation = Orientation.SOUTH;
				} else if (res.orientation.toLowerCase().equals("east")) {
					tempOrientation = Orientation.EAST;
				} else {
					tempOrientation = Orientation.WEST;
				}
				ship.setOrientation(tempOrientation);
				Coords tempCoords = new Coords(res.x, res.y - 1);
				if (board.putShip(ship, tempCoords)) {
					++i;
					done = i == 5;
				} else {
					System.out.println("Impossible de placer le bateau à la position souhaitée ! Réessayez !");
				}
				board.print();
			} else {
				System.out.println("Impossible de placer le bateau à la position souhaitée ! Réessayez !");
			}
		} while (!done);
	}

	public Hit sendHit(Coords coords) {
		boolean done = false;
		Hit hit = null;

		do {
			System.out.println("où frapper?");
			InputHelper.CoordInput hitInput = InputHelper.readCoordInput();
			// TODO call sendHit on this.opponentBoard

			// TODO : Game expects sendHit to return BOTH hit result & hit coords.
			// return hit is obvious. But how to return coords at the same time ?
			if (hitInput.x >= 0 && hitInput.y >= 0 && hitInput.x < this.opponentBoard.getSize() && hitInput.y < this.opponentBoard.getSize()) {
				coords.setX(hitInput.x);
				coords.setY(hitInput.y);
				hit = this.opponentBoard.sendHit(hitInput.x, hitInput.y);
				done = true;
			}
			
		} while (!done);

		return hit;
	}

	public AbstractShip[] getShips() {
		return ships;
	}

	public void setShips(AbstractShip[] ships) {
		this.ships = ships;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public int getDestroyedCount() {
		return destroyedCount;
	}

	public void setDestroyedCount(int destroyedCount) {
		this.destroyedCount = destroyedCount;
	}

	public boolean isLose() {
		return lose;
	}

	public void setLose(boolean lose) {
		this.lose = lose;
	}
}
