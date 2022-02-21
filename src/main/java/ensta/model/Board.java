package ensta.model;

import ensta.model.ship.AbstractShip;
import ensta.model.ship.NoShip;
import ensta.util.Orientation;
import ensta.model.ship.ShipState;
import ensta.util.ColorUtil;
import ensta.model.Hit;

public class Board implements IBoard {

	private static int DEFAULT_SIZE = 10;
	
	public Board(String nom, int taille) {
		m_nom = nom;
		m_navires = new ShipState[taille][taille];
		m_frappes = new Boolean[taille][taille];
		for (int i = 0; i < taille; ++i) {
			for (int j = 0; j < taille; j++) {
				m_navires[i][j] = new ShipState();
			}
		}
		for (int i = 0; i < taille; ++i) {
			for (int j = 0; j < taille; j++) {
				m_frappes[i][j] = null;
			}
		}
		size = taille;
	}

	public Board(String nom) {
		m_nom = nom;
		m_navires = new ShipState[DEFAULT_SIZE][DEFAULT_SIZE];
		m_frappes = new Boolean[DEFAULT_SIZE][DEFAULT_SIZE];
		for (int i = 0; i < DEFAULT_SIZE; ++i) {
			for (int j = 0; j < DEFAULT_SIZE; j++) {
				m_navires[i][j] = new ShipState();
			}
		}
		for (int i = 0; i < DEFAULT_SIZE; ++i) {
			for (int j = 0; j < DEFAULT_SIZE; j++) {
				m_frappes[i][j] = null;
			}
		}
		size = DEFAULT_SIZE;
	}

	public void print() {
		int espacement_grilles = 10;
		int taille_colonne_num_ligne = 5;
		String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.
		
		System.out.print("Navires :");
		for (int i = 0; i < size + espacement_grilles + taille_colonne_num_ligne - 9; ++i) {
			System.out.print(" ");
		}
		System.out.print("Frappes :" + newLine);

		for (int i = 0; i < 2; ++i) {
			for (int j = 0; j < taille_colonne_num_ligne; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < size; j++) {
				System.out.print(Character.toString(65 + j));
			}
			for (int j = 0; j < espacement_grilles; j++) {
				System.out.print(" ");
			}
		}
		System.out.print(newLine);
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < 2; j++) {
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
				if (j == 0) {
					for (int k = 0; k < size; ++k) {
						System.out.print(m_navires[k][i].getLabel());
					}
				
					for (int k = 0; k < espacement_grilles; ++k) {
						System.out.print(" ");
					}
				} else {
					for (int k = 0; k < size; ++k) {
						if (m_frappes[k][i] == null) {
							System.out.print(".");
						} else if (m_frappes[k][i] == false) {
							System.out.print("X");
						} else {
							System.out.print(ColorUtil.colorize("X", ColorUtil.Color.RED));
						}
					} 
				}
			}		
			System.out.print(newLine);
		}
	}

	public boolean putShip(AbstractShip ship, Coords coords) {
		Orientation o = ship.getOrientation();
		int taille_bateau = ship.getLength();

		if (!canPutShip(ship, coords)) return false;

		for (int i = 0; i < taille_bateau; ++i) {
			ShipState tempShipState = new ShipState(ship);
			if (o == Orientation.NORTH || o == Orientation.SOUTH) {
				m_navires[coords.getX()][coords.getY() + o.getIncrement() * i] = tempShipState;
			} else {
				m_navires[coords.getX() + o.getIncrement() * i][coords.getY()] = tempShipState;
			}
		}
		return true;
	}

	public int getSize() { return size; }

	public boolean hasShip(Coords coords) { return !(m_navires[coords.getX()][coords.getY()].getLabel().equals(".")); }

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


	public Hit sendHit(int x, int y) {
		Coords coords = new Coords(x,y);
		if (!hasShip(coords)) {
			return Hit.MISS;
		} else {
			m_navires[x][y].addStrike();
			if (m_navires[x][y].isSunk()) {
				System.out.println(m_navires[x][y].getLabel() + " coulé.");
				return Hit.fromInt(m_navires[x][y].getShip().getLength());
			} else {
				return Hit.STRIKE;
			}
		}
	}

	public Hit sendHit(Coords res) { return sendHit(res.getX(), res.getY()); }

	public Boolean getHit(Coords coords) {
		return m_frappes[coords.getX()][coords.getY()];
	}

	public void setHit(boolean hit, Coords coords) {
		m_frappes[coords.getX()][coords.getY()] = hit;
	}

	private String m_nom;
	private ShipState m_navires[][];
	private Boolean m_frappes[][];
	private int size;
}
