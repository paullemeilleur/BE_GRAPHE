package org.insa.graphs.algorithm.shortest_path;

import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

import org.insa.graphs.algorithm.ArcInspector;
import org.insa.graphs.algorithm.ArcInspectorFactory;
import org.insa.graphs.algorithm.shortestpath.AStarAlgorithm;
import org.insa.graphs.algorithm.shortestpath.BellmanFordAlgorithm;
import org.insa.graphs.algorithm.shortestpath.DijkstraAlgorithm;
import org.insa.graphs.algorithm.shortestpath.ShortestPathData;
import org.insa.graphs.algorithm.shortestpath.ShortestPathSolution;
import org.insa.graphs.model.Graph;
import org.insa.graphs.model.io.BinaryGraphReader;
import org.insa.graphs.model.io.GraphReader;
import org.junit.Test;

public class AlgoTest {

    public void testScenario(String mapName, int typeEvaluation, int origine, int destination, boolean Dijkstra,
            int vehicles)
            throws Exception { // si vehicles = 0 --> cars, si = 1 --> bicycle

        GraphReader reader = new BinaryGraphReader(
                new DataInputStream(new BufferedInputStream(new FileInputStream(mapName))));

        BellmanFordAlgorithm B;
        AStarAlgorithm A;
        DijkstraAlgorithm D;
        ShortestPathSolution Attendu;
        ShortestPathSolution Obtenu;

        Graph graph = reader.read();

        if (typeEvaluation != 0 && typeEvaluation != 1) {
            System.out.println("Argument invalide");
        } else {
            if (origine < 0 || destination < 0 || origine >= (graph.size() - 1) || destination >= (graph.size() - 1)) {
                System.out.println("ERREUR : Paramètres invalides ");

            } else {
                ArcInspector arcInspectorDijkstra;

                if (typeEvaluation == 0) { // Temps
                    System.out.println("Mode : Temps");
                    if (vehicles == 0) {
                        arcInspectorDijkstra = ArcInspectorFactory.getAllFilters().get(2);
                    } else if (vehicles == 1) {
                        arcInspectorDijkstra = ArcInspectorFactory.getAllFilters().get(3);
                    } else {
                        System.err.println("Par défaut, tous les arcs sont autorisés\n");
                        arcInspectorDijkstra = ArcInspectorFactory.getAllFilters().get(0);
                    }

                } else {
                    System.out.println("Mode : Distance");
                    if (vehicles == 0) {
                        arcInspectorDijkstra = ArcInspectorFactory.getAllFilters().get(1);
                    } else if (vehicles == 1) {
                        arcInspectorDijkstra = ArcInspectorFactory.getAllFilters().get(4);
                    } else {
                        System.err.println("Par défaut, tous les arcs sont autorisés\n");
                        arcInspectorDijkstra = ArcInspectorFactory.getAllFilters().get(0);
                    }

                }

                System.out.println("Origine : " + origine);
                System.out.println("Destination : " + destination);

                if (origine == destination) {
                    System.out.println("Origine et Destination identiques");
                    System.out.println("Cout Solution: 0");

                } else {
                    ShortestPathData data = new ShortestPathData(graph, graph.get(origine), graph.get(destination),
                            arcInspectorDijkstra);
                    if (Dijkstra) {
                        B = new BellmanFordAlgorithm(data);
                        D = new DijkstraAlgorithm(data);

                        Obtenu = D.run();
                        Attendu = B.run();
                    } else {
                        B = new BellmanFordAlgorithm(data);
                        A = new AStarAlgorithm(data);

                        Obtenu = A.run();
                        Attendu = B.run();
                    }
                    if (Obtenu.getPath() == null) {
                        assertEquals(Attendu.getPath(), Obtenu.getPath());
                        System.out.println("PAS DE SOLUTION");
                        System.out.println("(infini) ");
                    }

                    else {
                        double costSolution;
                        double costExpected;
                        if (typeEvaluation == 0) { // Temps

                            costSolution = Obtenu.getPath().getMinimumTravelTime();
                            costExpected = Attendu.getPath().getMinimumTravelTime();
                        } else {
                            costSolution = Obtenu.getPath().getLength();
                            costExpected = Attendu.getPath().getLength();
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

    @Test
    public void testScenarioSansBellman(String mapName, int origine, int destination, boolean Dijkstra, int vehicles)
            throws Exception {

        double fastesttimecost = Double.POSITIVE_INFINITY;
        double fastestdistancecost = Double.POSITIVE_INFINITY;
        double shortesttimecost = Double.POSITIVE_INFINITY;
        double shortestdistancecost = Double.POSITIVE_INFINITY;

        AStarAlgorithm A;
        DijkstraAlgorithm D;
        ShortestPathSolution Obtenu;

        // Create a graph reader.
        GraphReader reader = new BinaryGraphReader(
                new DataInputStream(new BufferedInputStream(new FileInputStream(mapName))));

        // Read the graph.
        Graph graph = reader.read();

        if (origine < 0 || destination < 0 || origine >= (graph.size() - 1) || destination >= (graph.size() - 1)) {
            System.out.println("erreur de paramètres");

        } else {
            System.out.println("Origine : " + origine);
            System.out.println("Destination : " + destination);

            if (origine == destination) {
                System.out.println("Origine et Destination identiques");
                System.out.println("Tous les couts sont à 0.");

            } else {

                /** Recherche du chemin le plus rapide **/
                ArcInspector arcInspectorDijkstra;
                if (vehicles == 0) {
                    arcInspectorDijkstra = ArcInspectorFactory.getAllFilters().get(2);
                } else if (vehicles == 1) {
                    arcInspectorDijkstra = ArcInspectorFactory.getAllFilters().get(3);
                } else {
                    System.err.println("Par défaut, tous les arcs sont autorisés\n");
                    arcInspectorDijkstra = ArcInspectorFactory.getAllFilters().get(0);
                }

                ShortestPathData data = new ShortestPathData(graph, graph.get(origine), graph.get(destination),
                        arcInspectorDijkstra);

                if (Dijkstra) {
                    D = new DijkstraAlgorithm(data);
                    Obtenu = D.run();
                } else {
                    A = new AStarAlgorithm(data);
                    Obtenu = A.run();
                }

                if (Obtenu.getPath() == null) {
                    System.out.println("Pas de solution en temps");
                } else {
                    fastesttimecost = Obtenu.getPath().getMinimumTravelTime();
                    fastestdistancecost = Obtenu.getPath().getLength();
                }

                /** Recherche du chemin le plus court **/
                
                if (vehicles == 0) {
                    arcInspectorDijkstra = ArcInspectorFactory.getAllFilters().get(1);
                } else if (vehicles == 1) {
                    arcInspectorDijkstra = ArcInspectorFactory.getAllFilters().get(4);
                } else {
                    System.err.println("Par défaut, tous les arcs sont autorisés\n");
                    arcInspectorDijkstra = ArcInspectorFactory.getAllFilters().get(0);
                }

                
                data = new ShortestPathData(graph, graph.get(origine), graph.get(destination), arcInspectorDijkstra);

                if (Dijkstra) {
                    D = new DijkstraAlgorithm(data);
                    Obtenu = D.run();
                } else {
                    A = new AStarAlgorithm(data);
                    Obtenu = A.run();
                }

                /* Pas de chemin trouve */
                if (Obtenu.getPath() == null) {
                    System.out.println("pas de solution en distance");
                }
                /* Un plus court chemin trouve */
                else {
                    /* Calcul du cout de la solution (en temps et en distance) */
                    shortesttimecost = Obtenu.getPath().getMinimumTravelTime();
                    shortestdistancecost = Obtenu.getPath().getLength();
                }

                /*
                 * Verifie que le temps du chemin le plus rapide est inferieur au temps du
                 * chemin le plus court
                 */
                assertTrue(fastesttimecost <= shortesttimecost);
                System.out.println("Cout en temps du chemin le plus rapide : " + fastesttimecost);
                System.out.println("Cout en temps du chemin le plus court  : " + shortesttimecost);

                /*
                 * Et verifie que la distance du chemin le plus rapide est superieur a la
                 * distance du chemin le plus court
                 */
                assertTrue(fastestdistancecost >= shortestdistancecost);
                System.out.println("Cout en distance du chemin le plus rapide : " + fastestdistancecost);
                System.out.println("Cout en distance du chemin le plus court  : " + shortestdistancecost);

            }
        }
        System.out.println();
        System.out.println();
    }

}
