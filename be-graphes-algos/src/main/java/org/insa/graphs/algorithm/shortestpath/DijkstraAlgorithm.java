package org.insa.graphs.algorithm.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.insa.graphs.algorithm.AbstractSolution;
import org.insa.graphs.algorithm.utils.BinaryHeap;
import org.insa.graphs.algorithm.utils.ElementNotFoundException;
import org.insa.graphs.model.Arc;
import org.insa.graphs.model.Graph;
import org.insa.graphs.model.Path;

public class DijkstraAlgorithm extends ShortestPathAlgorithm {

    public DijkstraAlgorithm(ShortestPathData data) {
        super(data);
    }

    @Override
    protected ShortestPathSolution doRun() {

        // Retrieve the graph.
        final ShortestPathData data = getInputData();
        Graph graph = data.getGraph();

        // Variable to help us for the algorithm
        ShortestPathSolution solution = null;
        boolean trouve = false;

        // Our tab of label
        Label[] labels = new Label[graph.size()];

        // The heap
        BinaryHeap<Label> heapLabel = new BinaryHeap<Label>();

        // Initialisation
        labels[data.getOrigin().getId()] = new Label(data.getOrigin(), true, 0, null);
        heapLabel.insert(labels[data.getOrigin().getId()]);

        // Notify observers about the first event
        notifyOriginProcessed(data.getOrigin());

        // Iterations
        while (!heapLabel.isEmpty() && !trouve) {

            // Extracting the min
            Label x = heapLabel.deleteMin();
            x.marquer();

            // If we have reached the destination, then we should know it for next part
            if (x.get_sommet_Courant() == data.getDestination()) {
                trouve = true;
            }

            // Iterating over all successors
            for (Arc a : x.get_sommet_Courant().getSuccessors()) {
                

                // If it has not been marked yet
                if (labels[a.getDestination().getId()] == null) {
                    labels[a.getDestination().getId()] = new Label(a.getDestination(), false, Double.MAX_VALUE, null);
                    
                }

                Label y = labels[a.getDestination().getId()];

                // If the cost is inferior than the previous one, we change it
                if (y.getCost() > x.getCost() + data.getCost(a)) {
                    y.maj_cost(x.getCost() + data.getCost(a));
                    y.maj_pere(a);
                    try{
                        heapLabel.remove(y);
                        heapLabel.insert(y);
                    } catch (ElementNotFoundException e){
                        heapLabel.insert(y);
                    }
                    
                }
            }
        }

        System.out.println(Arrays.toString(labels));

        // If no solution is find
        if (!trouve || labels[data.getDestination().getId()] == null) {
            solution = new ShortestPathSolution(data, AbstractSolution.Status.INFEASIBLE);
        } else {
            ArrayList<Arc> list_arcs = new ArrayList<>();
            Arc arc_pere = labels[data.getDestination().getId()].get_pere();

            // Collecting the solution
            while (arc_pere != null) {
                list_arcs.add(arc_pere);
                arc_pere = labels[arc_pere.getOrigin().getId()].get_pere();
            }

            // Putting the solution in the right order
            Collections.reverse(list_arcs);

            solution = new ShortestPathSolution(data, AbstractSolution.Status.OPTIMAL, new Path(graph, list_arcs));
        }

        return solution;
    }
}
