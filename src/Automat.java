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


//        file = new File(testFileName + "_average_popsizexgen.csv");
//        file.createNewFile();
//        average = new PrintWriter(testFileName + "_average_popsizexgen.csv");
//
//        for (int i = 100; i <= 1000; i += 50) {
//            for (int j = 100; j <= 1000; j += 50) {
//                System.out.println("Pop, gen, tour: " + i + ", " + j + ", " + ((int) (0.2f * i)));
//                EvolutionAlgorithm ea = new EvolutionAlgorithm(i, j, 0.7f, 0.1f, ((int) (0.2f * i)), problem);
//                for (int k = 0; k < repetitions; k++) {
//                    Individual bestIndividual = ea.startEvolution(1, 1, 2, i + "_" + j + "_0.7f_0.1f_" + ((int) (0.2 * i)), average, k);
//                    System.out.println(k);
//                    //bestIndividual.printRouteArray();
//                    //System.out.println(bestIndividual.getFitness());
//                }
//            }
//        }
//        average.close();


//        file = new File(testFileName + "_average_tour.csv");
//        file.createNewFile();
//        average = new PrintWriter(testFileName + "_average_tour.csv");
//
//        for (int j = 5; j <= 100; j += 5) {
//            EvolutionAlgorithm ea = new EvolutionAlgorithm(450, 950, 0.7f, 0.1f, (int) (j * 450 / 100), problem);
//            System.out.println("Tour: " + (int) (j * 450 / 100));
//            for (int k = 0; k < 10; k++) {
//                Individual bestIndividual = ea.startEvolution(1, 1, 2, "450_950_0.7f_0.1f_" + (int) (j * 450 / 100), average, k);
//                System.out.println(k);
//                //bestIndividual.printRouteArray();
//                //System.out.println(bestIndividual.getFitness());
//            }
//        }
//        average.close();

