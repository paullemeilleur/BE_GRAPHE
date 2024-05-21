package org.insa.graphs.algorithm.shortest_path;

import java.io.IOException;

import org.insa.graphs.algorithm.ArcInspector;
import org.insa.graphs.algorithm.shortestpath.ShortestPathData;
import org.insa.graphs.model.Graph;
import org.insa.graphs.model.Node;
import org.junit.BeforeClass;
import org.junit.Test;

public class DijkstraTest {

    @Test
    public void TestDistanceDijkstraNZ() {
        final String mapName = "/mnt/commetud/3eme Annee MIC/Graphes-et-Algorithmes/Maps/new-zealand.mapgr";
        int origine;
        int destination;

        AlgoTest test = new AlgoTest();

        System.out.println("------------------ Test de l'algorithme de Dijkstra ------------------");
        System.out.println("Mode : Distance");
        System.out.println("Carte: Nouvelle Zelande");
        System.out.println();

        try {
            System.out.println("Cas d'un chemin simple");
            origine = 4965;
            destination = 4943;
            test.testScenario(mapName, 1, origine, destination, true,0);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenario");
        }

        try {
            System.out.println("Cas d'un chemin impossible");
            origine = 4965;
            destination = 183889;
            test.testScenario(mapName, 1, origine, destination, true,0);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenario");
        }

        try {
            System.out.println("Cas origine = Destination");
            origine = 4965;
            destination = 4965;
            test.testScenario(mapName, 1, origine, destination, true,0);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenario");
        }

        try {
            System.out.println("Cas d'un chemin très long");
            origine = 60478;
            destination = 35535;
            test.testScenario(mapName, 1, origine, destination, true,0);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenario");
        }

        try {
            System.out.println("Cas d'un points inexistants");
            origine = -1;
            destination = -2;
            test.testScenario(mapName, 1, origine, destination, true,0);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenario");
        }

    }

    @Test
    public void TestTempsDijkstraNZ() {
        final String mapName = "/mnt/commetud/3eme Annee MIC/Graphes-et-Algorithmes/Maps/new-zealand.mapgr";
        int origine;
        int destination;

        AlgoTest test = new AlgoTest();

        System.out.println("------------------ Test de l'algorithme de Dijkstra ------------------");
        System.out.println("Mode : Temps");
        System.out.println("Carte: Nouvelle Zelande");
        System.out.println();

        try {
            System.out.println("Cas d'un chemin simple");
            origine = 4965;
            destination = 4943;
            test.testScenario(mapName, 0, origine, destination, true,0);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenario");
        }

        try {
            System.out.println("Cas d'un chemin impossible");
            origine = 4965;
            destination = 183889;
            test.testScenario(mapName, 0, origine, destination, true,0);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenario");
        }

        try {
            System.out.println("Cas origine = Destination");
            origine = 4965;
            destination = 4965;
            test.testScenario(mapName, 0, origine, destination, true,0);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenario");
        }

        try {
            System.out.println("Cas d'un chemin très long");
            origine = 60478;
            destination = 35535;
            test.testScenario(mapName, 0, origine, destination, true,0);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenario");
        }

        try {
            System.out.println("Cas d'un points inexistants");
            origine = -1;
            destination = -2;
            test.testScenario(mapName, 0, origine, destination, true,0);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenario");
        }
    }

    @Test
    public void TestDistanceDijkstraINSA() {
        final String mapName = "/mnt/commetud/3eme Annee MIC/Graphes-et-Algorithmes/Maps/insa.mapgr";
        int origine;
        int destination;

        AlgoTest test = new AlgoTest();

        System.out.println("------------------ Test de l'algorithme de Dijkstra ------------------");
        System.out.println("Mode : Distance");
        System.out.println("Carte: insa");
        System.out.println();

        try {
            System.out.println("Cas d'un chemin simple");
            origine = 287;
            destination = 282;
            test.testScenario(mapName, 1, origine, destination, true,0);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenario");
        }

        try {
            System.out.println("Cas d'un chemin impossible");
            origine = 1283;
            destination = 735;
            test.testScenario(mapName, 1, origine, destination, true,0);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenario");
        }

        try {
            System.out.println("Cas origine = Destination");
            origine = 396;
            destination = 396;
            test.testScenario(mapName, 1, origine, destination, true,0);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenario");
        }

        try {
            System.out.println("Cas d'un chemin très long");
            origine = 107;
            destination = 60;
            test.testScenario(mapName, 1, origine, destination, true,0);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenario");
        }

        try {
            System.out.println("Cas d'un points inexistants");
            origine = -1;
            destination = -2;
            test.testScenario(mapName, 1, origine, destination, true,0);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenario");
        }

    }

