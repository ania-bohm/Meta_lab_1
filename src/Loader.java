import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loader {

    private int loadedDimension;
    private int loadedCapacity;
    private List<Integer> loadedCoordXArray;
    private List<Integer> loadedCoordYArray;
    private List<Integer> loadedDemandArray;
    private float[][] distanceMatrix;

    public Loader() {
        loadedCoordXArray = new ArrayList<>();
        loadedCoordYArray = new ArrayList<>();
        loadedDemandArray = new ArrayList<>();
    }

    public int getLoadedDimension() {
        return loadedDimension;
    }

    public void setLoadedDimension(int loadedDimension) {
        this.loadedDimension = loadedDimension;
    }

    public int getLoadedCapacity() {
        return loadedCapacity;
    }

    public void setLoadedCapacity(int loadedCapacity) {
        this.loadedCapacity = loadedCapacity;
    }

    public List<Integer> getLoadedCoordXArray() {
        return loadedCoordXArray;
    }

    public void setLoadedCoordXArray(List<Integer> loadedCoordXArray) {
        this.loadedCoordXArray = loadedCoordXArray;
    }

    public List<Integer> getLoadedCoordYArray() {
        return loadedCoordYArray;
    }

    public void setLoadedCoordYArray(List<Integer> loadedCoordYArray) {
        this.loadedCoordYArray = loadedCoordYArray;
    }

    public List<Integer> getLoadedDemandArray() {
        return loadedDemandArray;
    }

    public void setLoadedDemandArray(List<Integer> loadedDemandArray) {
        this.loadedDemandArray = loadedDemandArray;
    }

    public void load(String filename) {
        try {
            File file = new File(filename + ".txt");
            Scanner scanner = new Scanner(file);
            int lineNumber = 0;
            loadedDimension = scanner.nextInt();
            System.out.println("Dimension: " + loadedDimension);
            loadedCapacity = scanner.nextInt();
            System.out.println("Capacity: " + loadedCapacity);

            scanner = this.scanCoords(scanner, lineNumber);
            scanner = this.scanDemand(scanner, lineNumber);

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public Scanner scanCoords(Scanner scanner, int lineNumber) {
        while (scanner.hasNextLine() && lineNumber < loadedDimension) {
            // omitting ordinal number
            scanner.nextInt();
            loadedCoordXArray.add(scanner.nextInt());
            System.out.println("X: " + loadedCoordXArray.get(lineNumber));
            loadedCoordYArray.add(scanner.nextInt());
            System.out.println("Y: " + loadedCoordYArray.get(lineNumber));
            lineNumber++;
        }
        return scanner;
    }

    public Scanner scanDemand(Scanner scanner, int lineNumber) {
        while (scanner.hasNextLine() && lineNumber < loadedDimension) {
            // omitting ordinal number
            scanner.nextInt();
            loadedDemandArray.add(scanner.nextInt());
            System.out.println("Demand: " + loadedDemandArray.get(lineNumber));
            lineNumber++;
        }
        return scanner;
    }

    public float[][] calculateDistance() {
        distanceMatrix = new float[loadedDimension][loadedDimension];

        for (int i = 0; i < loadedDimension; i++) {
            for (int j = 0; j < loadedDimension; j++) {
                distanceMatrix[i][j] = (float) Math.sqrt(Math.pow((loadedCoordXArray.get(i) - loadedCoordXArray.get(j)), 2) + Math.pow((loadedCoordYArray.get(i) - loadedCoordYArray.get(j)), 2));
            }
        }
        return distanceMatrix;
    }

}
