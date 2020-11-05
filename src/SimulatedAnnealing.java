import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimulatedAnnealing extends Algorithm {
    private int iter;
    private int n_size;
    private float temp_start;
    private float temp_finish;
    private float alpha;
    private Problem problem;

    public SimulatedAnnealing(int iter, int n_size, float temp_start, float temp_finish, float alpha, Problem problem) {
        this.iter = iter;
        this.n_size = n_size;
        this.temp_start = temp_start;
        this.temp_finish = temp_finish;
        this.alpha = alpha;
        this.problem = problem;
    }

    public int getIter() {
        return iter;
    }

    public void setIter(int iter) {
        this.iter = iter;
    }

    public int getN_size() {
        return n_size;
    }

    public void setN_size(int n_size) {
        this.n_size = n_size;
    }

    public float getTemp_start() {
        return temp_start;
    }

    public void setTemp_start(float temp_start) {
        this.temp_start = temp_start;
    }

    public float getTemp_finish() {
        return temp_finish;
    }

    public void setTemp_finish(float temp_finish) {
        this.temp_finish = temp_finish;
    }

    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public int bestNeighborPosition(Float[] neighbourFitness) {
        int bestPosition = -1;
        float bestFitness = Float.MAX_VALUE;
        for (int i = 0; i < neighbourFitness.length; i++) {
            if (neighbourFitness[i] < bestFitness) {
                bestFitness = neighbourFitness[i];
                bestPosition = i;
            }
        }
        return bestPosition;
    }

    public int worstNeighborPosition(Float[] neighbourFitness) {
        int worstPosition = -1;
        float worstFitness = Float.MIN_VALUE;
        for (int i = 0; i < neighbourFitness.length; i++) {
            if (neighbourFitness[i] > worstFitness) {
                worstFitness = neighbourFitness[i];
                worstPosition = i;
            }
        }
        return worstPosition;
    }

    //initialization: 0 - random, 1 - greedy, mutation: 0 - swap, 1 - inversion
    public Individual startSimulation(int initType, int mutationType, String saveFileName, PrintWriter avg, int j) throws IOException {
        Individual currentIndividual = new Individual(problem.getDimension());
        Individual globalBestIndividual = new Individual(problem.getDimension());
        Individual copiedCurrentIndividual = new Individual(problem.getDimension());
        Integer[][] neighbours;
        Float[] neighbourFitness;
        Random random = new Random();
        int currentIter = 0;
        int bestFitnessPosition = -1;
        int worstFitnessPosition = -1;
        float randomFloat;
        float boltzmann;
        float Temp = temp_start;

        File file = new File(j + "_" + saveFileName + ".csv");
        file.createNewFile();

        PrintWriter save = new PrintWriter(j + "_" + saveFileName + ".csv");

        if (initType == 0) {
            currentIndividual = currentIndividual.generateRandomIndividual(problem);
        } else {
            currentIndividual = GreedyAlgorithm.generateGreedyIndividual(problem, 1);
        }
        currentIndividual.setFitness(problem.calculateFitness(currentIndividual));
        globalBestIndividual.setRouteArray(currentIndividual.getRouteArray());
        globalBestIndividual.setFitness(currentIndividual.getFitness());

        while (currentIter < iter) {
            copiedCurrentIndividual.setRouteArray(currentIndividual.getRouteArray());
            copiedCurrentIndividual.setFitness(currentIndividual.getFitness());
            // generating n_size (or less) neighbourhood
            neighbours = problem.generateNeighbourListSA(n_size);
            // evaluating fitness for every option
            if (mutationType == 0) {
                neighbourFitness = problem.evaluateTabuFitnessSwap(copiedCurrentIndividual, neighbours);
            } else {
                neighbourFitness = problem.evaluateTabuFitnessInversion(copiedCurrentIndividual, neighbours);
            }
            // choosing best fitness
            bestFitnessPosition = bestNeighborPosition(neighbourFitness);
            worstFitnessPosition = worstNeighborPosition(neighbourFitness);
            // checking if bestFitness < currentIndividual.fitness
            // yes - continue, no - probability
            if (neighbourFitness[bestFitnessPosition] <= currentIndividual.getFitness()) {
                // setting currentIndividual to the best one found
                if (mutationType == 0) {
                    currentIndividual = currentIndividual.tabuSwap(neighbours[bestFitnessPosition][0], neighbours[bestFitnessPosition][1]);
                } else {
                    currentIndividual = currentIndividual.tabuInversion(neighbours[bestFitnessPosition][0], neighbours[bestFitnessPosition][1]);
                }
                currentIndividual.setFitness(problem.calculateFitness(currentIndividual));
                if (currentIndividual.getFitness() < globalBestIndividual.getFitness()) {
                    globalBestIndividual.setRouteArray(currentIndividual.getRouteArray());
                    globalBestIndividual.setFitness(currentIndividual.getFitness());
                }
            } else {
                randomFloat = random.nextFloat();
                boltzmann = (float) Math.exp(-1 * ((double) neighbourFitness[bestFitnessPosition] - (double) currentIndividual.getFitness()) / Temp);
                //System.out.println("Boltzmann: " + boltzmann);
                if (boltzmann > randomFloat) {
                    //System.out.println("Zapisuję gorszego, iter: " + currentIter + " Current: " + currentIndividual.getFitness() + ", gorszy: " + neighbourFitness[bestFitnessPosition]);
                    if (mutationType == 0) {
                        currentIndividual = currentIndividual.tabuSwap(neighbours[bestFitnessPosition][0], neighbours[bestFitnessPosition][1]);
                    } else {
                        currentIndividual = currentIndividual.tabuInversion(neighbours[bestFitnessPosition][0], neighbours[bestFitnessPosition][1]);
                    }
                    currentIndividual.setFitness(problem.calculateFitness(currentIndividual));
                }
            }

            save.println(currentIter + "; " + neighbourFitness[bestFitnessPosition] + ";" + neighbourFitness[worstFitnessPosition] + ";" + currentIndividual.getFitness() + ";" + globalBestIndividual.getFitness());
            if (Temp * alpha >= temp_finish) {
                Temp = Temp * alpha;
            }
            //System.out.println("Iter: " + currentIter + ", temp: " + Temp);
            currentIter++;
        }

        avg.println(j + "; " + iter + "_" + n_size + "_" + temp_start + "_" + temp_finish + "_" + alpha + ";" + globalBestIndividual.getFitness());
        save.close();
        return currentIndividual;
    }
}
