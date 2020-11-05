import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
//        Automat testAuto = new Automat(10);
//        testAuto.runEaResearch("A-n32-k5");
//        Automat testAuto = new Automat(1);
//        testAuto.runTSResearch("A-n32-k5");

        Automat testAuto = new Automat(10);
        testAuto.runSAResearch("A-n32-k5");


//        String str = "={";
//        for (int i = 1; i <= 49; i += 1) {
//            str += i + ", ";
//        }
//        str += "50}";
//        System.out.println(str);

        List<String> instanceList = new ArrayList<>();
        instanceList.add("A-n32-k5");
        instanceList.add("A-n37-k6");
        instanceList.add("A-n39-k5");
        instanceList.add("A-n45-k6");
        instanceList.add("A-n48-k7");

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


//        for (int i = 0; i < 5; i++) {
//            Loader loader = new Loader();
//            loader.load(instanceList.get(i));
//            Problem problem = new Problem(
//                    loader.getLoadedDimension(),
//                    loader.getLoadedCapacity(),
//                    loader.getLoadedDemandArray());
//            problem.calculateDistance(loader.getLoadedCoordXArray(), loader.getLoadedCoordYArray());
//            File file = new File("random_" + instanceList.get(i) + ".csv");
//            file.createNewFile();
//            PrintWriter random = new PrintWriter("random_" + instanceList.get(i) + ".csv");
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
//        for (int i = 0; i < 5; i++) {
//            Loader loader = new Loader();
//            loader.load(instanceList.get(i));
//            Problem problem = new Problem(
//                    loader.getLoadedDimension(),
//                    loader.getLoadedCapacity(),
//                    loader.getLoadedDemandArray());
//            problem.calculateDistance(loader.getLoadedCoordXArray(), loader.getLoadedCoordYArray());
//            File file = new File("greedy_" + instanceList.get(i) + ".csv");
//            file.createNewFile();
//            PrintWriter greedy = new PrintWriter("greedy_" + instanceList.get(i) + ".csv");
//            // Greedy
//            for (int j = 1; j < problem.getDimension(); j++) {
//                Individual greedyIndividual = new Individual(problem.getDimension());
//                greedyIndividual = GreedyAlgorithm.generateGreedyIndividual(problem, j);
//                greedyIndividual.setFitness(problem.calculateFitness(greedyIndividual));
//                greedy.println(greedyIndividual.getFitness());
//            }
//            greedy.close();
//        }

//        for (int i = 0; i < 5; i++) {
//            Loader loader = new Loader();
//            loader.load(instanceList.get(i));
//            Problem problem = new Problem(
//                    loader.getLoadedDimension(),
//                    loader.getLoadedCapacity(),
//                    loader.getLoadedDemandArray());
//            problem.calculateDistance(loader.getLoadedCoordXArray(), loader.getLoadedCoordYArray());
//            File file = new File("new_ea_" + instanceList.get(i) + ".csv");
//            file.createNewFile();
//            PrintWriter eaPW = new PrintWriter("new_ea_" + instanceList.get(i) + ".csv");
//            // EA
//            for (int j = 0; j < 10; j++) {
//                EvolutionAlgorithm ea = new EvolutionAlgorithm(350, 550, 0.7f, 0.16f, 15, problem);
//                //selection: 1 - tour, 2 - roulette, crossover: 1 - ox, 2 - pmx, mutation: 1 - swap, 2 - inversion
//                Individual bestIndividual = ea.startEvolution(1, 1, 2, "result", eaPW, j);
//            }
//            eaPW.close();
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
