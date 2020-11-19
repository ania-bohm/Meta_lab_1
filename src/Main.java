import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

//        Automat testAuto = new Automat(1);
//        testAuto.runTSResearch("A-n32-k5");


//        Automat testAuto = new Automat(10);
//        testAuto.runSAResearch("A-n32-k5");

//
//        String str = "={";
//        for (int i = 0; i <= 390; i += 10) {
//            str += i + ", ";
//        }
//        str += "400}";
//        System.out.println(str);
//
//        str = "={";
//        for (int i = 10; i <= 615; i++) {
//            str += i + ", ";
//        }
//        str += "616}";
//        System.out.println(str);
//
//        str = "={";
//        for (int i = 10; i <= 690; i++) {
//            str += i + ", ";
//        }
//        str += "691}";
//        System.out.println(str);
//
//        str = "={";
//        for (int i = 10; i <= 939; i++) {
//            str += i + ", ";
//        }
//        str += "940}";
//        System.out.println(str);
//
//        str = "={";
//        for (int i = 10; i <= 1077; i++) {
//            str += i + ", ";
//        }
//        str += "1078}";
//        System.out.println(str);
//
//        str = "={";
//        for (int i = 10; i <= 1380; i++) {
//            str += i + ", ";
//        }
//        str += "1381}";
//        System.out.println(str);
//
//        str = "={";
//        for (int i = 10; i <= 1719; i++) {
//            str += i + ", ";
//        }
//        str += "1720}";
//        System.out.println(str);

        List<String> instanceList = new ArrayList<>();
        instanceList.add("A-n32-k5");
//        instanceList.add("A-n37-k6");
//        instanceList.add("A-n39-k5");
//        instanceList.add("A-n45-k6");
//        instanceList.add("A-n48-k7");
//        instanceList.add("A-n54-k7");
//        instanceList.add("A-n60-k9");

//        Automat testAuto = new Automat(10);
//
//        for (int i = 0; i < instanceList.size(); i++) {
//            System.out.println("Plik: " + instanceList.get(i));
//            testAuto.runTSResearch(instanceList.get(i));
//        }


//        testAuto.runEaResearch(instanceList.get(0));
//        int k = 0;
//        for (float i = 0.55f; i <= 0.91f; i += 0.01f) {
//            System.out.println(i);
//            k++;
//        }
//        System.out.println(k);
//        for (int i = 0; i < instanceList.size(); i++) {
//            System.out.println("Plik: " + instanceList.get(i));
//            testAuto.runEaResearch(instanceList.get(i));
//        }


//        Loader loader = new Loader();
//        loader.load(instanceList.get(0));
//        Problem problem = new Problem(
//                loader.getLoadedDimension(),
//                loader.getLoadedCapacity(),
//                loader.getLoadedDemandArray());
//        problem.calculateDistance(loader.getLoadedCoordXArray(), loader.getLoadedCoordYArray());
//
//        TabuSearch ts = new TabuSearch(1000, 10, 100, problem);
//        Individual individual = ts.startSearch(1, 0, );
//        individual.printRouteArray();
//        System.out.println(individual.getFitness());


//        for (int i = 5; i < 7; i++) {
//            System.out.println("Random: " + instanceList.get(i));
//            Loader loader = new Loader();
//            loader.load(instanceList.get(i));
//            Problem problem = new Problem(
//                    loader.getLoadedDimension(),
//                    loader.getLoadedCapacity(),
//                    loader.getLoadedDemandArray());
//            problem.calculateDistance(loader.getLoadedCoordXArray(), loader.getLoadedCoordYArray());
//            File file = new File("final_random_" + instanceList.get(i) + ".csv");
//            file.createNewFile();
//            PrintWriter random = new PrintWriter("final_random_" + instanceList.get(i) + ".csv");
//            // Random 10k
//            for (int j = 0; j < 9999; j++) {
//                Individual randomIndividual = new Individual(problem.getDimension());
//                randomIndividual = randomIndividual.generateRandomIndividual(problem);
//                randomIndividual.setFitness(problem.calculateFitness(randomIndividual));
//                random.println(randomIndividual.getFitness());
//            }
//            random.close();
//        }
//
//        for (int i = 5; i < 7; i++) {
//            System.out.println("Greedy: " + instanceList.get(i));
//            Loader loader = new Loader();
//            loader.load(instanceList.get(i));
//            Problem problem = new Problem(
//                    loader.getLoadedDimension(),
//                    loader.getLoadedCapacity(),
//                    loader.getLoadedDemandArray());
//            problem.calculateDistance(loader.getLoadedCoordXArray(), loader.getLoadedCoordYArray());
//            File file = new File("final_greedy_" + instanceList.get(i) + ".csv");
//            file.createNewFile();
//            PrintWriter greedy = new PrintWriter("final_greedy_" + instanceList.get(i) + ".csv");
//            // Greedy
//            for (int j = 1; j < problem.getDimension(); j++) {
//                Individual greedyIndividual = new Individual(problem.getDimension());
//                greedyIndividual = GreedyAlgorithm.generateGreedyIndividual(problem, j);
//                greedyIndividual.setFitness(problem.calculateFitness(greedyIndividual));
//                greedy.println(greedyIndividual.getFitness());
//            }
//            greedy.close();
//        }

