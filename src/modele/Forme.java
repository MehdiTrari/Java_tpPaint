package modele;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;



public abstract class Forme implements Serializable  {
    
    protected  int xi,yi,xf,yf;
    protected Color couleur;

    protected String Type;

    public Forme(int xi, int yi, int xf, int yf, Color couleur, String Type) {
        this.xi = xi;
        this.yi = yi;
        this.xf = xf;
        this.yf = yf;
        this.couleur = couleur;
        this.Type = Type;
    }
    
    public abstract  void  seDessiner(Graphics g);

    public void setCouleur(Color c) {
        this.couleur = c;
    }

    public Color getCouleur() {
        return couleur;
    }

    public String getType() {
        return Type;
    }
}
