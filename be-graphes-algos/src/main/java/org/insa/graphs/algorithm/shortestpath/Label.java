package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.model.Arc;
import org.insa.graphs.model.Node;

public class Label implements Comparable<Label> {
    private Node sommet_courant;
    private boolean marque;
    private double cout_realise;
    private Arc pere;

    public Label(Node sommet_courant, boolean marque, double cout_realise, Arc pere) {
        this.sommet_courant = sommet_courant;
        this.marque = marque;
        this.cout_realise = cout_realise;
        this.pere = pere;
    }

    public Node get_sommet_Courant() {
        return this.sommet_courant;

    }

    public Boolean get_marque() {
        return this.marque;

    }

    public double get_Cost() {
        return this.cout_realise;

    }

    public Arc get_pere() {
        return this.pere;

    }

    public int compareTo(Label l) {
        if (this.cout_realise < l.cout_realise) {
            return -1;
        } else if (this.cout_realise == l.cout_realise) {
            return 0;
        } else {
            return 1;
        }
    }

    public double get_total_Cost() {
        return this.cout_realise;

    }



    public void marquer() {
        this.marque = true;
    }

    public void maj_cost(double i) {
        this.cout_realise = i;
    }

    public void maj_pere(Arc a) {
        this.pere = a;
    }

}
