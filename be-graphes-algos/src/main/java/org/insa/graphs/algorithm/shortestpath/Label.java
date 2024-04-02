package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.model.Arc;
import org.insa.graphs.model.Node;

public class Label {
    private Node sommet_courant;
    private boolean marque;
    private int cout_realise;
    private Arc pere;

    public Label( Node sommet_courant,boolean marque,int cout_realise,Arc pere){
        this.sommet_courant=sommet_courant;
        this.marque=marque;
        this.cout_realise=cout_realise;
        this.pere=pere;
    }

    public Node get_sommet_Courant(){
        return this.sommet_courant;

    }
    public Boolean get_marque(){
        return this.marque;

    }
    public int getCost(){
        return this.cout_realise;

    }
    public Arc get_pere(){
        return this.pere;

    }


    
}
