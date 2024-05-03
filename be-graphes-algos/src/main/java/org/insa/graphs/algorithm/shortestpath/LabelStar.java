package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.model.Arc;
import org.insa.graphs.model.Node;

public class LabelStar extends Label {

    private double cout_distant;

    public LabelStar(Node sommet_courant, boolean marque, double cout_realise, Arc pere, double cout_distant) {
        super(sommet_courant, marque, cout_realise, pere);
        this.cout_distant = cout_distant; 
    }



    @Override
    public double get_total_Cost() {
        return this.get_Cost() + this.cout_distant;
    }

}
