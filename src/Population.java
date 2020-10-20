import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Population {

    private List<Individual> individualArray;
    private int populationSize;

    public Population(int populationSize) {
        this.populationSize = populationSize;
        individualArray = new ArrayList<>();
    }

    public List<Individual> getIndividualArray() {
        return individualArray;
    }

    public void setIndividualArray(List<Individual> individualArray) {
        this.individualArray = individualArray;
    }

    public int getPopulationSize() {
        return populationSize;
    }

    public void setPopulationSize(int populationSize) {
        this.populationSize = populationSize;
    }

    public void populateRandom(Problem problem) {
        for (int i = 0; i < populationSize; i++) {
            Individual individual = new Individual(problem.getDimension());
            individualArray.add(individual.generateRandomIndividual(problem));
        }
    }

    public void populateGreedy(Problem problem) {
        Random random = new Random();
        int startLocation;
        for (int i = 0; i < populationSize; i++) {
            startLocation = random.nextInt(problem.getDimension() - 1) + 1;
            Individual individual = new Individual(problem.getDimension());
            individualArray.add(GreedyAlgorithm.generateGreedyIndividual(problem, startLocation));
        }
    }

    public void printPopulation() {
        for (Individual individual : individualArray) {
            individual.printRouteArray();
        }
    }

    public void calculatePopulationFitness(Problem problem) {
        for (int i = 0; i < populationSize; i++) {
            individualArray.get(i).setFitness(problem.calculateFitness(individualArray.get(i)));
        }
    }

    public Individual findBestIndividual() {
        float bestFitness = Float.MAX_VALUE;
        int bestPosition = -1;
        for (int i = 0; i < individualArray.size(); i++) {
            if (individualArray.get(i).getFitness() < bestFitness) {
                bestFitness = individualArray.get(i).getFitness();
                bestPosition = i;
            }
        }
        return individualArray.get(bestPosition);
    }

    public Individual findWorstIndividual() {
        float worstFitness = Float.MIN_VALUE;
        int worstPosition = -1;
        for (int i = 0; i < individualArray.size(); i++) {
            if (individualArray.get(i).getFitness() > worstFitness) {
                worstFitness = individualArray.get(i).getFitness();
                worstPosition = i;
            }
        }
        return individualArray.get(worstPosition);
    }

    public Individual tournamentSelection(int tournamentSize) {
        List<Individual> allIndividuals = new ArrayList<>(individualArray);
        List<Individual> drawnIndividuals = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < tournamentSize; i++) {
            int randomPosition = random.nextInt(allIndividuals.size());
            drawnIndividuals.add(allIndividuals.remove(randomPosition));
        }
        Individual bestIndividual = drawnIndividuals.get(0);
        float bestFitness = drawnIndividuals.get(0).getFitness();
        for (int i = 1; i < tournamentSize; i++) {
            if (drawnIndividuals.get(i).getFitness() < bestFitness) {
                bestIndividual = drawnIndividuals.get(i);
                bestFitness = drawnIndividuals.get(i).getFitness();
            }
        }
        return bestIndividual;
    }

    public Individual rouletteSelection() {
        float wholeQuality = 0;
        float bestFitness = findBestIndividual().getFitness();
        float worstFitness = findWorstIndividual().getFitness();
        float[] individualQuality = new float[populationSize];

        for (int i = 0; i < populationSize; i++) {
            individualQuality[i] = worstFitness - individualArray.get(i).getFitness() + bestFitness;
        }

        for (int i = 0; i < populationSize; i++) {
            wholeQuality += individualQuality[i];
        }
        Random random = new Random();
        int randomNumber = random.nextInt((int) wholeQuality - 1);
        float currentQualitySum = 0;

        for (int i = 0; i < populationSize; i++) {
            currentQualitySum += individualQuality[i];
            if (randomNumber < currentQualitySum) {
                return individualArray.get(i);
            }
        }
        return individualArray.get(populationSize - 1);

    }
}
