import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Loader loader = new Loader();
        loader.load("test");
        Problem problem = new Problem(
                loader.getLoadedDimension(),
                loader.getLoadedCapacity(),
                loader.getLoadedDemandArray());
        problem.calculateDistance(loader.getLoadedCoordXArray(), loader.getLoadedCoordYArray());
        // problem.printDistanceMatrix();

//        List<Integer> coordXArray = new ArrayList<>(Arrays.asList(0, 4, 6, 6, 11));
//        List<Integer> coordYArray = new ArrayList<>(Arrays.asList(0, 4, 6, 2, 4));
//        List<Integer> demandArray = new ArrayList<>(Arrays.asList(0, 5, 4, 8, 2));
//        //List<Integer> demandArray = new ArrayList<>(Arrays.asList(0, 4, 4, 6, 6));
//        Problem problem = new Problem(5, 10, demandArray);
//        problem.calculateDistance(coordXArray, coordYArray);

//        Individual randomIndividual = new Individual(problem.getDimension());
//        randomIndividual = randomIndividual.generateRandomIndividual(problem);
//        randomIndividual.printRouteArray();
//
//        Individual greedyIndividual = GreedyAlgorithm.generateGreedyIndividual(problem, 2);
//        greedyIndividual.printRouteArray();
//        System.out.println(problem.calculateFitness(greedyIndividual));
//        greedyIndividual.inversion();
//        greedyIndividual.printRouteArray();
//        System.out.println(problem.calculateFitness(greedyIndividual));
//
//        Individual childIndividual = greedyIndividual.partiallyMatchedCrossover(randomIndividual);
//        childIndividual.printRouteArray();
//        System.out.println(problem.calculateFitness(childIndividual));
//
//        Population populationRandom = new Population(4);
//        Population populationGreedy = new Population(5);
//        populationRandom.populateRandom(problem);
//        System.out.println("Random population: ");
//        populationRandom.printPopulation();
//
//        System.out.println("Greedy population: ");
//        populationGreedy.populateGreedy(problem);
//        populationGreedy.printPopulation();

        EvolutionAlgorithm ea = new EvolutionAlgorithm(100, 100, 0.01f, 0.1f, 5, problem);
        //selection: 1 - tour, 2 - roulette, crossover: 1 - ox, 2 - pmx, mutation: 1 - swap, 2 - inversion
        Population population = ea.startEvolution(2, 2, 2);
        population.printPopulation();
        System.out.println(population.findBestIndividual().getFitness());
    }
}
