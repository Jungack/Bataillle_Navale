package ensta.model;
import ensta.util.Orientation;

public class AbstractShip {
    public AbstractShip(Character label, String nom, int taille, Orientation orientation) {
        m_label = label;
        m_nom = nom;
        m_taille = taille;
        m_orientation = orientation;
    }
    protected Character m_label;
    protected String m_nom;
    protected int m_taille;
    protected Orientation m_orientation;
}