//        for (int i = 0; i < 10; i++) {
//            System.out.println("i: " + i);
//            Loader loader = new Loader();
//            loader.load(instanceList.get(1));
//            Problem problem = new Problem(
//                    loader.getLoadedDimension(),
//                    loader.getLoadedCapacity(),
//                    loader.getLoadedDemandArray());
//            problem.calculateDistance(loader.getLoadedCoordXArray(), loader.getLoadedCoordYArray());
//            File file = new File(i + "_finalRun_" + instanceList.get(1) + ".csv");
//            file.createNewFile();
//            PrintWriter eaPW = new PrintWriter(i + "_finalRun_" + instanceList.get(1) + ".csv");
//            for (int j = 0; j < 10; j++) {
//                System.out.println("j:" + j);
//                EvolutionAlgorithm ea = new EvolutionAlgorithm(450, 950, 0.75f, 0.1f, 99, problem);
//                //selection: 1 - tour, 2 - roulette, crossover: 1 - ox, 2 - pmx, mutation: 1 - swap, 2 - inversion
//                Individual bestIndividual = ea.startEvolution(1, 1, 2, "result", eaPW, j);
//            }
//            eaPW.close();
//        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < instanceList.size(); i++) {
            System.out.println("Measuring time for Evolution Algorithm: " + instanceList.get(i));
            Loader loader = new Loader();
            loader.load(instanceList.get(i));
            Problem problem = new Problem(
                    loader.getLoadedDimension(),
                    loader.getLoadedCapacity(),
                    loader.getLoadedDemandArray());
            problem.calculateDistance(loader.getLoadedCoordXArray(), loader.getLoadedCoordYArray());
            File file = new File("changed_ea_new_finalRun_" + instanceList.get(i) + ".csv");
            file.createNewFile();
            PrintWriter eaPW = new PrintWriter("changed_ea_new_finalRun_" + instanceList.get(i) + ".csv");
            // EA
            switch (instanceList.get(i)) {
                case "A-n32-k5":
                    for (int j = 0; j < 10; j++) {
                        System.out.println(j);
                        //EvolutionAlgorithm ea = new EvolutionAlgorithm(1000, 1000, 0.71f, 0.31f, 139, problem);
                        EvolutionAlgorithm ea = new EvolutionAlgorithm(450, 950, 0.71f, 0.31f, 139, problem);
                        //selection: 1 - tour, 2 - roulette, crossover: 1 - ox, 2 - pmx, mutation: 1 - swap, 2 - inversion
                        Individual bestIndividual = ea.startEvolution(1, 1, 2, "bigGen_EA_result", eaPW, 3);
                        long finish = System.currentTimeMillis();
                        System.out.println("Time elapsed in ms: " + (finish - start));
                    }
                    break;
                case "A-n37-k6":
                    for (int j = 0; j < 10; j++) {
                        System.out.println(j);
                        //EvolutionAlgorithm ea = new EvolutionAlgorithm(1000, 1000, 0.75f, 0.1f, 99, problem);
                        EvolutionAlgorithm ea = new EvolutionAlgorithm(1000, 1000, 0.75f, 0.1f, 200, problem);
                        //selection: 1 - tour, 2 - roulette, crossover: 1 - ox, 2 - pmx, mutation: 1 - swap, 2 - inversion
                        Individual bestIndividual = ea.startEvolution(1, 1, 2, "result", eaPW, j);
                    }
                    break;
                case "A-n39-k5":
//                    for (int j = 0; j < 1; j++) {
//                        System.out.println(j);
//                        //EvolutionAlgorithm ea = new EvolutionAlgorithm(1000, 1000, 0.75f, 0.22f, 90, problem);
//                        EvolutionAlgorithm ea = new EvolutionAlgorithm(1000, 1000, 0.75f, 0.22f, 200, problem);
//                        //selection: 1 - tour, 2 - roulette, crossover: 1 - ox, 2 - pmx, mutation: 1 - swap, 2 - inversion
//                        Individual bestIndividual = ea.startEvolution(1, 1, 2, "test_ea_result", eaPW, j);
//                    }
                    for (int j = 0; j < 1; j++) {
                        System.out.println(j);
                        //EvolutionAlgorithm ea = new EvolutionAlgorithm(1000, 1000, 0.75f, 0.22f, 90, problem);
                        EvolutionAlgorithm ea = new EvolutionAlgorithm(10, 1000, 0.75f, 0.22f, 2, problem);
                        //selection: 1 - tour, 2 - roulette, crossover: 1 - ox, 2 - pmx, mutation: 1 - swap, 2 - inversion
                        Individual bestIndividual = ea.startEvolution(1, 1, 2, "10x1000_ea_result", eaPW, j);
                    }
                    for (int j = 0; j < 1; j++) {
                        System.out.println(j);
                        //EvolutionAlgorithm ea = new EvolutionAlgorithm(1000, 1000, 0.75f, 0.22f, 90, problem);
                        EvolutionAlgorithm ea = new EvolutionAlgorithm(100, 100, 0.75f, 0.22f, 20, problem);
                        //selection: 1 - tour, 2 - roulette, crossover: 1 - ox, 2 - pmx, mutation: 1 - swap, 2 - inversion
                        Individual bestIndividual = ea.startEvolution(1, 1, 2, "100x100_ea_result", eaPW, j);
                    }
                    for (int j = 0; j < 1; j++) {
                        System.out.println(j);
                        //EvolutionAlgorithm ea = new EvolutionAlgorithm(1000, 1000, 0.75f, 0.22f, 90, problem);
                        EvolutionAlgorithm ea = new EvolutionAlgorithm(1000, 10, 0.75f, 0.22f, 200, problem);
                        //selection: 1 - tour, 2 - roulette, crossover: 1 - ox, 2 - pmx, mutation: 1 - swap, 2 - inversion
                        Individual bestIndividual = ea.startEvolution(1, 1, 2, "1000x10_ea_result", eaPW, j);
                    }
                    break;
                case "A-n45-k6":
                    for (int j = 0; j < 10; j++) {
                        System.out.println(j);
                        //EvolutionAlgorithm ea = new EvolutionAlgorithm(1000, 1000, 0.65f, 0.11f, 175, problem);
                        EvolutionAlgorithm ea = new EvolutionAlgorithm(1000, 1000, 0.65f, 0.11f, 350, problem);
                        //selection: 1 - tour, 2 - roulette, crossover: 1 - ox, 2 - pmx, mutation: 1 - swap, 2 - inversion
                        Individual bestIndividual = ea.startEvolution(1, 1, 2, "result", eaPW, j);
                    }
                    break;
                case "A-n48-k7":
                    for (int j = 0; j < 10; j++) {
                        System.out.println(j);
                        //EvolutionAlgorithm ea = new EvolutionAlgorithm(1000, 1000, 0.69f, 0.19f, 112, problem);
                        EvolutionAlgorithm ea = new EvolutionAlgorithm(1000, 1000, 0.69f, 0.19f, 224, problem);
                        //selection: 1 - tour, 2 - roulette, crossover: 1 - ox, 2 - pmx, mutation: 1 - swap, 2 - inversion
                        Individual bestIndividual = ea.startEvolution(1, 1, 2, "result", eaPW, j);
                    }
                    break;
                case "A-n54-k7":
                    for (int j = 0; j < 10; j++) {
                        System.out.println(j);
                        //EvolutionAlgorithm ea = new EvolutionAlgorithm(1000, 1000, 0.78f, 0.29f, 202, problem);
                        EvolutionAlgorithm ea = new EvolutionAlgorithm(1000, 1000, 0.78f, 0.29f, 404, problem);
                        //selection: 1 - tour, 2 - roulette, crossover: 1 - ox, 2 - pmx, mutation: 1 - swap, 2 - inversion
                        Individual bestIndividual = ea.startEvolution(1, 1, 2, "result", eaPW, j);
                    }
                    break;
                case "A-n60-k9":
                    for (int j = 0; j < 10; j++) {
                        System.out.println(j);
                        //EvolutionAlgorithm ea = new EvolutionAlgorithm(1000, 1000, 0.77f, 0.32f, 229, problem);
                        EvolutionAlgorithm ea = new EvolutionAlgorithm(1000, 1000, 0.77f, 0.32f, 458, problem);
                        //selection: 1 - tour, 2 - roulette, crossover: 1 - ox, 2 - pmx, mutation: 1 - swap, 2 - inversion
                        Individual bestIndividual = ea.startEvolution(1, 1, 2, "result", eaPW, j);
                    }
                    break;
            }
            eaPW.close();
        }

