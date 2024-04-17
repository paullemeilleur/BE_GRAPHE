package org.insa.graphs.algorithm.shortestpath;

import java.util.ArrayList;
import java.util.List;

import org.insa.graphs.algorithm.utils.BinaryHeap;
import org.insa.graphs.model.Arc;
import org.insa.graphs.model.Graph;

public class DijkstraAlgorithm extends ShortestPathAlgorithm {

    public DijkstraAlgorithm(ShortestPathData data) {
        super(data);
    }

    @Override
    protected ShortestPathSolution doRun() {

        final ShortestPathData data = getInputData();
        ShortestPathSolution solution = null;
        boolean trouve = false;

        Graph graph = data.getGraph();

        Label[] labels = new Label[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            labels[i] = new Label(graph.get(i), false, Double.POSITIVE_INFINITY, null);
        }

        BinaryHeap<Label> heapLabel = new BinaryHeap<Label>();

        Arc[] Arc_predesseurs = new Arc[graph.size()];

        labels[0] = new Label(data.getOrigin(), true, 0, null);
        heapLabel.insert(labels[0]);

        notifyOriginProcessed(data.getOrigin());

        while (!heapLabel.isEmpty() && !trouve) {

            Label x = heapLabel.deleteMin();
            x.marquer();

            if (x.get_sommet_Courant() == data.getDestination()){
                trouve = true;
            }

            

        }

        // TODO:
        return solution;
    }

}
