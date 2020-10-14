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

    public int findNearestAvailableLocation(int startLocation, List<Integer> availableLocationArray, List<Integer> excludedLocationArray) {
        float smallestDistance = Float.MAX_VALUE;
        int nearestLocation = -1;
        for (int i = 0; i < distanceMatrix.length; i++) {
            if (distanceMatrix[startLocation][i] <= smallestDistance && startLocation != i && availableLocationArray.contains(i) && !excludedLocationArray.contains(i)) {
                smallestDistance = distanceMatrix[startLocation][i];
                nearestLocation = i;
            }
        }
        return nearestLocation;
    }

}
