package modele;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends Forme {

    public Triangle(int xi, int yi, int xf, int yf, Color couleur) {
        super(xi, yi, xf, yf,  couleur, "Triangle");
    }



    @Override
    public void seDessiner(Graphics g) {

        g.setColor(couleur);
        // ajouter des nouvelles formes à dessiner (triangle par exemple : 3 drawLine)
        g.drawLine(xi, yi, xf, yf);
        g.drawLine(xf, yf, xi, yf);
        g.drawLine(xi, yi, xi, yf);





    }

}