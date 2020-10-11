import java.util.ArrayList;
import java.util.List;

public class Problem {

    private int dimension;
    private int capacity;
    private float[][] distanceMatrix;
    private List<Integer> demandArray;

    public Problem(int dimension, int capacity, float[][] distanceMatrix, List<Integer> demandArray) {
        this.dimension = dimension;
        this.capacity = capacity;
        this.distanceMatrix = distanceMatrix;
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

}
