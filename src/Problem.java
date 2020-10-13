import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

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

    public int[] generateEmptyLocationMatrix() {
        int[] locationMatrix = new int[dimension - 1];
        for (int i = 0; i < locationMatrix.length - 1; i++) {
            locationMatrix[i] = 0;
        }
        return locationMatrix;
    }

    public List<Integer> generateLocationArray() {
        List<Integer> locationArray = new ArrayList<>();
        for (int i = 1; i < dimension; i++) {
            locationArray.add(i);
        }
        return locationArray;
    }

    public Individual generateRandomIndividual() {
        Individual individual = new Individual();
        List<Integer> locationArray = generateLocationArray();
        List<List<Integer>> routeArray = new ArrayList<>();
        int i = 0;
        Collections.shuffle(locationArray);

        while (!locationArray.isEmpty()) {
            if (i >= routeArray.size()) {
                routeArray.add(new ArrayList<>());
                routeArray.get(i).add(locationArray.get(0));
                locationArray.remove(0);
            } else if ((demandArray.get(locationArray.get(0)) + individual.calculateRouteDemand(routeArray.get(i), this)) <= capacity) {
                routeArray.get(i).add(locationArray.get(0));
                locationArray.remove(0);
            } else {
                i++;
            }
        }
        individual.setRouteArray(routeArray);
        if (individual.isIndividualCorrect(this)) {
            System.out.println("Generating random individual completed successfully!");
            return individual;
        } else {
            return null;
        }
    }
}
