/*package ensta.model;

import ensta.model.ship.AbstractShip;
import ensta.util.Orientation;*/

public class Board /*implements IBoard*/ {

	private static int DEFAULT_SIZE = 10;
	
	public Board(String nom, int taille) {
		DEFAULT_SIZE = taille;
		m_nom = nom;
		m_navires = new Character[DEFAULT_SIZE * DEFAULT_SIZE];
		m_frappes = new boolean[DEFAULT_SIZE * DEFAULT_SIZE];
	}

	public Board(String nom) {
		m_nom = nom;
		m_navires = new Character[DEFAULT_SIZE * DEFAULT_SIZE];
		m_frappes = new boolean[DEFAULT_SIZE * DEFAULT_SIZE];
	}

	public void print() {
		int espacement_grilles = 10;
		int taille_colonne_num_ligne = 5;
		String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.
		
		System.out.print("Navires :");
		for (int i = 0; i < DEFAULT_SIZE + espacement_grilles + taille_colonne_num_ligne - 9; ++i) {
			System.out.print(" ");
		}
		System.out.print("Frappes :" + newLine);

		for (int i = 0; i < 2; ++i) {
			for (int j = 0; j < taille_colonne_num_ligne; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < DEFAULT_SIZE; j++) {
				System.out.print(Character.toString(65 + j));
			}
			for (int j = 0; j < espacement_grilles; j++) {
				System.out.print(" ");
			}
		}
		System.out.print(newLine);
		
		for (int i = 0; i < DEFAULT_SIZE; i++) {
			for (int j = 0; j < 2; ++j) {
				System.out.print(i + 1);
				if (i < 9) {
					for (int k = 1; k < taille_colonne_num_ligne; k++) {
						System.out.print(" ");
					}
				} else {
					for (int k = 2; k < taille_colonne_num_ligne; k++) {
						System.out.print(" ");
					}
				}

				for (int k = 0; k < DEFAULT_SIZE; ++k) {
					System.out.print(".");
				}

				for (int k = 0; k < espacement_grilles; ++k) {
					System.out.print(" ");
				}
			}
			System.out.print(newLine);
		}
	}
/*
	public boolean canPutShip(AbstractShip ship, Coords coords) {
		Orientation o = ship.getOrientation();
		int dx = 0, dy = 0;
		if (o == Orientation.EAST) {
			if (coords.getX() + ship.getLength() >= this.size) {
				return false;
			}
			dx = 1;
		} else if (o == Orientation.SOUTH) {
			if (coords.getY() + ship.getLength() >= this.size) {
				return false;
			}
			dy = 1;
		} else if (o == Orientation.NORTH) {
			if (coords.getY() + 1 - ship.getLength() < 0) {
				return false;
			}
			dy = -1;
		} else if (o == Orientation.WEST) {
			if (coords.getX() + 1 - ship.getLength() < 0) {
				return false;
			}
			dx = -1;
		}

		Coords iCoords = new Coords(coords);

		for (int i = 0; i < ship.getLength(); ++i) {
			if (this.hasShip(iCoords)) {
				return false;
			}
			iCoords.setX(iCoords.getX() + dx);
			iCoords.setY(iCoords.getY() + dy);
		}

		return true;
	}
*/
	protected String m_nom;
	protected Character m_navires[];
	protected boolean m_frappes[];
}