    @Test
    public void TestTempsDijkstraINSA() {
        final String mapName = "/mnt/commetud/3eme Annee MIC/Graphes-et-Algorithmes/Maps/insa.mapgr";
        int origine;
        int destination;

        AlgoTest test = new AlgoTest();

        System.out.println("------------------ Test de l'algorithme de Dijkstra ------------------");
        System.out.println("Mode : Temps");
        System.out.println("Carte: insa");
        System.out.println();

        try {
            System.out.println("Cas d'un chemin simple");
            origine = 287;
            destination = 282;
            test.testScenario(mapName, 0, origine, destination, true,0);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenario");
        }

        try {
            System.out.println("Cas d'un chemin impossible");
            origine = 1283;
            destination = 735;
            test.testScenario(mapName, 0, origine, destination, true,0);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenario");
        }

        try {
            System.out.println("Cas origine = Destination");
            origine = 396;
            destination = 396;
            test.testScenario(mapName, 0, origine, destination, true,0);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenario");
        }

        try {
            System.out.println("Cas d'un chemin très long");
            origine = 107;
            destination = 60;
            test.testScenario(mapName, 0, origine, destination, true,0);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenario");
        }

        try {
            System.out.println("Cas d'un points inexistants");
            origine = -1;
            destination = -2;
            test.testScenario(mapName, 0, origine, destination, true,0);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenario");
        }
    }

    @Test
    public void TestDistanceDijkstraCD() {
        final String mapName = "/mnt/commetud/3eme Annee MIC/Graphes-et-Algorithmes/Maps/carre-dense.mapgr";
        int origine;
        int destination;

        AlgoTest test = new AlgoTest();

        System.out.println("------------------ Test de l'algorithme de Dijkstra ------------------");
        System.out.println("Mode : Distance");
        System.out.println("Carte: Carré Dense");
        System.out.println();

        try {
            System.out.println("Cas d'un chemin long");
            origine = 244253;
            destination = 85284;
            test.testScenario(mapName, 1, origine, destination, true,0);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenario");
        }

        try {
            System.out.println("Cas d'un chemin simple");
            origine = 200457;
            destination = 17462;
            test.testScenario(mapName, 1, origine, destination, true,0);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenario");
        }

        try {
            System.out.println("Cas origine = Destination");
            origine = 17462;
            destination = 17462;
            test.testScenario(mapName, 1, origine, destination, true,0);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenario");
        }

        try {
            System.out.println("Cas d'un points inexistants");
            origine = -1;
            destination = -2;
            test.testScenario(mapName, 1, origine, destination, true,0);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenario");
        }
    }

    @Test
    public void TestTempsDijkstraCD() {
        final String mapName = "/mnt/commetud/3eme Annee MIC/Graphes-et-Algorithmes/Maps/carre-dense.mapgr";
        int origine;
        int destination;

        AlgoTest test = new AlgoTest();

        System.out.println("------------------ Test de l'algorithme de Dijkstra ------------------");
        System.out.println("Mode : Temps");
        System.out.println("Carte: Carré Dense");
        System.out.println();

        try {
            System.out.println("Cas d'un chemin long");
            origine = 244253;
            destination = 85284;
            test.testScenario(mapName, 0, origine, destination, true,0);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenario");
        }

        try {
            System.out.println("Cas d'un chemin simple");
            origine = 200457;
            destination = 17462;
            test.testScenario(mapName, 0, origine, destination, true,0);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenario");
        }

        try {
            System.out.println("Cas origine = Destination");
            origine = 17462;
            destination = 17462;
            test.testScenario(mapName, 0, origine, destination, true,0);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenario");
        }

        try {
            System.out.println("Cas d'un points inexistants");
            origine = -1;
            destination = -2;
            test.testScenario(mapName, 0, origine, destination, true,0);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenario");
        }
    }
}
