import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loader {

    private int loadedDimension;
    private int loadedCapacity;
    private List<Integer> loadedCoordX;
    private List<Integer> loadedCoordY;
    private List<Integer> loadedDemand;

    public Loader()
    {
        loadedCoordX = new ArrayList<>();
        loadedCoordY = new ArrayList<>();
        loadedDemand = new ArrayList<>();
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

    public List<Integer> getLoadedCoordX() {
        return loadedCoordX;
    }

    public void setLoadedCoordX(List<Integer> loadedCoordX) {
        this.loadedCoordX = loadedCoordX;
    }

    public List<Integer> getLoadedCoordY() {
        return loadedCoordY;
    }

    public void setLoadedCoordY(List<Integer> loadedCoordY) {
        this.loadedCoordY = loadedCoordY;
    }

    public List<Integer> getLoadedDemand() {
        return loadedDemand;
    }

    public void setLoadedDemand(List<Integer> loadedDemand) {
        this.loadedDemand = loadedDemand;
    }

    public void load(String filename)
    {
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

    public Scanner scanCoords(Scanner scanner, int lineNumber)
    {
        while (scanner.hasNextLine() && lineNumber < loadedDimension) {
            // omitting ordinal number
            scanner.nextInt();
            loadedCoordX.add(scanner.nextInt());
            System.out.println("X: " + loadedCoordX.get(lineNumber));
            loadedCoordY.add(scanner.nextInt());
            System.out.println("Y: " + loadedCoordY.get(lineNumber));
            lineNumber++;
        }
        return scanner;
    }

    public Scanner scanDemand(Scanner scanner, int lineNumber)
    {
        while (scanner.hasNextLine() && lineNumber < loadedDimension) {
            // omitting ordinal number
            scanner.nextInt();
            loadedDemand.add(scanner.nextInt());
            System.out.println("Demand: " + loadedDemand.get(lineNumber));
            lineNumber++;
        }
        return scanner;
    }


}
