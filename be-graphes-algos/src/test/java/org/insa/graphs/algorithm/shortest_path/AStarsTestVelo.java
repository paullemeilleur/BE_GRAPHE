package org.insa.graphs.algorithm.shortest_path;

import org.junit.Test;

public class AStarsTestVelo {
    @Test
    public void TestAStarNZ() {
        final String mapName = "/mnt/commetud/3eme Annee MIC/Graphes-et-Algorithmes/Maps/new-zealand.mapgr";
        int origine;
        int destination;

        AlgoTest test = new AlgoTest();

        System.out.println("------------------ Test de l'algorithme de AStar ------------------");

        System.out.println("Carte: Nouvelle Zelande");
        System.out.println();

        try {
            System.out.println("Cas d'un chemin simple");
            origine = 4921;
            destination = 38978;
            test.testScenarioSansBellman(mapName, origine, destination, false, 1);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenarioSansBellman");
        }

        try {
            System.out.println("Cas d'un chemin impossible");
            origine = 4965;
            destination = 183889;
            test.testScenarioSansBellman(mapName, origine, destination, false, 1);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenarioSansBellman");
        }

        try {
            System.out.println("Cas origine = Destination");
            origine = 4965;
            destination = 4965;
            test.testScenarioSansBellman(mapName, origine, destination, false, 1);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenarioSansBellman");
        }

        try {
            System.out.println("Cas d'un points inexistants");
            origine = -1;
            destination = -2;
            test.testScenarioSansBellman(mapName, origine, destination, false, 1);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenarioSansBellman");
        }

    }

    @Test
    public void TestAStarINSA() {
        final String mapName = "/mnt/commetud/3eme Annee MIC/Graphes-et-Algorithmes/Maps/insa.mapgr";
        int origine;
        int destination;

        AlgoTest test = new AlgoTest();

        System.out.println("------------------ Test de l'algorithme de AStar ------------------");

        System.out.println("Carte: insa");
        System.out.println();

        try {
            System.out.println("Cas d'un chemin simple");
            origine = 287;
            destination = 282;
            test.testScenarioSansBellman(mapName, origine, destination, false, 1);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenarioSansBellman");
        }

        try {
            System.out.println("Cas d'un chemin impossible");
            origine = 1283;
            destination = 735;
            test.testScenarioSansBellman(mapName, origine, destination, false, 1);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenarioSansBellman");
        }

        try {
            System.out.println("Cas origine = Destination");
            origine = 396;
            destination = 396;
            test.testScenarioSansBellman(mapName, origine, destination, false, 1);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenarioSansBellman");
        }

        try {
            System.out.println("Cas d'un chemin très long");
            origine = 107;
            destination = 60;
            test.testScenarioSansBellman(mapName, origine, destination, false, 1);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenarioSansBellman");
        }

        try {
            System.out.println("Cas d'un points inexistants");
            origine = -1;
            destination = -2;
            test.testScenarioSansBellman(mapName, origine, destination, false, 1);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenarioSansBellman");
        }

    }

    @Test
    public void TestAStarCD() {
        final String mapName = "/mnt/commetud/3eme Annee MIC/Graphes-et-Algorithmes/Maps/carre-dense.mapgr";
        int origine;
        int destination;

        AlgoTest test = new AlgoTest();

        System.out.println("------------------ Test de l'algorithme de AStar ------------------");

        System.out.println("Carte: Carré Dense");
        System.out.println();

        try {
            System.out.println("Cas d'un chemin long");
            origine = 244253;
            destination = 85284;
            test.testScenarioSansBellman(mapName, origine, destination, false, 1);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenarioSansBellman");
        }

        try {
            System.out.println("Cas d'un chemin simple");
            origine = 200457;
            destination = 17462;
            test.testScenarioSansBellman(mapName, origine, destination, false, 1);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenarioSansBellman");
        }

        try {
            System.out.println("Cas origine = Destination");
            origine = 17462;
            destination = 17462;
            test.testScenarioSansBellman(mapName, origine, destination, false, 1);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenarioSansBellman");
        }

        try {
            System.out.println("Cas d'un points inexistants");
            origine = -1;
            destination = -2;
            test.testScenarioSansBellman(mapName, origine, destination, false, 1);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à testScenarioSansBellman");
        }
    }
}
