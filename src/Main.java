import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        Loader loader = new Loader();
//        loader.load("test");
//        Problem problem = new Problem(
//                loader.getLoadedDimension(),
//                loader.getLoadedCapacity(),
//                loader.getLoadedDemandArray());
//        problem.calculateDistance(loader.getLoadedCoordXArray(), loader.getLoadedCoordYArray());
//        problem.printDistanceMatrix();

        List<Integer> coordXArray = new ArrayList<>(Arrays.asList(0, 4, 6, 6, 11));
        List<Integer> coordYArray = new ArrayList<>(Arrays.asList(0, 4, 6, 2, 4));
        List<Integer> demandArray = new ArrayList<>(Arrays.asList(0, 5, 4, 8, 2));
        //List<Integer> demandArray = new ArrayList<>(Arrays.asList(0, 4, 4, 6, 6));
        Problem problem = new Problem(5, 10, demandArray);
        problem.calculateDistance(coordXArray, coordYArray);

        Individual randomIndividual = new Individual(problem.getDimension());
        randomIndividual = randomIndividual.generateRandomIndividual(problem);
        randomIndividual.printRouteArray();

        Individual greedyIndividual = GreedyAlgorithm.generateGreedyIndividual(problem, 2);
        greedyIndividual.printRouteArray();
        System.out.println(problem.calculateFitness(greedyIndividual));

//        Individual correctIndi = new Individual();
//        List<List<Integer>> correctRouteArray = new ArrayList<>();
//        correctRouteArray.add(new ArrayList<>());
//        correctRouteArray.add(new ArrayList<>());
//        correctRouteArray.add(new ArrayList<>());
//
//        correctRouteArray.get(0).add(1);
//        correctRouteArray.get(0).add(2);
//        correctRouteArray.get(1).add(3);
//        correctRouteArray.get(2).add(4);
//        correctIndi.setRouteArray(correctRouteArray);
//
//        Individual incorrectIndi = new Individual();
//        List<List<Integer>> incorrectRouteArray = new ArrayList<>();
//
//        incorrectRouteArray.add(new ArrayList<>());
//        incorrectRouteArray.add(new ArrayList<>());
//        incorrectRouteArray.add(new ArrayList<>());
//
//        incorrectRouteArray.get(0).add(3);
//        incorrectRouteArray.get(0).add(4);
//        incorrectRouteArray.get(1).add(1);
//        incorrectRouteArray.get(2).add(2);
//        incorrectIndi.setRouteArray(incorrectRouteArray);
//
//        System.out.println("1." + correctIndi.isIndividualCorrect(problem));
//        System.out.println(correctIndi.getRouteArray().toString());
//        System.out.println("2." + incorrectIndi.isIndividualCorrect(problem));
//        System.out.println(incorrectIndi.getRouteArray().toString());

//        Individual randomIndividual = Methods.generateRandomIndividual(problem);
//        System.out.println(randomIndividual.getRouteArray().toString());
//
//        Individual greedyIndividual = Methods.generateGreedyIndividual(problem);
//        System.out.println(greedyIndividual.getRouteArray().toString());
//
//        System.out.println("Cost of random: " + randomIndividual.calculateIndividualCost(problem));
//        System.out.println("Cost of greedy: " + greedyIndividual.calculateIndividualCost(problem));

    }
}