//        long start = System.currentTimeMillis();
//        for (int i = 0; i < instanceList.size(); i++) {
//            Loader loader = new Loader();
//            //loader.load("test");
//            loader.load(instanceList.get(i));
//            Problem problem = new Problem(
//                    loader.getLoadedDimension(),
//                    loader.getLoadedCapacity(),
//                    loader.getLoadedDemandArray());
//            problem.calculateDistance(loader.getLoadedCoordXArray(), loader.getLoadedCoordYArray());
//            File file;
//            PrintWriter average;
//            file = new File(instanceList.get(i) + "_finalRunTS.csv");
//            file.createNewFile();
//            average = new PrintWriter(instanceList.get(i) + "_finalRunTS.csv");
//            System.out.println("Measuring time for Tabu Search: " + instanceList.get(i));
//            switch (instanceList.get(i)) {
//                case "A-n32-k5":
//                    for (int j = 0; j < 1; j++) {
//                        //System.out.println(j);
//                        TabuSearch ts = new TabuSearch(10000, 32, 10, problem);
//                        //TabuSearch ts = new TabuSearch(6000, 175, 50, problem);
//                        Individual bestIndividual = ts.startSearch(1, 1, "SPRAWKO_TS_result", average, j);
//                        long finish = System.currentTimeMillis();
//                        System.out.println("Time elapsed in ms: " + (finish - start));
//                    }
//                    average.close();
//                    break;
//                case "A-n37-k6":
//                    for (int j = 0; j < 10; j++) {
//                        System.out.println(j);
//                        TabuSearch ts = new TabuSearch(10000, 37, 18, problem);
//                        Individual bestIndividual = ts.startSearch(1, 1, "greedy_inversion_nsize", average, j);
//                    }
//                    average.close();
//                    break;
//                case "A-n39-k5":
//                    for (int j = 0; j < 10; j++) {
//                        System.out.println(j);
//                        TabuSearch ts = new TabuSearch(10000, 39, 15, problem);
//                        Individual bestIndividual = ts.startSearch(1, 1, "greedy_inversion_nsize", average, j);
//                    }
//                    average.close();
//                    break;
//                case "A-n45-k6":
//                    for (int j = 0; j < 10; j++) {
//                        System.out.println(j);
//                        TabuSearch ts = new TabuSearch(10000, 45, 23, problem);
//                        Individual bestIndividual = ts.startSearch(1, 1, "greedy_inversion_nsize", average, j);
//                    }
//                    average.close();
//                    break;
//                case "A-n48-k7":
//                    for (int j = 0; j < 10; j++) {
//                        System.out.println(j);
//                        TabuSearch ts = new TabuSearch(10000, 48, 12, problem);
//                        Individual bestIndividual = ts.startSearch(1, 1, "greedy_inversion_nsize", average, j);
//                    }
//                    average.close();
//                    break;
//                case "A-n54-k7":
//                    for (int j = 0; j < 10; j++) {
//                        System.out.println(j);
//                        TabuSearch ts = new TabuSearch(10000, 54, 33, problem);
//                        Individual bestIndividual = ts.startSearch(1, 1, "greedy_inversion_nsize", average, j);
//                    }
//                    average.close();
//                    break;
//                case "A-n60-k9":
//                    for (int j = 0; j < 10; j++) {
//                        System.out.println(j);
//                        TabuSearch ts = new TabuSearch(10000, 60, 20, problem);
//                        Individual bestIndividual = ts.startSearch(1, 1, "greedy_inversion_nsize", average, j);
//                    }
//                    average.close();
//                    break;
//            }
//        }


