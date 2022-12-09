package modele;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Forme {

    public Rectangle(int xi, int yi, int xf, int yf, Color couleur) {
        super(xi, yi, xf, yf,  couleur, "Rectangle");
    }
    
    
    
    @Override
    public void seDessiner(Graphics g) {
        
        g.setColor(couleur);
        g.drawRect(Math.min(xi,xf), Math.min(yi,yf), Math.abs(xi-xf), Math.abs(yi-yf));
        
        
    }
    
}








