package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BarreHaute extends JPanel {

    private JComboBox lesCouleurs,lesFormes;
    private JButton beff, beffTout, blaGomme;
    private ZoneGraphique saZG;

    private int gomme = 0;

    public int getGomme() {
        return gomme;
    }

    public BarreHaute(ZoneGraphique z) {
        saZG=z;//fleche rouge
        
        //FlowLayout par defaut 
        lesCouleurs = new JComboBox();
        lesCouleurs.addItem("Bleu");
        lesCouleurs.addItem("Noir");
        lesCouleurs.addItem("Rouge");
        beff=new JButton("EFFACE");
        beffTout=new JButton("RESET");
        blaGomme = new JButton("GOMME");
                
        
        
        lesFormes = new JComboBox();
        lesFormes.addItem("Droite");
        lesFormes.addItem("Rectangle");
        lesFormes.addItem("Ovale");
        lesFormes.addItem("Triangle");
        lesFormes.addItem("Ovale Plein");
        lesFormes.addItem("Rectangle Plein");

        this.add(lesCouleurs);
        this.add(lesFormes);
        this.add(beff);
        this.add(beffTout);
        this.add(blaGomme);



        
        
        
        beff.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent e) {
              
                
                
                int taille = saZG.getLaCollectionDeFormes().size();
                if (taille>0)
                {saZG.getLaCollectionDeFormes().remove(taille-1);
                    saZG.repaint();
                }
                
                
                
            }
        
        
        
        });
        
        
        this.beffTout.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {

                saZG.getLaCollectionDeFormes().clear();
                saZG.repaint();
                
            }

            
            
            
        });

        this.blaGomme.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {

                if (gomme == 0)
                {
                    gomme = 1;
                    blaGomme.setBackground(Color.GRAY);

                }
                else
                {
                    gomme = 0;
                    blaGomme.setBackground(null);


                }

            }




        });


        
        
        
        
        
        
    }//fin du constructeur

    public JComboBox getLesCouleurs() {
        return lesCouleurs;
    }

    public JComboBox getLesFormes() {
        return lesFormes;
    }


    
    
    
    
    
    
    
}
