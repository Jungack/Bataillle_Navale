package ensta.model;
import java.util.Random;

public class Coords {
    private int x;
    private int y;

    public Coords() {}
    public Coords(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Coords(Coords coords) {
        this.x = coords.getX();
        this.y = coords.getY();
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setCoords(Coords coords) {
        this.x = coords.getX();
        this.y = coords.getY();
    }

    public Boolean isInBoard(int size) {
        return (this.x >= 0 && this.y >= 0 && this.x < size && this.y < size);
    }

    public static Coords randomCoords(int size) {
        Coords coords = new Coords();
        Random r = new Random();
		coords.setX(r.nextInt(size));
		coords.setY(r.nextInt(size));
        return coords;
    }
}