//        long start = System.currentTimeMillis();
//        for (int i = 0; i < instanceList.size(); i++) {
//            System.out.println("Measuring time for Simulated Annealing: " + instanceList.get(i));
//            Loader loader = new Loader();
//            loader.load(instanceList.get(i));
//            Problem problem = new Problem(
//                    loader.getLoadedDimension(),
//                    loader.getLoadedCapacity(),
//                    loader.getLoadedDemandArray());
//            problem.calculateDistance(loader.getLoadedCoordXArray(), loader.getLoadedCoordYArray());
//            File file = new File("sa_finalRun_" + instanceList.get(i) + ".csv");
//            file.createNewFile();
//            PrintWriter eaPW = new PrintWriter("sa_finalRun_" + instanceList.get(i) + ".csv");
//            // EA
//            switch (instanceList.get(i)) {
//                case "A-n32-k5":
//                    for (int j = 0; j < 1; j++) {
//                        //System.out.println(j);
//                        SimulatedAnnealing sa = new SimulatedAnnealing(100000, 23, 1000, 1, 0.99993f, problem);
//                        Individual testIndi = sa.startSimulation(1, 1, "profiler_SA_result", eaPW, j);
//                    }
//                    long finish = System.currentTimeMillis();
//                    System.out.println("Time elapsed in ms: " + (finish - start));
//                    break;
//                case "A-n37-k6":
//                    for (int j = 0; j < 10; j++) {
//                        System.out.println(j);
//                        SimulatedAnnealing sa = new SimulatedAnnealing(100000, 16, 1000, 1, 0.99993f, problem);
//                        Individual testIndi = sa.startSimulation(1, 1, "result", eaPW, j);
//                    }
//                    break;
//                case "A-n39-k5":
//                    for (int j = 0; j < 10; j++) {
//                        System.out.println(j);
//                        SimulatedAnnealing sa = new SimulatedAnnealing(100000, 17, 1000, 1, 0.99993f, problem);
//                        Individual testIndi = sa.startSimulation(1, 1, "result", eaPW, j);
//                    }
//                    break;
//                case "A-n45-k6":
//                    for (int j = 0; j < 10; j++) {
//                        System.out.println(j);
//                        SimulatedAnnealing sa = new SimulatedAnnealing(100000, 19, 1000, 10, 0.99993f, problem);
//                        Individual testIndi = sa.startSimulation(1, 1, "result", eaPW, j);
//                    }
//                    break;
//                case "A-n48-k7":
//                    for (int j = 0; j < 10; j++) {
//                        System.out.println(j);
//                        SimulatedAnnealing sa = new SimulatedAnnealing(100000, 20, 1000, 10, 0.99993f, problem);
//                        Individual testIndi = sa.startSimulation(1, 1, "result", eaPW, j);
//                    }
//                    break;
//                case "A-n54-k7":
//                    for (int j = 0; j < 10; j++) {
//                        System.out.println(j);
//                        SimulatedAnnealing sa = new SimulatedAnnealing(100000, 21, 1000, 1, 0.99993f, problem);
//                        Individual testIndi = sa.startSimulation(1, 1, "result", eaPW, j);
//                    }
//                    break;
//                case "A-n60-k9":
//                    for (int j = 0; j < 10; j++) {
//                        System.out.println(j);
//                        SimulatedAnnealing sa = new SimulatedAnnealing(100000, 30, 1000, 10, 0.99993f, problem);
//                        Individual testIndi = sa.startSimulation(1, 1, "result", eaPW, j);
//                    }
//                    break;
//            }
//            eaPW.close();
//
//        }

