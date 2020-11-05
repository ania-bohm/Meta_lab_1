import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TabuSearch extends Algorithm {
    private int iter;
    private int n_size;
    private int tabu_size;
    private Problem problem;
    private List<List<Integer>> tabu_list;


    public TabuSearch(int iter, int n_size, int tabu_size, Problem problem) {
        this.iter = iter;
        this.n_size = n_size;
        this.tabu_size = tabu_size;
        this.problem = problem;
        tabu_list = new ArrayList<>();
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

    public int getTabu_size() {
        return tabu_size;
    }

    public void setTabu_size(int tabu_size) {
        this.tabu_size = tabu_size;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public List<List<Integer>> getTabu_list() {
        return tabu_list;
    }

    public void setTabu_list(List<List<Integer>> tabu_list) {
        this.tabu_list = tabu_list;
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

    //initialization: 0 - random, 1 - greedy, mutation: 0 - swap, 1 - inversion
    public Individual startSearch(int initType, int mutationType, String saveFileName, PrintWriter avg, int j) throws IOException {
        Individual currentIndividual = new Individual(problem.getDimension());
        Individual copiedCurrentIndividual = new Individual(problem.getDimension());
        // from - to
        Integer[][] neighbours;
        // fitness
        Float[] neighbourFitness;
        int currentIter = 0;
        int bestFitnessPosition = -1;

        File file = new File(j + "_" + saveFileName + ".csv");
        file.createNewFile();

        PrintWriter save = new PrintWriter(j + "_" + saveFileName + ".csv");

        if (initType == 0) {
            currentIndividual = currentIndividual.generateRandomIndividual(problem);
        } else {
            currentIndividual = GreedyAlgorithm.generateGreedyIndividual(problem, 1);
        }
        currentIndividual.setFitness(problem.calculateFitness(currentIndividual));
        if (mutationType == 0) {
            while (currentIter < iter) {
                copiedCurrentIndividual.setRouteArray(currentIndividual.getRouteArray());
                copiedCurrentIndividual.setFitness(currentIndividual.getFitness());
                // generating n_size (or less) neighbourhood
                neighbours = problem.generateNeighbourList(n_size, tabu_list);
                // evaluating fitness for every swap option
                neighbourFitness = problem.evaluateTabuFitnessSwap(copiedCurrentIndividual, neighbours);
                // choosing best fitness
                bestFitnessPosition = bestNeighborPosition(neighbourFitness);
                // checking if bestFitness < currentIndividual.fitness
                // yes - continue, no - break

                if (neighbourFitness[bestFitnessPosition] < currentIndividual.getFitness()) {
                    // setting currentIndividual to the best one found
                    currentIndividual = currentIndividual.tabuSwap(neighbours[bestFitnessPosition][0], neighbours[bestFitnessPosition][1]);
                    currentIndividual.setFitness(problem.calculateFitness(currentIndividual));
                    // checking tabu_list overflow and adding neighbour to tabu_list
                    if (tabu_list.size() == n_size) {
                        tabu_list.remove(0);
                    }
                    tabu_list.add(new ArrayList<Integer>());
                    tabu_list.get(tabu_list.size() - 1).add(neighbours[bestFitnessPosition][0]);
                    tabu_list.get(tabu_list.size() - 1).add(neighbours[bestFitnessPosition][1]);
                }
                save.println(currentIter + "; " + neighbourFitness[bestFitnessPosition] + ";" + currentIndividual.getFitness());
                // currentIter++
                currentIter++;
            }
        } else {
            while (currentIter < iter) {
                copiedCurrentIndividual.setRouteArray(currentIndividual.getRouteArray());
                copiedCurrentIndividual.setFitness(currentIndividual.getFitness());
                // generating n_size (or less) neighbourhood
                neighbours = problem.generateNeighbourList(n_size, tabu_list);
                // evaluating fitness for every inversion option
                neighbourFitness = problem.evaluateTabuFitnessInversion(copiedCurrentIndividual, neighbours);
                // choosing best fitness
                bestFitnessPosition = bestNeighborPosition(neighbourFitness);
                // checking if bestFitness < currentIndividual.fitness
                // yes - continue, no - break

                if (neighbourFitness[bestFitnessPosition] < currentIndividual.getFitness()) {
                    // setting currentIndividual to the best one found
                    currentIndividual = currentIndividual.tabuInversion(neighbours[bestFitnessPosition][0], neighbours[bestFitnessPosition][1]);
                    currentIndividual.setFitness(problem.calculateFitness(currentIndividual));
                    // checking tabu_list overflow and adding neighbour to tabu_list
                    if (tabu_list.size() == n_size) {
                        tabu_list.remove(0);
                    }
                    tabu_list.add(new ArrayList<Integer>());
                    tabu_list.get(tabu_list.size() - 1).add(neighbours[bestFitnessPosition][0]);
                    tabu_list.get(tabu_list.size() - 1).add(neighbours[bestFitnessPosition][1]);
                }
                save.println(currentIter + "; " + neighbourFitness[bestFitnessPosition] + ";" + currentIndividual.getFitness());
                // currentIter++
                currentIter++;
            }
        }
        avg.println(j + "; " + iter + "_" + n_size + "_" + tabu_size + "; " + currentIndividual.getFitness());
        save.close();
        return currentIndividual;
    }
}