package org.insa.graphs.algorithm.shortestpath;

import org.insa.graphs.algorithm.AbstractInputData.Mode;
import org.insa.graphs.model.Arc;
import org.insa.graphs.model.Graph;
import org.insa.graphs.model.Node;
import org.insa.graphs.model.Path;


public class AStarAlgorithm extends DijkstraAlgorithm {

    public AStarAlgorithm(ShortestPathData data) {
        super(data);
    }

    @Override
    protected LabelStar[] create_tab_label (int size){
        return new LabelStar[size];
    }

    @Override
    protected LabelStar create_Label (Node sommet_courant, boolean marque, double cout_realise, Arc pere){
        double estimation = sommet_courant.getPoint().distanceTo(getInputData().getDestination().getPoint());
        if (getInputData().getMode() == Mode.TIME){
            estimation = estimation/getInputData().getGraph().getGraphInformation().getMaximumSpeed();
        }
        return new LabelStar(sommet_courant, marque, cout_realise, pere, estimation);
    }
}
