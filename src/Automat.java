import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Automat {
    private int repetitions;

    public Automat(int repetitions) {
        this.repetitions = repetitions;
    }

    public void runEaResearch(String testFileName) throws IOException {
        Loader loader = new Loader();
        //loader.load("test");
        loader.load(testFileName);
        Problem problem = new Problem(
                loader.getLoadedDimension(),
                loader.getLoadedCapacity(),
                loader.getLoadedDemandArray());
        problem.calculateDistance(loader.getLoadedCoordXArray(), loader.getLoadedCoordYArray());

        File file;
        PrintWriter average;

        //selection: 1 - tour, 2 - roulette, crossover: 1 - ox, 2 - pmx, mutation: 1 - swap, 2 - inversion

//        file = new File("average_ox_tournament_inversion.csv");
//        file.createNewFile();
//        average = new PrintWriter("average_ox_tournament_inversion.csv");
//
//        // px - {0.1, 0.2, 0.3,..., 1} - orderedCrossover - with tournament and inversion
//        for (float j = 0.1f; j <= 1.01; j += 0.1f) {
//            for (int i = 0; i < repetitions; i++) {
//                EvolutionAlgorithm ea = new EvolutionAlgorithm(100, 100, j, 0.1f, 5, problem);
//                Individual bestIndividual = ea.startEvolution(1, 1, 2, "100_100_" + j + "_0.1f_5", average, i);
//                System.out.println("Ox");
//                bestIndividual.printRouteArray();
//                System.out.println(bestIndividual.getFitness());
//            }
//        }
//        average.close();
//
//
//        file = new File("average_pmx_tournament_inversion.csv");
//        file.createNewFile();
//        average = new PrintWriter("average_pmx_tournament_inversion.csv");
//
//        // px - {0.1, 0.2, 0.3,..., 1} - partiallyMatchedCrossover - with tournament and inversion
//        for (float j = 0.1f; j <= 1.01; j += 0.1f) {
//            for (int i = 0; i < repetitions; i++) {
//                EvolutionAlgorithm ea = new EvolutionAlgorithm(100, 100, j, 0.1f, 5, problem);
//                Individual bestIndividual = ea.startEvolution(1, 2, 2, "result", average, i);
//                System.out.println("Pmx");
//                bestIndividual.printRouteArray();
//                System.out.println(bestIndividual.getFitness());
//            }
//        }
//        average.close();
//
//
//        file = new File("average_inversion_tournament_pmx.csv");
//        file.createNewFile();
//        average = new PrintWriter("average_inversion_tournament_pmx.csv");
//
//        // pm - {0.1, 0.2, 0.3,..., 1} - inversion - with tournament and pmx
//        for (float j = 0.01f; j <= 0.3f; j += 0.005f) {
//            for (int i = 0; i < repetitions; i++) {
//                EvolutionAlgorithm ea = new EvolutionAlgorithm(100, 100, 0.7f, j, 5, problem);
//                Individual bestIndividual = ea.startEvolution(1, 2, 2, "result", average, i);
//                System.out.println("inversion");
//                bestIndividual.printRouteArray();
//                System.out.println(bestIndividual.getFitness());
//            }
//        }
//        average.close();
//
//
//        file = new File("average_swap_tournament_pmx.csv");
//        file.createNewFile();
//        average = new PrintWriter("average_swap_tournament_pmx.csv");
//
//        // pm - {0.01, 0.02, 0.03,..., 0.1} - swap - with tournament and pmx
//        for (float j = 0.001f; j <= 0.016f; j += 0.0005f) {
//            for (int i = 0; i < repetitions; i++) {
//                EvolutionAlgorithm ea = new EvolutionAlgorithm(100, 100, 0.7f, j, 5, problem);
//                Individual bestIndividual = ea.startEvolution(1, 2, 1, "result", average, i);
//                System.out.println("Swap");
//                bestIndividual.printRouteArray();
//                System.out.println(bestIndividual.getFitness());
//            }
//        }
//        average.close();
//
//
//        file = new File("average_tournament_pmx_inversion.csv");
//        file.createNewFile();
//        average = new PrintWriter("average_tournament_pmx_inversion.csv");
//
//        // tour - {1, 3, 5, 7, 9, 11, 13, 15, 17, N} - with pmx and inversion
//        for (int i = 0; i < repetitions; i++) {
//            for (int j = 1; j <= 17; j += 2) {
//                EvolutionAlgorithm ea = new EvolutionAlgorithm(100, 100, 0.7f, 0.1f, j, problem);
//                Individual bestIndividual = ea.startEvolution(1, 2, 2, "result", average, i);
//                System.out.println("Tournament");
//                bestIndividual.printRouteArray();
//                System.out.println(bestIndividual.getFitness());
//            }
//            EvolutionAlgorithm ea = new EvolutionAlgorithm(100, 100, 0.7f, 0.1f, problem.getDimension() - 1, problem);
//            Individual bestIndividual = ea.startEvolution(1, 2, 2, "result", average, i);
//            bestIndividual.printRouteArray();
//            System.out.println(bestIndividual.getFitness());
//        }
//        average.close();
//
//
//        file = new File("average_roulette_pmx_inversion.csv");
//        file.createNewFile();
//        average = new PrintWriter("average_roulette_pmx_inversion.csv");
//
//        // roulette - with pmx and inversion
//        for (int i = 0; i < repetitions; i++) {
//            EvolutionAlgorithm ea = new EvolutionAlgorithm(100, 100, 0.7f, 0.1f, 5, problem);
//            Individual bestIndividual = ea.startEvolution(2, 2, 2, "result", average, i);
//            System.out.println("Roulette: " + i);
//            bestIndividual.printRouteArray();
//            System.out.println(bestIndividual.getFitness());
//        }
//        average.close();
        file = new File("average_pop_size_ox_tournament_inversion.csv");
        file.createNewFile();
        average = new PrintWriter("average_pop_size_ox_tournament_inversion.csv");

        // pop_size - {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000} - orderedCrossover, tournament and inversion
        for (int j = 100; j <= 1000; j += 50) {
            for (int i = 0; i < repetitions; i++) {
                EvolutionAlgorithm ea = new EvolutionAlgorithm(j, 100, 0.7f, 0.1f, 5, problem);
                Individual bestIndividual = ea.startEvolution(1, 1, 2, j + "_100_0.7f_0.1f_5", average, i);
                //System.out.println("pop_size");
                //bestIndividual.printRouteArray();
                //System.out.println(bestIndividual.getFitness());
            }
        }
        average.close();

        file = new File("average_gen_ox_tournament_inversion.csv");
        file.createNewFile();
        average = new PrintWriter("average_gen_ox_tournament_inversion.csv");

        // gen - {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000} - orderedCrossover, tournament and inversion
        for (int j = 100; j <= 1000; j += 50) {
            for (int i = 0; i < repetitions; i++) {
                EvolutionAlgorithm ea = new EvolutionAlgorithm(100, j, 0.7f, 0.1f, 5, problem);
                Individual bestIndividual = ea.startEvolution(1, 1, 2, "100_" + j + "_0.7f_0.1f_5", average, i);
                //System.out.println("gen");
                //bestIndividual.printRouteArray();
                //System.out.println(bestIndividual.getFitness());
            }
        }
        average.close();
    }
}
