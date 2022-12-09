package modele;

import java.awt.Color;
import java.awt.Graphics;

public class Droite extends Forme {

    public Droite(int xi, int yi, int xf, int yf, Color couleur) {
        super(xi, yi, xf, yf,  couleur, "Droite");
    }

    
    
    
    @Override
    public void seDessiner(Graphics g ) {
        
        g.setColor(couleur);
        g.drawLine(xi,yi,xf,yf);
        
    }
    
}