//        Loader loader = new Loader();
//        loader.load(instanceList.get(2));
//        Problem problem = new Problem(
//                loader.getLoadedDimension(),
//                loader.getLoadedCapacity(),
//                loader.getLoadedDemandArray());
//        problem.calculateDistance(loader.getLoadedCoordXArray(), loader.getLoadedCoordYArray());
//        File file = new File("1_new_OneRunEa_" + instanceList.get(2) + ".csv");
//        file.createNewFile();
//        PrintWriter eaPW = new PrintWriter("1_new_OneRunEa_" + instanceList.get(2) + ".csv");
//
//        EvolutionAlgorithm ea = new EvolutionAlgorithm(350, 550, 0.6f, 0.0075f, 15, problem);
//        //selection: 1 - tour, 2 - roulette, crossover: 1 - ox, 2 - pmx, mutation: 1 - swap, 2 - inversion
//        Individual bestIndividual = ea.startEvolution(1, 2, 1, "1_new_OneRunResult", eaPW, 1);
//
//        eaPW.close();
//
//
//        File file1 = new File("2_new_OneRunEa_" + instanceList.get(1) + ".csv");
//        file1.createNewFile();
//        PrintWriter eaPW1 = new PrintWriter("2_new_OneRunEa_" + instanceList.get(1) + ".csv");
//
//        EvolutionAlgorithm ea1 = new EvolutionAlgorithm(400, 400, 0.7f, 0.16f, 20, problem);
//        //selection: 1 - tour, 2 - roulette, crossover: 1 - ox, 2 - pmx, mutation: 1 - swap, 2 - inversion
//        Individual bestIndividual1 = ea1.startEvolution(1, 1, 2, "2_new_OneRunResult", eaPW1, 1);
//
////        eaPW1.close();
//
//        for (int i = 0; i < 5; i++) {
//            Loader loader = new Loader();
//            loader.load(instanceList.get(i));
//            Problem problem = new Problem(
//                    loader.getLoadedDimension(),
//                    loader.getLoadedCapacity(),
//                    loader.getLoadedDemandArray());
//            problem.calculateDistance(loader.getLoadedCoordXArray(), loader.getLoadedCoordYArray());
//            File file = new File("ts_table_" + instanceList.get(i) + ".csv");
//            file.createNewFile();
//            PrintWriter tsPW = new PrintWriter("ts_table_" + instanceList.get(i) + ".csv");
//            // TS
//            for (int j = 0; j < 10; j++) {
//                TabuSearch ts = new TabuSearch(300, 10, 10, problem);
//                Individual bestIndividual = ts.startSearch(1, 1, instanceList.get(i) + "_result", tsPW, j);
//            }
//            tsPW.close();
    }

