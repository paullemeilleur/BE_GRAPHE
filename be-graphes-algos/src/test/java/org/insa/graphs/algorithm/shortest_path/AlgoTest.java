package org.insa.graphs.algorithm.shortest_path;

import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

import org.insa.graphs.algorithm.ArcInspector;
import org.insa.graphs.algorithm.ArcInspectorFactory;
import org.insa.graphs.algorithm.shortestpath.BellmanFordAlgorithm;
import org.insa.graphs.algorithm.shortestpath.DijkstraAlgorithm;
import org.insa.graphs.algorithm.shortestpath.ShortestPathData;
import org.insa.graphs.algorithm.shortestpath.ShortestPathSolution;
import org.insa.graphs.model.Graph;
import org.insa.graphs.model.io.BinaryGraphReader;
import org.insa.graphs.model.io.GraphReader;
import org.junit.Test;

public class AlgoTest {
    @Test
    public void testScenario(String mapName, int typeEvaluation, int origine, int destination) throws Exception {
        // public void testScenario(String mapName, int typeEvaluation, Node origine,
        // Node destination) throws Exception {

        // Create a graph reader.
        GraphReader reader = new BinaryGraphReader(
                new DataInputStream(new BufferedInputStream(new FileInputStream(mapName))));

        // Read the graph.
        Graph graph = reader.read();

        if (typeEvaluation != 0 && typeEvaluation != 1) {
            System.out.println("Argument invalide");
        } else {
            if (origine < 0 || destination < 0 || origine >= (graph.size() - 1) || destination >= (graph.size() - 1)) { // On
                                                                                                                        // est
                                                                                                                        // hors
                                                                                                                        // du
                                                                                                                        // graphe.
                                                                                                                        // /
                                                                                                                        // Sommets
                                                                                                                        // inexistants
                System.out.println("ERREUR : Paramètres invalides ");

            } else {
                ArcInspector arcInspectorDijkstra;

                if (typeEvaluation == 0) { // Temps
                    System.out.println("Mode : Temps");
                    arcInspectorDijkstra = ArcInspectorFactory.getAllFilters().get(2);
                } else {
                    System.out.println("Mode : Distance");
                    arcInspectorDijkstra = ArcInspectorFactory.getAllFilters().get(0);
                }

                // System.out.println("Chemin de la carte : "+mapName);
                System.out.println("Origine : " + origine);
                System.out.println("Destination : " + destination);

                if (origine == destination) {
                    System.out.println("Origine et Destination identiques");
                    System.out.println("Cout solution: 0");

                } else {
                    ShortestPathData data = new ShortestPathData(graph, graph.get(origine), graph.get(destination),
                            arcInspectorDijkstra);

                    BellmanFordAlgorithm B = new BellmanFordAlgorithm(data);
                    DijkstraAlgorithm D = new DijkstraAlgorithm(data);

                    // Recuperation des solutions de Bellman et Dijkstra pour comparer
                    ShortestPathSolution solution = D.run();
                    ShortestPathSolution expected = B.run();

                    if (solution.getPath() == null) {
                        assertEquals(expected.getPath(), solution.getPath());
                        System.out.println("PAS DE SOLUTION");
                        System.out.println("(infini) ");
                    }
                    // Un plus court chemin trouve
                    else {
                        double costSolution;
                        double costExpected;
                        if (typeEvaluation == 0) { // Temps
                            // Calcul du cout de la solution
                            costSolution = solution.getPath().getMinimumTravelTime();
                            costExpected = expected.getPath().getMinimumTravelTime();
                        } else {
                            costSolution = solution.getPath().getLength();
                            costExpected = expected.getPath().getLength();
                        }
                        assertEquals(costExpected, costSolution, 0.001);
                        System.out.println("Cout solution: " + costSolution);
                    }
                }
            }
        }
        System.out.println();
        System.out.println();
    }
}
