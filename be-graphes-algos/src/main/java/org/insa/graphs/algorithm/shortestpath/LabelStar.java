package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.model.Arc;
import org.insa.graphs.model.Node;

public class LabelStar extends Label{

    private double cout_distant;


    public LabelStar (Node sommet_courant, boolean marque, double cout_realise, Arc pere, Node destination){
        super(sommet_courant, marque, cout_realise, pere);
        this.cout_distant = sommet_courant.getPoint().distanceTo(destination.getPoint());
    }


    public int compareTo(LabelStar l) {
        if ((this.getCost()+this.cout_distant) < (l.getCost()+l.cout_distant)) {
            return -1;
        } else if ((this.getCost()+this.cout_distant) == (l.getCost()+l.cout_distant)) {
            if (this.cout_distant < l.cout_distant){
                return -1;
            } else if (this.cout_distant == l.cout_distant){
                return 0;
            } else {
                return 1;
            }
            
        } else {
            return 1;
        }
    }



}