//        Loader loader = new Loader();
//        loader.load(instanceList.get(4));
//        Problem problem = new Problem(
//                loader.getLoadedDimension(),
//                loader.getLoadedCapacity(),
//                loader.getLoadedDemandArray());
//        problem.calculateDistance(loader.getLoadedCoordXArray(), loader.getLoadedCoordYArray());
//        File file = new File("new_sa_tabelka" + instanceList.get(4) + ".csv");
//        file.createNewFile();
//        PrintWriter saPW = new PrintWriter("new_sa_tabelka" + instanceList.get(4) + ".csv");
//
////        SimulatedAnnealing sa = new SimulatedAnnealing(100000, 6, 1000, 1, 0.99993f, problem);
////        Individual testIndi = sa.startSimulation(1, 0, "result", saPW, 1);
//
//        for (int j = 0; j < 10; j++) {
//            SimulatedAnnealing sa = new SimulatedAnnealing(200000, 51, 1000, 1, 0.99996f, problem);
//            Individual testIndi = sa.startSimulation(1, 0, "result", saPW, j);
//        }
//
//        saPW.close();
//    }

    //        for (int i = 0; i < 5; i++) {
//            Loader loader = new Loader();
//            loader.load(instanceList.get(i));
//            Problem problem = new Problem(
//                    loader.getLoadedDimension(),
//                    loader.getLoadedCapacity(),
//                    loader.getLoadedDemandArray());
//            problem.calculateDistance(loader.getLoadedCoordXArray(), loader.getLoadedCoordYArray());
//            File file = new File("ts_table_" + instanceList.get(i) + ".csv");
//            file.createNewFile();
//            PrintWriter tsPW = new PrintWriter("ts_table_" + instanceList.get(i) + ".csv");
//            // TS
//            for (int j = 0; j < 10; j++) {
//                TabuSearch ts = new TabuSearch(300, 10, 10, problem);
//                Individual bestIndividual = ts.startSearch(1, 1, instanceList.get(i) + "_result", tsPW, j);
//            }
//            tsPW.close();
//        }
}
