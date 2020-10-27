import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class EvolutionAlgorithm extends Algorithm {
    private int populationSize;
    private int numberOfGenerations;
    private float px;
    private float pm;
    private int tour;
    public Problem problem;

    public EvolutionAlgorithm(int populationSize, int numberOfGenerations, float px, float pm, int tour, Problem problem) {
        this.populationSize = populationSize;
        this.numberOfGenerations = numberOfGenerations;
        this.px = px;
        this.pm = pm;
        this.tour = tour;
        this.problem = problem;
    }

    public int getPopulationSize() {
        return populationSize;
    }

    public void setPopulationSize(int populationSize) {
        this.populationSize = populationSize;
    }

    public int getNumberOfGenerations() {
        return numberOfGenerations;
    }

    public void setNumberOfGenerations(int numberOfGenerations) {
        this.numberOfGenerations = numberOfGenerations;
    }

    public float getPx() {
        return px;
    }

    public void setPx(float px) {
        this.px = px;
    }

    public float getPm() {
        return pm;
    }

    public void setPm(float pm) {
        this.pm = pm;
    }

    public int getTour() {
        return tour;
    }

    public void setTour(int tour) {
        this.tour = tour;
    }

    public Population initializePopulation() {
        Population population = new Population(populationSize);
        population.populateRandom(problem);
        return population;
    }

    //selection: 1 - tour, 2 - roulette, crossover: 1 - ox, 2 - pmx, mutation: 1 - swap, 2 - inversion
    public Individual startEvolution(int selectionType, int crossoverType, int mutationType, String saveFileName, PrintWriter avg, int j) throws IOException {
        int iterator = 0;
        Random random = new Random();

        Population population = initializePopulation();
        population.calculatePopulationFitness(problem);
        Individual bestIndividual = new Individual(problem.getDimension());
        bestIndividual.setRouteArray(population.findBestIndividual().getRouteArray());
        bestIndividual.setFitness(population.findBestIndividual().getFitness());
        File file = new File(j + "_" + saveFileName + ".csv");
        file.createNewFile();

        PrintWriter save = new PrintWriter(j + "_" + saveFileName + ".csv");

        while (iterator != numberOfGenerations) {
            Population nextPopulation = new Population(population.getPopulationSize());

            // finding new best individual in population
            if (population.findBestIndividual().getFitness() < bestIndividual.getFitness()) {
                bestIndividual.setRouteArray(population.findBestIndividual().getRouteArray());
                bestIndividual.setFitness(population.findBestIndividual().getFitness());
            }


            for (int i = 0; i < populationSize; i++) {
                Individual firstParent;
                Individual secondParent;
                Individual child;
                float probability;

                if (selectionType == 1) {
                    firstParent = population.tournamentSelection(tour);
                    secondParent = population.tournamentSelection(tour);
                } else {
                    firstParent = population.rouletteSelection();
                    secondParent = population.rouletteSelection();
                }

                probability = random.nextFloat();
                if (probability < px) {
                    if (crossoverType == 1) {
                        child = firstParent.orderedCrossover(secondParent);
                    } else {
                        child = firstParent.partiallyMatchedCrossover(secondParent);
                    }
                } else {
                    child = firstParent;
                }

                probability = random.nextFloat();
                if (mutationType == 1) {
                    child = child.swap(pm);
                } else {
                    if (probability < pm) {
                        child = child.inversion();
                    }
                }

                nextPopulation.getIndividualArray().add(child);
            }
            population = nextPopulation;
            population.calculatePopulationFitness(problem);
            save.println(iterator + "; " + population.findBestIndividual().getFitness() + "; "
                    + population.averageFitness() + "; " + population.findWorstIndividual().getFitness() + "; "
                    + bestIndividual.getFitness());
            iterator++;
        }
        avg.println(j + "; " + population.getPopulationSize() + "_" + numberOfGenerations + "_" + px + "_" + pm + "_" + tour + "; " + bestIndividual.getFitness());
        save.close();
        return bestIndividual;
    }

}
