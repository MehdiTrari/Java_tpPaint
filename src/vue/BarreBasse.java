package vue;

import javax.swing.*;
import java.awt.*;

public class BarreBasse extends JPanel  {
    
    private JLabel message,labX,labY;

    public BarreBasse() {
        this.setLayout(new GridLayout(1,3));
        
        this.message = new JLabel("Dessiner la Forme");
        this.labX = new JLabel("X=");
        this.labY = new JLabel("Y=");
        
        this.add(message);
        this.add(labX);
        this.add(labY);
        
    }

    public JLabel getLabX() {
        return labX;
    }

    public JLabel getLabY() {
        return labY;
    }
    
    
    
    
    
    
    
}
