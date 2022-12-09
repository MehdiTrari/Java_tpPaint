package vue;

import modele.*;
import modele.Rectangle;
import vue.BarreHaute;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class ZoneGraphique extends Canvas implements MouseMotionListener {
int anc_x2, anc_y2;
    private int x1,x2,y1,y2;
    private Fenetre saFenetre;
    private List<Forme> laCollectionDeFormes;

    private int Filtre = 0;

    private String Type = null;


    public ZoneGraphique(Fenetre f) {
        saFenetre=f;//fleche bleue
        laCollectionDeFormes = new LinkedList();
        this.setBackground(Color.white);
        
        this.addMouseListener(new MouseAdapter(){

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("X="+e.getX()+ " Y="+e.getY());
                x1=e.getX();
                y1=e.getY();
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(saFenetre.getBh().getGomme() == 0) {
                    x2 = e.getX();
                    y2 = e.getY();

                    Color couleurChoisie = Color.blue;
                    switch (saFenetre.getBh().getLesCouleurs().getSelectedIndex()) {
                        case 1:
                            couleurChoisie = Color.BLACK;
                            break;
                        case 2:
                            couleurChoisie = Color.red;
                            break;


                        default:
                            break;

                    }

                    Forme laForme = null;
                    switch (saFenetre.getBh().getLesFormes().getSelectedIndex()) {
                        case 0:
                            laForme = new Droite(x1, y1, x2, y2, couleurChoisie);
                            break;
                        case 1:
                            laForme = new Rectangle(x1, y1, x2, y2, couleurChoisie);

                            break;
                        case 2:
                            laForme = new Ovale(x1, y1, x2, y2, couleurChoisie );
                            break;
                        case 3:
                            laForme = new Triangle(x1, y1, x2, y2, couleurChoisie );
                            break;
                        case 4:
                            laForme = new OvalePlein(x1, y1, x2, y2, couleurChoisie );
                            break;
                        case 5:
                            laForme = new RectanglePlein(x1, y1, x2, y2, couleurChoisie );
                            break;


                    }

                    laCollectionDeFormes.add(laForme);
                    System.out.println("taille de la collection :" + laCollectionDeFormes.size());
                    laForme.seDessiner(getGraphics());

                }

            }
        });
        
        
        
         
        //this.addMouseMotionListener(this);
        this.addMouseMotionListener(  new MouseMotionAdapter(){
                @Override
                public void mouseMoved(MouseEvent e) {
                      
                        saFenetre.getBb().getLabX().setText("X="+e.getX());
                        saFenetre.getBb().getLabY().setText("Y="+e.getY());
                }
                public void mouseDragged(MouseEvent e) {
                    if (saFenetre.getBh().getGomme() == 0) {

                        x2 = e.getX();
                        y2 = e.getY();

                        Color couleurChoisie = Color.black;

                        Forme laForme = null;
                        Forme ancForme = null;
                        switch (saFenetre.getBh().getLesFormes().getSelectedIndex()) {
                            case 0:
                                ancForme = new Droite(x1, y1, anc_x2, anc_y2, Color.white );
                                laForme = new Droite(x1, y1, x2, y2, couleurChoisie );
                                break;
                            case 1:
                                ancForme = new Rectangle(x1, y1, anc_x2, anc_y2, Color.white );
                                laForme = new Rectangle(x1, y1, x2, y2, couleurChoisie );
                                break;
                            case 2:
                                ancForme = new Ovale(x1, y1, anc_x2, anc_y2, Color.white);
                                laForme = new Ovale(x1, y1, x2, y2, couleurChoisie);
                                break;
                            case 3:
                                ancForme = new Triangle(x1, y1, anc_x2, anc_y2, Color.white);
                                laForme = new Triangle(x1, y1, x2, y2, couleurChoisie);
                                break;
                            case 4:
                                ancForme = new OvalePlein(x1, y1, anc_x2, anc_y2, Color.white);
                                laForme = new OvalePlein(x1, y1, x2, y2, couleurChoisie);
                                break;
                            case 5:
                                ancForme = new RectanglePlein(x1, y1, anc_x2, anc_y2, Color.white);
                                laForme = new RectanglePlein(x1, y1, x2, y2, couleurChoisie);
                                break;


                        }


                        ancForme.seDessiner(getGraphics());
                        laForme.seDessiner(getGraphics());
                        anc_x2 = x2;
                        anc_y2 = y2;

                    } else if (saFenetre.getBh().getGomme() == 1) {

                            Graphics g = getGraphics();
                            g.setColor(Color.white);
                            g.fillOval(e.getX(), e.getY(), 10, 10);
                    }
                }
        }    );
        
        /*
        this.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        */


    }//fin du constructeur
    public List<Forme> getLaCollectionDeFormes() {
        return laCollectionDeFormes;
    }


    public void paint(Graphics g)
    {

        super.paint(g);
        if(Filtre == 0 && Type == null){
            for (Forme f : this.laCollectionDeFormes) {
                f.seDessiner(g);
            }
        }
        if (Filtre == 1 && Type == "Droite") {
            for (Forme f : this.laCollectionDeFormes) {
                if (f instanceof Droite){
                    f.seDessiner(g);
                }
            }
        }
        if (Filtre == 1 && Type == "Ovale"){
            for (Forme f : this.laCollectionDeFormes) {
                if (f instanceof Ovale){
                    f.seDessiner(g);
                }
            }
        }
        if (Filtre == 1 && Type == "Rectangle"){
            for (Forme f : this.laCollectionDeFormes) {
                if (f instanceof Rectangle) {
                    f.seDessiner(g);
                }
            }
        }
        if (Filtre == 1 && Type == "Triangle"){
            for (Forme f : this.laCollectionDeFormes) {
                if (f instanceof Triangle) {
                    f.seDessiner(g);
                }
            }
        }
        if (Filtre == 1 && Type == "OvalePlein"){
            for (Forme f : this.laCollectionDeFormes) {
                if (f instanceof OvalePlein) {
                    f.seDessiner(g);
                }
            }
        }
        if (Filtre == 1 && Type == "RectanglePlein"){
            for (Forme f : this.laCollectionDeFormes) {
                if (f instanceof RectanglePlein) {
                    f.seDessiner(g);
                }
            }
        }


    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //        throw new UnsupportedOperationException("Not supported yet.");


    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //      throw new UnsupportedOperationException("Not supported yet.");
        System.out.println("x="+e.getX()+" y="+e.getY());
        this.saFenetre.getBb().getLabX().setText("X="+e.getX());
        this.saFenetre.getBb().getLabY().setText("Y="+e.getY());
    }


    public void setFiltre(int filtre) {
        Filtre = filtre;
    }

    public void setType(String type) {
        Type = type;
    }
}













