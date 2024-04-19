package org.insa.graphs.algorithm.shortestpath;

import java.util.ArrayList;
import java.util.Collections;

import org.insa.graphs.algorithm.AbstractSolution;
import org.insa.graphs.algorithm.utils.BinaryHeap;
import org.insa.graphs.model.Arc;
import org.insa.graphs.model.Graph;
import org.insa.graphs.model.Path;

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
       // for (int i = 0; i < graph.size(); i++) {
         //   labels[i] = new Label(graph.get(i), false, Double.POSITIVE_INFINITY, null);
       // }

        BinaryHeap<Label> heapLabel = new BinaryHeap<Label>();


        labels[0] = new Label(data.getOrigin(), true, 0, null);
        heapLabel.insert(labels[0]);

        notifyOriginProcessed(data.getOrigin());

        while (!heapLabel.isEmpty() && !trouve) {

            Label x = heapLabel.deleteMin();
            x.marquer();

            if (x.get_sommet_Courant() == data.getDestination()){
                trouve = true;
            }
            for (Arc Iterator: x.get_sommet_Courant().getSuccessors()){
                    Label y=labels[Iterator.getDestination().getId()];
                    if (!y.get_marque()){
                        if(y.getCost()> x.getCost()+data.getCost(Iterator)){
                        y.maj_cost(x.getCost()+data.getCost(Iterator));
                        heapLabel.insert(y);
                        y.maj_pere(Iterator);
                } 

            

        }
    }
}
        
        if (!trouve || labels[data.getDestination().getId()] == null || data.getDestination().getId()==data.getOrigin().getId())   {
                solution = new ShortestPathSolution(data,AbstractSolution.Status.INFEASIBLE); 

        }  
        else{
            ArrayList<Arc> list_arcs = new ArrayList<>() ;
            Arc arc_pere = labels[data.getDestination().getId()].get_pere();
            while (arc_pere != null){
                list_arcs.add(arc_pere);
                arc_pere = labels[arc_pere.getOrigin().getId()].get_pere(); 

            }  
            Collections.reverse (list_arcs) ;
            solution = new ShortestPathSolution(data,AbstractSolution.Status.OPTIMAL, new Path(graph,list_arcs));
        } 

        return solution;
    }
}