//        file = new File(testFileName + "_average_zoomed_tour.csv");
//        file.createNewFile();
//        average = new PrintWriter(testFileName + "_average_zoomed_tour.csv");
//
//        for (int j = 35; j <= 65; j += 1) {
//            EvolutionAlgorithm ea = new EvolutionAlgorithm(450, 950, 0.7f, 0.1f, (int) (j * 450 / 100), problem);
//            System.out.println("Tour: " + j);
//            for (int k = 0; k < 10; k++) {
//                Individual bestIndividual = ea.startEvolution(1, 1, 2, "450_950_0.7f_0.1f_" + (int) (j * 450 / 100), average, k);
//                System.out.println(k);
//                //bestIndividual.printRouteArray();
//                //System.out.println(bestIndividual.getFitness());
//            }
//        }
//        average.close();

        // kolejne Toury = {139, 99, 90, 175, 112, 202, 229}
        // kolejne Px    = {0,55 - 0,9; 0,55 - 1; 0,5 - 0,95; 0,55 - 0,95; 0,5 - 0,9; 0,65 - 1; 0,45 - 0,9}
        // wybrane Px    = {0.71, 0.75, 0.75, 0.65, 0.69, 0.78, 0.77}
        switch (testFileName) {
            case "A-n32-k5":
                file = new File(testFileName + "_average_pm.csv");
                file.createNewFile();
                average = new PrintWriter(testFileName + "_average_pm.csv");

                for (float i = 0.01f; i <= 0.36f; i += 0.01f) {
                    EvolutionAlgorithm ea = new EvolutionAlgorithm(450, 950, 0.71f, i, 139, problem);
                    System.out.println("Px: " + i);
                    for (int k = 0; k < 10; k++) {
                        Individual bestIndividual = ea.startEvolution(1, 1, 2, "450_950_0.71f_" + i + "_139", average, k);
                        System.out.println(k);
                    }
                }
                average.close();
                break;
            case "A-n37-k6":
                file = new File(testFileName + "_average_pm.csv");
                file.createNewFile();
                average = new PrintWriter(testFileName + "_average_pm.csv");

                for (float i = 0.01f; i <= 0.36f; i += 0.01f) {
                    EvolutionAlgorithm ea = new EvolutionAlgorithm(450, 950, 0.75f, i, 99, problem);
                    System.out.println("Px: " + i);
                    for (int k = 0; k < 10; k++) {
                        Individual bestIndividual = ea.startEvolution(1, 1, 2, "450_950_0.75f_" + i + "_99", average, k);
                        System.out.println(k);
                    }
                }
                average.close();
                break;
            case "A-n39-k5":
                file = new File(testFileName + "_average_pm.csv");
                file.createNewFile();
                average = new PrintWriter(testFileName + "_average_pm.csv");

                for (float i = 0.01f; i <= 0.36f; i += 0.01f) {
                    EvolutionAlgorithm ea = new EvolutionAlgorithm(450, 950, 0.75f, i, 90, problem);
                    System.out.println("Px: " + i);
                    for (int k = 0; k < 10; k++) {
                        Individual bestIndividual = ea.startEvolution(1, 1, 2, "450_950_0.75f_" + i + "_90", average, k);
                        System.out.println(k);
                    }
                }
                average.close();
                break;
            case "A-n45-k6":
                file = new File(testFileName + "_average_pm.csv");
                file.createNewFile();
                average = new PrintWriter(testFileName + "_average_pm.csv");

                for (float i = 0.01f; i <= 0.36f; i += 0.01f) {
                    EvolutionAlgorithm ea = new EvolutionAlgorithm(450, 950, 0.65f, i, 175, problem);
                    System.out.println("Px: " + i);
                    for (int k = 0; k < 10; k++) {
                        Individual bestIndividual = ea.startEvolution(1, 1, 2, "450_950_0.65f_" + i + "_175", average, k);
                        System.out.println(k);
                    }
                }
                average.close();
                break;
            case "A-n48-k7":
                file = new File(testFileName + "_average_pm.csv");
                file.createNewFile();
                average = new PrintWriter(testFileName + "_average_pm.csv");

                for (float i = 0.01f; i <= 0.36f; i += 0.01f) {
                    EvolutionAlgorithm ea = new EvolutionAlgorithm(450, 950, 0.69f, i, 112, problem);
                    System.out.println("Px: " + i);
                    for (int k = 0; k < 10; k++) {
                        Individual bestIndividual = ea.startEvolution(1, 1, 2, "450_950_0.69f_" + i + "_112", average, k);
                        System.out.println(k);
                    }
                }
                average.close();
                break;
            case "A-n54-k7":
                file = new File(testFileName + "_average_pm.csv");
                file.createNewFile();
                average = new PrintWriter(testFileName + "_average_pm.csv");

                for (float i = 0.01f; i <= 0.36f; i += 0.01f) {
                    EvolutionAlgorithm ea = new EvolutionAlgorithm(450, 950, 0.78f, i, 202, problem);
                    System.out.println("Px: " + i);
                    for (int k = 0; k < 10; k++) {
                        Individual bestIndividual = ea.startEvolution(1, 1, 2, "450_950_0.78f_" + i + "_202", average, k);
                        System.out.println(k);
                    }
                }
                average.close();
                break;
            case "A-n60-k9":
                file = new File(testFileName + "_average_pm.csv");
                file.createNewFile();
                average = new PrintWriter(testFileName + "_average_pm.csv");

                for (float i = 0.01f; i <= 0.36f; i += 0.01f) {
                    EvolutionAlgorithm ea = new EvolutionAlgorithm(450, 950, 0.77f, i, 229, problem);
                    System.out.println("Px: " + i);
                    for (int k = 0; k < 10; k++) {
                        Individual bestIndividual = ea.startEvolution(1, 1, 2, "450_950_0.77f_" + i + "_229", average, k);
                        System.out.println(k);
                    }
                }
                average.close();
                break;
        }
