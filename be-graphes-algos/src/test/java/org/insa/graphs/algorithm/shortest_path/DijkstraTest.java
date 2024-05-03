package org.insa.graphs.algorithm.shortest_path;

import static org.junit.Assert.assertEquals;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.insa.graphs.algorithm.ArcInspector;
import org.insa.graphs.algorithm.shortestpath.ShortestPathData;
import org.insa.graphs.model.Arc;
import org.insa.graphs.model.Graph;
import org.insa.graphs.model.Node;
import org.insa.graphs.model.Path;
import org.insa.graphs.model.RoadInformation;
import org.insa.graphs.model.RoadInformation.RoadType;
import org.insa.graphs.model.io.BinaryGraphReader;
import org.insa.graphs.model.io.GraphReader;
import org.junit.BeforeClass;
import org.junit.Test;
import org.insa.graphs.algorithm.shortestpath.DijkstraAlgorithm;

public class DijkstraTest {

    private static Graph graph;

    private static Node[] nodes;

    static private ShortestPathData dataFaisable1;
    static private ShortestPathData dataFaisable2;
    static private ShortestPathData dataInfaisable1;
    static private ShortestPathData dataInfaisable2;

    static private ArcInspector inspector;


    @BeforeClass
    public static void initAll() throws IOException {

        // Visit these directory to see the list of available files on Commetud.
        final String mapName = "/mnt/commetud/3eme Annee MIC/Graphes-et-Algorithmes/Maps/new-zealand.mapgr";

        // Create a graph reader.
        final GraphReader reader = new BinaryGraphReader(
                new DataInputStream(new BufferedInputStream(new FileInputStream(mapName))));

        // Read the graph.
        graph = reader.read();

        nodes = new Node[6];

        // Nodes composante connexe 1
        nodes[0] = graph.get(239394);

        // Nodes composante connexe 2
        nodes[1] = graph.get(19453);

        // Nodes accessible que à pied ? / composante connexe 2
        nodes[2] = graph.get(84722);

        // Composante connexe 2
        nodes[3] = graph.get(108024);

        // Composante connexe 1
        nodes[4] = graph.get(340716);

        // Composante connexe 1 / accessible que à pied ?
        nodes[5] = graph.get(152714);
        


        dataFaisable1 = new ShortestPathData(graph, nodes[0], nodes[4], inspector);
        dataFaisable2 = new ShortestPathData(graph, nodes[1], nodes[3], inspector);
        dataInfaisable1 = new ShortestPathData(graph, nodes[1], nodes[4], inspector);
        dataInfaisable2 = new ShortestPathData(graph, nodes[1], nodes[2], inspector);

    }



    @Test
    public void testPathFound() {
        assertEquals(0, );
        assertEquals(1, singleNodePath.size());
        assertEquals(4, shortPath.size());
        assertEquals(5, longPath.size());
        assertEquals(5, loopPath.size());
        assertEquals(10, longLoopPath.size());
    }

}


