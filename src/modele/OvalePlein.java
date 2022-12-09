package modele;

import java.awt.Color;
import java.awt.Graphics;

public class OvalePlein extends Forme {

    public OvalePlein(int xi, int yi, int xf, int yf, Color couleur) {
        super(xi, yi, xf, yf,  couleur, "Ovaleplein");
    }



    @Override
    public void seDessiner(Graphics g) {

        g.setColor(couleur);
        g.fillOval(Math.min(xi,xf), Math.min(yi,yf), Math.abs(xi-xf), Math.abs(yi-yf));


    }

}
