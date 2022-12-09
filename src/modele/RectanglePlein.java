package modele;

import java.awt.Color;
import java.awt.Graphics;

public class RectanglePlein extends Forme {

    public RectanglePlein(int xi, int yi, int xf, int yf, Color couleur) {
        super(xi, yi, xf, yf,  couleur, "RectanglePlein");
    }



    @Override
    public void seDessiner(Graphics g) {

        g.setColor(couleur);
        g.fillRect(Math.min(xi,xf), Math.min(yi,yf), Math.abs(xi-xf), Math.abs(yi-yf));


    }

}
