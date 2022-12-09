package modele;

import java.awt.Color;
import java.awt.Graphics;

public class Ovale extends Forme {

    public Ovale(int xi, int yi, int xf, int yf, Color couleur) {
        super(xi, yi, xf, yf,  couleur, "Ovale");
    }
    
    
    
    @Override
    public void seDessiner(Graphics g) {
        
        g.setColor(couleur);
        g.drawOval(Math.min(xi,xf), Math.min(yi,yf), Math.abs(xi-xf), Math.abs(yi-yf));
        
        
    }
    
}








