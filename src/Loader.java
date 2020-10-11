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

            // loading coords
            while (scanner.hasNextLine() && lineNumber < loadedDimension) {
                loadedCoordX.add(scanner.nextInt());
                System.out.println("X: " + loadedCoordX.get(lineNumber));
                loadedCoordY.add(scanner.nextInt());
                System.out.println("Y: " + loadedCoordY.get(lineNumber));
                lineNumber++;
            }

            lineNumber = 0;

            // loading demand
            while (scanner.hasNextLine() && lineNumber < loadedDimension) {
                loadedDemand.add(scanner.nextInt());
                System.out.println("Demand: " + loadedDemand.get(lineNumber));
                lineNumber++;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}