//        file = new File(testFileName + "_average_zoomed_pxxtour.csv");
//        file.createNewFile();
//        average = new PrintWriter(testFileName + "_average_zoomed_pxxtour.csv");
//
//        for (float i = 0.55f; i <= 0.91f; i += 0.01f) {
//            EvolutionAlgorithm ea = new EvolutionAlgorithm(450, 950, i, 0.1f, 139, problem);
//            System.out.println("Px: " + i);
//            for (int k = 0; k < 10; k++) {
//                Individual bestIndividual = ea.startEvolution(1, 1, 2, "450_950_" + i + "_0.1f_139", average, k);
//                System.out.println(k);
//            }
//        }
//        average.close();


        //--------------------------------------------------------------------------------------------------------------------------------------

        //selection: 1 - tour, 2 - roulette, crossover: 1 - ox, 2 - pmx, mutation: 1 - swap, 2 - inversion

//        file = new File("average_ox_tournament_inversion.csv");
//        file.createNewFile();
//        average = new PrintWriter("average_ox_tournament_inversion.csv");
//
//        // px - {0.1, 0.2, 0.3,..., 1} - orderedCrossover - with tournament and inversion
//        for (float j = 0.1f; j <= 1.01; j += 0.05f) {
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
//        for (float j = 0.1f; j <= 1.01; j += 0.05f) {
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
//        for (int j = 1; j <= 100; j += 1) {
//            for (int i = 0; i < repetitions; i++) {
//                EvolutionAlgorithm ea = new EvolutionAlgorithm(100, 100, 0.7f, 0.1f, j, problem);
//                Individual bestIndividual = ea.startEvolution(1, 2, 2, "result", average, i);
//                System.out.println("Tournament");
//                bestIndividual.printRouteArray();
//                System.out.println(bestIndividual.getFitness());
//            }
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
//
//        file = new File("average_pop_size_ox_tournament_inversion.csv");
//        file.createNewFile();
//        average = new PrintWriter("average_pop_size_ox_tournament_inversion.csv");
//
//        // pop_size - {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000} - orderedCrossover, tournament and inversion
//        for (int j = 100; j <= 1000; j += 50) {
//            for (int i = 0; i < repetitions; i++) {
//                EvolutionAlgorithm ea = new EvolutionAlgorithm(j, 100, 0.7f, 0.1f, 5, problem);
//                Individual bestIndividual = ea.startEvolution(1, 1, 2, j + "_100_0.7f_0.1f_5", average, i);
//                //System.out.println("pop_size");
//                //bestIndividual.printRouteArray();
//                //System.out.println(bestIndividual.getFitness());
//            }
//        }
//        average.close();
//
//        file = new File("average_gen_ox_tournament_inversion.csv");
//        file.createNewFile();
//        average = new PrintWriter("average_gen_ox_tournament_inversion.csv");
//
//        // gen - {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000} - orderedCrossover, tournament and inversion
//        for (int j = 100; j <= 1000; j += 50) {
//            for (int i = 0; i < repetitions; i++) {
//                EvolutionAlgorithm ea = new EvolutionAlgorithm(100, j, 0.7f, 0.1f, 5, problem);
//                Individual bestIndividual = ea.startEvolution(1, 1, 2, "100_" + j + "_0.7f_0.1f_5", average, i);
//                //System.out.println("gen");
//                //bestIndividual.printRouteArray();
//                //System.out.println(bestIndividual.getFitness());
//            }
//        }
//        average.close();
//        file = new File("1x_ox_roulette_inversion.csv");
//        file.createNewFile();
//        average = new PrintWriter("1x_ox_roulette_inversion.csv");
//
//        // gen - {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000} - orderedCrossover, tournament and inversion
//
//        for (int i = 0; i < repetitions; i++) {
//            EvolutionAlgorithm ea = new EvolutionAlgorithm(100, 100, 0.7f, 0.1f, 5, problem);
//            Individual bestIndividual = ea.startEvolution(2, 1, 2, "OneRunRoulette", average, i);
//            //System.out.println("gen");
//            //bestIndividual.printRouteArray();
//            //System.out.println(bestIndividual.getFitness());
//        }
//
//
//        average.close();
//        file = new File("1x_ox_tournament_inversion.csv");
//        file.createNewFile();
//        average = new PrintWriter("1x_ox_tournament_inversion.csv");
//
//        // gen - {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000} - orderedCrossover, tournament and inversion
//
//        for (int i = 0; i < repetitions; i++) {
//            EvolutionAlgorithm ea = new EvolutionAlgorithm(100, 100, 0.7f, 0.1f, 5, problem);
//            Individual bestIndividual = ea.startEvolution(1, 1, 2, "OneRunTournament", average, i);
//            //System.out.println("gen");
//            //bestIndividual.printRouteArray();
//            //System.out.println(bestIndividual.getFitness());
//        }
//
//        average.close();
    }

    public void runTSResearch(String testFileName) throws IOException {
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


//        file = new File(testFileName + "_average_nsize.csv");
//        file.createNewFile();
//        average = new PrintWriter(testFileName + "_average_nsize.csv");
//        int range = (problem.getDimension() * (problem.getDimension() - 1)) / 2 - 50;
//        System.out.println("Range: " + range);
//        // nsize - 10 - dim*(dim - 1)/2 - 50
//        for (int j = 10; j <= range; j++) {
//            System.out.println("N size: " + j);
//            for (int i = 0; i < repetitions; i++) {
//                System.out.println(i);
//                TabuSearch ts = new TabuSearch(1000, j, 100, problem);
//                Individual bestIndividual = ts.startSearch(1, 1, "greedy_inversion_nsize", average, i);
//            }
//        }
//        average.close();

        switch (testFileName) {
            case "A-n32-k5":
                file = new File(testFileName + "_average_tabusize.csv");
                file.createNewFile();
                average = new PrintWriter(testFileName + "_average_tabusize.csv");
                for (int j = 1; j <= 16; j++) {
                    System.out.println("Tabu size: " + j);
                    for (int i = 0; i < repetitions; i++) {
                        System.out.println(i);
                        TabuSearch ts = new TabuSearch(10000, 32, j, problem);
                        Individual bestIndividual = ts.startSearch(1, 1, "greedy_inversion_nsize", average, i);
                    }
                }
                average.close();
                break;
            case "A-n37-k6":
                file = new File(testFileName + "_average_tabusize.csv");
                file.createNewFile();
                average = new PrintWriter(testFileName + "_average_tabusize.csv");
                // nsize - 10 - dim*(dim - 1)/2 - 50
                for (int j = 12; j <= 19; j++) {
                    System.out.println("Tabu size: " + j);
                    for (int i = 0; i < repetitions; i++) {
                        System.out.println(i);
                        TabuSearch ts = new TabuSearch(10000, 37, j, problem);
                        Individual bestIndividual = ts.startSearch(1, 1, "greedy_inversion_nsize", average, i);
                    }
                }
                average.close();
                break;
            case "A-n39-k5":
                file = new File(testFileName + "_average_tabusize.csv");
                file.createNewFile();
                average = new PrintWriter(testFileName + "_average_tabusize.csv");
                // nsize - 10 - dim*(dim - 1)/2 - 50
                for (int j = 13; j <= 20; j++) {
                    System.out.println("Tabu size: " + j);
                    for (int i = 0; i < repetitions; i++) {
                        System.out.println(i);
                        TabuSearch ts = new TabuSearch(10000, 39, j, problem);
                        Individual bestIndividual = ts.startSearch(1, 1, "greedy_inversion_nsize", average, i);
                    }
                }
                average.close();
                break;
            case "A-n45-k6":
                file = new File(testFileName + "_average_tabusize.csv");
                file.createNewFile();
                average = new PrintWriter(testFileName + "_average_tabusize.csv");
                // nsize - 10 - dim*(dim - 1)/2 - 50
                for (int j = 1; j <= 23; j++) {
                    System.out.println("Tabu size: " + j);
                    for (int i = 0; i < repetitions; i++) {
                        System.out.println(i);
                        TabuSearch ts = new TabuSearch(10000, 45, j, problem);
                        Individual bestIndividual = ts.startSearch(1, 1, "greedy_inversion_nsize", average, i);
                    }
                }
                average.close();
                break;
            case "A-n48-k7":
                file = new File(testFileName + "_average_tabusize.csv");
                file.createNewFile();
                average = new PrintWriter(testFileName + "_average_tabusize.csv");
                // nsize - 10 - dim*(dim - 1)/2 - 50
                for (int j = 1; j <= 24; j++) {
                    System.out.println("Tabu size: " + j);
                    for (int i = 0; i < repetitions; i++) {
                        System.out.println(i);
                        TabuSearch ts = new TabuSearch(10000, 48, j, problem);
                        Individual bestIndividual = ts.startSearch(1, 1, "greedy_inversion_nsize", average, i);
                    }
                }
                average.close();
                break;
            case "A-n54-k7":
                file = new File(testFileName + "_average_tabusize.csv");
                file.createNewFile();
                average = new PrintWriter(testFileName + "_average_tabusize.csv");
                // nsize - 10 - dim*(dim - 1)/2 - 50
                for (int j = 18; j <= 41; j++) {
                    System.out.println("Tabu size: " + j);
                    for (int i = 0; i < repetitions; i++) {
                        System.out.println(i);
                        TabuSearch ts = new TabuSearch(10000, 54, j, problem);
                        Individual bestIndividual = ts.startSearch(1, 1, "greedy_inversion_nsize", average, i);
                    }
                }
                average.close();
                break;
            case "A-n60-k9":
                file = new File(testFileName + "_average_tabusize.csv");
                file.createNewFile();
                average = new PrintWriter(testFileName + "_average_tabusize.csv");
                // nsize - 10 - dim*(dim - 1)/2 - 50
                for (int j = 20; j <= 30; j++) {
                    System.out.println("Tabu size: " + j);
                    for (int i = 0; i < repetitions; i++) {
                        System.out.println(i);
                        TabuSearch ts = new TabuSearch(10000, 60, j, problem);
                        Individual bestIndividual = ts.startSearch(1, 1, "greedy_inversion_nsize", average, i);
                    }
                }
                average.close();
                break;
        }

//        file = new File("average_iter_greedy_inversion.csv");
//        file.createNewFile();
//        average = new PrintWriter("average_iter_greedy_inversion.csv");
//
//        // iterations - {50, ...,1000, 1050, 1100, 1150,..., 2000} - with greedy init and inversion, n_size=10, tabu_size=100
//        for (int j = 50; j <= 2000; j += 50) {
//            for (int i = 0; i < repetitions; i++) {
//                TabuSearch ts = new TabuSearch(j, 10, 100, problem);
//                Individual bestIndividual = ts.startSearch(1, 1, "ts_result", average, i);
//            }
//        }
//        average.close();
//
//        file = new File("average_n_size_greedy_inversion.csv");
//        file.createNewFile();
//        average = new PrintWriter("average_n_size_greedy_inversion.csv");
//
//        // n_size - {10, 15, 20, 25,..., 100} - with greedy init and inversion, iter=1000, tabu_size=100
//        for (int j = 10; j <= 400; j += 10) {
//            for (int i = 0; i < repetitions; i++) {
//                TabuSearch ts = new TabuSearch(1000, j, 100, problem);
//                Individual bestIndividual = ts.startSearch(1, 1, "ts_result", average, i);
//            }
//        }
//        average.close();
//
//        file = new File("average_tabu_size_greedy_inversion.csv");
//        file.createNewFile();
//        average = new PrintWriter("average_tabu_size_greedy_inversion.csv");
//
//        // tabu_size - {10, 15, 20, 25,..., 100} - with greedy init and inversion, iter=1000, n_size=10
//        for (int j = 100; j <= 400; j += 10) {
//            for (int i = 0; i < repetitions; i++) {
//                TabuSearch ts = new TabuSearch(1000, 10, j, problem);
//                Individual bestIndividual = ts.startSearch(1, 1, "ts_result", average, i);
//            }
//        }
//        average.close();
//
//        file = new File("1x_greedy_inversion.csv");
//        file.createNewFile();
//        average = new PrintWriter("1x_greedy_inversion.csv");
//
//        // 10x greedy init and inversion, iter=1000, n_size=10, tabu_size=100
//
//        for (int i = 0; i < repetitions; i++) {
//            TabuSearch ts = new TabuSearch(1000, 10, 100, problem);
//            Individual bestIndividual = ts.startSearch(1, 1, "OneRun_greedy_inversion", average, i);
//        }
//
//        average.close();
//
//        file = new File("1x_random_inversion.csv");
//        file.createNewFile();
//        average = new PrintWriter("1x_random_inversion.csv");
//
//        // 10x random init and inversion, iter=1000, n_size=10, tabu_size=100
//
//        for (int i = 0; i < repetitions; i++) {
//            TabuSearch ts = new TabuSearch(1000, 10, 100, problem);
//            Individual bestIndividual = ts.startSearch(0, 1, "OneRun_random_inversion", average, i);
//        }
//
//        average.close();
//
//        file = new File("1x_greedy_swap.csv");
//        file.createNewFile();
//        average = new PrintWriter("1x_greedy_swap.csv");
//
//        // 10x greedy init and swap, iter=1000, n_size=10, tabu_size=100
//
//        for (int i = 0; i < repetitions; i++) {
//            TabuSearch ts = new TabuSearch(1000, 10, 100, problem);
//            Individual bestIndividual = ts.startSearch(1, 0, "OneRun_greedy_swap", average, i);
//        }
//
//        average.close();

    }

    public void runSAResearch(String testFileName) throws IOException {
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

//        file = new File("average_sa_iter_greedy_inversion.csv");
//        file.createNewFile();
//        average = new PrintWriter("average_sa_iter_greedy_inversion.csv");
//
//        System.out.println("Iterations");
//        // iterations - {50, ...,1000, 1050, 1100, 1150,..., 2000} - with greedy init and inversion, n_size=10, tabu_size=100
//        for (int j = 50000; j <= 150000; j += 10000) {
//            for (int i = 0; i < repetitions; i++) {
//                SimulatedAnnealing sa = new SimulatedAnnealing(j, 5, 1000, 1, 0.99993f, problem);
//                Individual bestIndividual = sa.startSimulation(1, 1, "sa_result", average, i);
//            }
//        }
//        average.close();

//        file = new File("average_sa_n_size_greedy_inversion.csv");
//        file.createNewFile();
//        average = new PrintWriter("average_sa_n_size_greedy_inversion.csv");
//
//        System.out.println("N_size");
//        // n_size - {10, 15, 20, 25,..., 100} - with greedy init and inversion, iter=1000, tabu_size=100
//        for (int j = 1; j <= 50; j++) {
//            for (int i = 0; i < repetitions; i++) {
//                SimulatedAnnealing sa = new SimulatedAnnealing(100000, j, 1000, 1, 0.99993f, problem);
//                Individual bestIndividual = sa.startSimulation(1, 1, "sa_result", average, i);
//            }
//        }
//        average.close();

//        file = new File("average_sa_tempStart_greedy_inversion.csv");
//        file.createNewFile();
//        average = new PrintWriter("average_sa_tempStart_greedy_inversion.csv");
//
//        System.out.println("TempStart");
//        // tempStart - {100, 150,..., 2000} - with greedy init and inversion, iter=1000, n_size=10
//        for (int j = 100; j <= 5000; j += 100) {
//            for (int i = 0; i < repetitions; i++) {
//                SimulatedAnnealing sa = new SimulatedAnnealing(100000, 5, j, 1, 0.99993f, problem);
//                Individual bestIndividual = sa.startSimulation(1, 1, "sa_result", average, i);
//            }
//        }
//        average.close();

//        file = new File("average_sa_tempFinish_greedy_inversion.csv");
//        file.createNewFile();
//        average = new PrintWriter("average_sa_tempFinish_greedy_inversion.csv");
//        System.out.println("TempFinish");
//        // tempFinish - {0, 5, 10, 15,..., 100} - with greedy init and inversion, iter=1000, n_size=10
//        for (int j = 0; j <= 10; j++) {
//            for (int i = 0; i < repetitions; i++) {
//                SimulatedAnnealing sa = new SimulatedAnnealing(100000, 5, 1000, j, 0.99993f, problem);
//                Individual bestIndividual = sa.startSimulation(1, 1, "sa_result", average, i);
//            }
//        }
//        average.close();

        file = new File("average_sa_alpha_greedy_inversion.csv");
        file.createNewFile();
        average = new PrintWriter("average_sa_alpha_greedy_inversion.csv");

        System.out.println("Alpha");
        // alpha - {0.1, 0.15, 0.20, 0.25,..., 1.0} - with greedy init and inversion, iter=1000, n_size=10
        for (float j = 0.9998f; j <= 0.99999f; j += 0.00001f) {
            for (int i = 0; i < repetitions; i++) {
                SimulatedAnnealing sa = new SimulatedAnnealing(100000, 5, 1000, 1, j, problem);
                Individual bestIndividual = sa.startSimulation(1, 1, "sa_result", average, i);
            }
        }
        average.close();
//
//
//        file = new File("1x_sa_greedy_inversion.csv");
//        file.createNewFile();
//        average = new PrintWriter("1x_sa_greedy_inversion.csv");
//
//        // 10x greedy init and inversion, iter=1000, n_size=10, tabu_size=100
//
//        for (int i = 0; i < repetitions; i++) {
//            SimulatedAnnealing sa = new SimulatedAnnealing(1000, 10, 400, 10, 0.9f, problem);
//            Individual bestIndividual = sa.startSimulation(1, 1, "OneRun_sa_greedy_inversion", average, i);
//        }
//
//        average.close();
//
//        file = new File("1x_sa_random_inversion.csv");
//        file.createNewFile();
//        average = new PrintWriter("1x_sa_random_inversion.csv");
//
//        // 10x random init and inversion, iter=1000, n_size=10, tabu_size=100
//
//        for (int i = 0; i < repetitions; i++) {
//            SimulatedAnnealing sa = new SimulatedAnnealing(1000, 10, 400, 10, 0.9f, problem);
//            Individual bestIndividual = sa.startSimulation(0, 1, "OneRun_sa_random_inversion", average, i);
//        }
//
//        average.close();
//
//        file = new File("1x_sa_greedy_swap.csv");
//        file.createNewFile();
//        average = new PrintWriter("1x_sa_greedy_swap.csv");
//
//        // 10x greedy init and swap, iter=1000, n_size=10, tabu_size=100
//
//        for (int i = 0; i < repetitions; i++) {
//            SimulatedAnnealing sa = new SimulatedAnnealing(1000, 10, 400, 10, 0.9f, problem);
//            Individual bestIndividual = sa.startSimulation(1, 0, "OneRun_sa_greedy_swap", average, i);
//        }
//
//        average.close();
//
//        file = new File("1x_sa_random_swap.csv");
//        file.createNewFile();
//        average = new PrintWriter("1x_sa_random_swap.csv");
//
//        // 10x random init and swap, iter=1000, n_size=10, tabu_size=100
//
//        for (int i = 0; i < repetitions; i++) {
//            SimulatedAnnealing sa = new SimulatedAnnealing(1000, 10, 400, 10, 0.9f, problem);
//            Individual bestIndividual = sa.startSimulation(0, 0, "OneRun_sa_random_swap", average, i);
//        }
//
//        average.close();

    }
}
