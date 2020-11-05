import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem {

    private int dimension;
    private int capacity;
    private float[][] distanceMatrix;
    private List<Integer> demandArray;

    public Problem(int dimension, int capacity, List<Integer> demandArray) {
        this.dimension = dimension;
        this.capacity = capacity;
        this.distanceMatrix = new float[dimension][dimension];
        this.demandArray = demandArray;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public float[][] getDistanceMatrix() {
        return distanceMatrix;
    }

    public void setDistanceMatrix(float[][] distanceMatrix) {
        this.distanceMatrix = distanceMatrix;
    }

    public List<Integer> getDemandArray() {
        return demandArray;
    }

    public void setDemandArray(List<Integer> demandArray) {
        this.demandArray = demandArray;
    }

    public float[][] calculateDistance(List<Integer> coordXArray, List<Integer> coordYArray) {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                distanceMatrix[i][j] = (float) Math.sqrt(Math.pow((coordXArray.get(i) - coordXArray.get(j)), 2) + Math.pow((coordYArray.get(i) - coordYArray.get(j)), 2));
            }
        }
        return distanceMatrix;
    }

    public void printDistanceMatrix() {
        for (int i = 0; i < distanceMatrix.length; i++) {
            for (int j = 0; j < distanceMatrix.length; j++) {
                System.out.print((int) distanceMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public Integer[][] generateEmptyLocationMatrix() {
        Integer[][] locationMatrix = new Integer[dimension][dimension];
        for (int i = 0; i < locationMatrix.length; i++) {
            for (int j = 0; j < locationMatrix.length; j++) {
                locationMatrix[i][j] = 0;
            }
        }
        return locationMatrix;
    }

    public List<Integer> generateLocationArrayList() {
        List<Integer> locationArray = new ArrayList<>();
        for (int i = 1; i < dimension; i++) {
            locationArray.add(i);
        }
        return locationArray;
    }

    public Integer[] generateLocationArray() {
        Integer[] locationArray = new Integer[dimension - 1];
        for (int i = 0; i < dimension - 1; i++) {
            locationArray[i] = i + 1;
        }
        return locationArray;
    }

    public int findNearestAvailableLocation(int startLocation, List<Integer> availableLocationArray) {
        float smallestDistance = Float.MAX_VALUE;
        int nearestLocation = -1;
        for (int i = 1; i < distanceMatrix.length; i++) {
            if (distanceMatrix[startLocation][i] <= smallestDistance && startLocation != i && availableLocationArray.contains(i)) {
                smallestDistance = distanceMatrix[startLocation][i];
                nearestLocation = i;
            }
        }
        return nearestLocation;
    }

    public float calculateFitness(Individual individual) {
        float currentDistance = 0;
        float wholeDistance = 0;
        int currentDemand = 0;
        int previousLocation = 0;
        for (int i = 0; i < individual.getRouteArray().length; i++) {
            currentDemand += demandArray.get(individual.getRouteArray()[i]);
            if (currentDemand <= capacity) {
                currentDistance += distanceMatrix[previousLocation][individual.getRouteArray()[i]];
                previousLocation = individual.getRouteArray()[i];
            } else {
                currentDistance += distanceMatrix[previousLocation][0];
                wholeDistance += currentDistance;
                currentDemand = demandArray.get(individual.getRouteArray()[i]);
                currentDistance = distanceMatrix[0][individual.getRouteArray()[i]];
                previousLocation = individual.getRouteArray()[i];
            }
            if (i == individual.getRouteArray().length - 1) {
                currentDistance += distanceMatrix[individual.getRouteArray()[i]][0];
                wholeDistance += currentDistance;
            }
        }
        return wholeDistance;
    }

    public Float[] evaluateTabuFitnessSwap(Individual individual, Integer[][] neighbours) {
        Float[] neighboursFitness = new Float[neighbours.length];
        for (int i = 0; i < neighboursFitness.length; i++) {
            individual = individual.tabuSwap(neighbours[i][0], neighbours[i][1]);
            neighboursFitness[i] = calculateFitness(individual);
            individual = individual.tabuSwap(neighbours[i][0], neighbours[i][1]);
        }
        return neighboursFitness;
    }

    public Float[] evaluateTabuFitnessInversion(Individual individual, Integer[][] neighbours) {
        Float[] neighboursFitness = new Float[neighbours.length];
        for (int i = 0; i < neighboursFitness.length; i++) {
            individual = individual.tabuInversion(neighbours[i][0], neighbours[i][1]);
            neighboursFitness[i] = calculateFitness(individual);
            individual = individual.tabuInversion(neighbours[i][0], neighbours[i][1]);
        }
        return neighboursFitness;
    }

    public Integer[][] generateNeighbourList(int n_size, List<List<Integer>> tabu_list) {
        Integer[][] locationMatrix = generateEmptyLocationMatrix();
        List<List<Integer>> availableLocationsList = new ArrayList<>();
        int numberOfLocations = 0;
        for (int i = 0; i < locationMatrix.length; i++) {
            locationMatrix[0][i] = -1;
            locationMatrix[i][0] = -1;
        }
        for (int i = 0; i < tabu_list.size(); i++) {
            locationMatrix[tabu_list.get(i).get(0)][tabu_list.get(i).get(1)] = -1;
            locationMatrix[tabu_list.get(i).get(1)][tabu_list.get(i).get(0)] = -1;
        }
        for (int i = 1; i < locationMatrix.length; i++) {
            for (int j = 1; j < locationMatrix.length; j++) {
                if (locationMatrix[i][j] != -1) {
                    availableLocationsList.add(new ArrayList<>());
                    availableLocationsList.get(availableLocationsList.size() - 1).add(i);
                    availableLocationsList.get(availableLocationsList.size() - 1).add(j);
                    locationMatrix[j][i] = -1;
                }
            }
        }
        Collections.shuffle(availableLocationsList);
        numberOfLocations = availableLocationsList.size();
        Integer[][] neighbourList;
        if (numberOfLocations < n_size) {
            neighbourList = new Integer[numberOfLocations][2];
            for (int i = 0; i < numberOfLocations; i++) {
                neighbourList[i][0] = availableLocationsList.get(i).get(0);
                neighbourList[i][1] = availableLocationsList.get(i).get(1);
            }
        } else {
            neighbourList = new Integer[n_size][2];
            for (int i = 0; i < n_size; i++) {
                neighbourList[i][0] = availableLocationsList.get(i).get(0);
                neighbourList[i][1] = availableLocationsList.get(i).get(1);
            }
        }
        return neighbourList;
    }

    public Integer[][] generateNeighbourListSA(int n_size) {
        Integer[][] locationMatrix = generateEmptyLocationMatrix();
        List<List<Integer>> availableLocationsList = new ArrayList<>();
        int numberOfLocations = 0;
        for (int i = 0; i < locationMatrix.length; i++) {
            locationMatrix[0][i] = -1;
            locationMatrix[i][0] = -1;
        }
        for (int i = 1; i < locationMatrix.length; i++) {
            for (int j = 1; j < locationMatrix.length; j++) {
                if (locationMatrix[i][j] != -1) {
                    availableLocationsList.add(new ArrayList<>());
                    availableLocationsList.get(availableLocationsList.size() - 1).add(i);
                    availableLocationsList.get(availableLocationsList.size() - 1).add(j);
                    locationMatrix[j][i] = -1;
                }
            }
        }
        Collections.shuffle(availableLocationsList);
        numberOfLocations = availableLocationsList.size();
        Integer[][] neighbourList;
        if (numberOfLocations < n_size) {
            neighbourList = new Integer[numberOfLocations][2];
            for (int i = 0; i < numberOfLocations; i++) {
                neighbourList[i][0] = availableLocationsList.get(i).get(0);
                neighbourList[i][1] = availableLocationsList.get(i).get(1);
            }
        } else {
            neighbourList = new Integer[n_size][2];
            for (int i = 0; i < n_size; i++) {
                neighbourList[i][0] = availableLocationsList.get(i).get(0);
                neighbourList[i][1] = availableLocationsList.get(i).get(1);
            }
        }
        return neighbourList;
    }

}
