package vue;

import modele.Forme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.List;


public class Fenetre extends JFrame implements WindowListener {

    
    private BarreHaute bh;
    private ZoneGraphique zg;
    private BarreBasse bb;
    private Fenetre ellememe;
    
    
    public Fenetre() {
        
        ellememe=this;
        
        zg=new ZoneGraphique(this);
        bh= new BarreHaute(zg);//fleche rouge
        bb= new BarreBasse ();    
        
        
        this.setSize(800, 600);
        this.setTitle("TP PAINT");
        this.setLocation(100,100);
        this.setLayout(new BorderLayout());// 5 zones N S E W C
        
        this.add(bh, BorderLayout.NORTH);
        this.add(zg,BorderLayout.CENTER);
        this.add(bb,BorderLayout.SOUTH);
        
        
        JMenuBar barreMenu = new JMenuBar();
        JMenu m1 = new JMenu("FICHIER");
        JMenuItem mi1 = new JMenuItem("sauvegarder le dessin");
        JMenuItem mi2 = new JMenuItem("charger un dessin");
        JMenuItem mi3 = new JMenuItem("quitter le menu");
        // Faire un menu ACTIONS avec les items suivants : filtrer les figures et symetrie horizontale


        // MENU ACTION
        JMenu m2 = new JMenu("ACTIONS");
        JMenu mi4 = new JMenu("filtrer les figures");
        JMenuItem mi5 = new JMenuItem("symetrie horizontale");
        // SOUS MENU COULEURS ET FORMES
        JMenu sm1 = new JMenu("Couleurs");
        JMenuItem smi0 = new JMenuItem("annuler filtre");
        smi0.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                zg.setFiltre(0);
                zg.setType(null);
                zg.repaint();

            }
        });

        JMenu sm2 = new JMenu("Formes");


        // SOUS MENUITEM COULEURS
        JMenuItem smi1 = new JMenuItem("Bleu");

        JMenuItem smi2 = new JMenuItem("Noir");
        JMenuItem smi3 = new JMenuItem("Rouge");
        // SOUS MENUITEM FORMES
        JMenuItem smi4 = new JMenuItem("Droite");
        smi4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                zg.setFiltre(1);
                zg.setType("Droite");
                zg.repaint();

            }
        });
        JMenuItem smi5 = new JMenuItem("Rectangle");
        smi5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                zg.setFiltre(1);
                zg.setType("Rectangle");
                zg.repaint();

            }
        });
        JMenuItem smi6 = new JMenuItem("Ovale");
        smi6.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                zg.setFiltre(1);
                zg.setType("Ovale");
                zg.repaint();

            }
        });
        JMenuItem smi7 = new JMenuItem("Triangle");
        smi7.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                zg.setFiltre(1);
                zg.setType("Triangle");
                zg.repaint();

            }
        });
        JMenuItem smi8 = new JMenuItem("Ovale Plein");
        smi8.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                zg.setFiltre(1);
                zg.setType("Ovale Plein");
                zg.repaint();

            }
        });
        JMenuItem smi9 = new JMenuItem("Rectangle Plein");
        smi9.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                zg.setFiltre(1);
                zg.setType("Rectangle Plein");
                zg.repaint();

            }
        });



        // ON AJOUTE LES ITEMS DU MENU FICHIER
        m1.add(mi1);
        m1.add(mi2);
        m1.add(mi3);

        // ON AJOUTE LES ITEMS DU MENU ACTIONS
        m2.add(mi4);
        m2.add(mi5);

        // ON AJOUTE LES SOUS MENUS FORMES ET COULEURS
        mi4.add(sm1);
        mi4.add(sm2);

        // ON AJOUTE LES ITEMS DE COULEURS
        sm1.add(smi1);
        sm1.add(smi2);
        sm1.add(smi3);

        // ON AJOUTE LES ITEMS FORMES
        sm2.add(smi4);
        sm2.add(smi5);
        sm2.add(smi6);
        sm2.add(smi7);
        sm2.add(smi8);
        sm2.add(smi9);
        mi4.add(smi0);




        barreMenu.add(m1);
        barreMenu.add(m2);
        this.setJMenuBar(barreMenu);


        
        mi2.addMouseListener(new MouseAdapter() {
                //CHARGEMENT DES FORMES
            @Override
            public void mousePressed(MouseEvent e)  {

                JFileChooser jfc = new JFileChooser();
                int reponse = jfc.showDialog(ellememe, "CHARGER");

                
                
                if (reponse==0) //clic sur CHARGER
                {
                    ObjectInputStream ois = null;
                    FileInputStream fichier=null;
                    String chemin = jfc.getSelectedFile().toString();
                    
                        try
                        {fichier = new FileInputStream( chemin  );
                        ois = new ObjectInputStream(fichier);
                        //transfert des Formes du fichier vers la collection 
                        
                        List<Forme> LF = ellememe.zg.getLaCollectionDeFormes();
                        LF.clear();
                        int temoin=1;
                        do
                        {
                            try
                            {
                               LF.add ( (Forme)(ois.readObject())   );
                            }
                            catch(Exception exx)
                            {
                                temoin=0;
                            }
                        }while(temoin==1);
                        JOptionPane.showMessageDialog(ellememe, "chargement reussie", "ETAT DU CHARGEMENT",1);
                            ois.close();
                            fichier.close();
                            ellememe.zg.repaint();
                        }
                        catch(IOException ioe)
                        {
                            System.out.println("souci de chargement");
                                   }
                        
                }
            }
                
            });
        
        
        
        mi1.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                
                //System.out.println("clic sur sauvegarde ");
                JFileChooser jfc = new JFileChooser();
                int reponse = jfc.showDialog(ellememe, "SAUVER");
                
                
                if (reponse==0) //clic sur SAUVER
                {
                
                    ObjectOutputStream oos = null;
                    FileOutputStream fichier=null;


                        String chemin = jfc.getSelectedFile().toString();
                        try
                        {fichier = new FileOutputStream( chemin  );
                        oos = new ObjectOutputStream(fichier);
                        //transfert des Formes de la collection vers le fichier
                            for(Forme f : ellememe.zg.getLaCollectionDeFormes())
                            {
                                oos.writeObject(f);
                            }
           JOptionPane.showMessageDialog(ellememe, "sauvegarde reussie", "ETAT DE LA SAUVEGARDE",1);
                            
                            
                            
                            oos.close();
                            fichier.close();
                            
                        }
                        catch(IOException ioe)
                        {
                            System.out.println("souci de sauvegarde ");
                        }
                        
                    
                    
                
                }

                mi3.addMouseListener(new MouseAdapter() {

                                         @Override
                                         public void mousePressed(MouseEvent e) {
                                             System.exit(0);

                                         }

                                     });


                //System.out.println("chemin="+jfc.getSelectedFile());
                //System.out.println(jfc.getCurrentDirectory());
                //System.out.println("TERMINE reponse="+reponse);

                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
            }
        
        
        });
        
        
        
        this.setVisible(true);
       // this.addWindowListener(this); //la fenetre s'écoute elle meme
        
        //3eme forme d'écouteurs
        this.addWindowListener(new WindowAdapter(){  

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);

            }
        
            
        
        
        
        });
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    public BarreHaute getBh() {
        return bh;
    }

    public BarreBasse getBb() {
        return bb;
    }

    
    
    
}
