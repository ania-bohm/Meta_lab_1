import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Methods {
    public static Individual generateRandomIndividual(Problem problem) {
        Individual individual = new Individual();
        List<Integer> locationArray = problem.generateLocationArray();
        List<List<Integer>> routeArray = new ArrayList<>();
        int i = 0;
        Collections.shuffle(locationArray);

        while (!locationArray.isEmpty()) {
            if (i >= routeArray.size()) {
                routeArray.add(new ArrayList<>());
                routeArray.get(i).add(locationArray.get(0));
                locationArray.remove(0);
            } else if ((problem.getDemandArray().get(locationArray.get(0)) + individual.calculateRouteDemand(routeArray.get(i), problem)) <= problem.getCapacity()) {
                routeArray.get(i).add(locationArray.get(0));
                locationArray.remove(0);
            } else {
                i++;
            }
        }
        individual.setRouteArray(routeArray);
        if (individual.isIndividualCorrect(problem)) {
            System.out.println("Generating random individual completed successfully!");
            return individual;
        } else {
            return null;
        }
    }

    public static Individual generateGreedyIndividual(Problem problem) {
        Individual individual = new Individual();
        List<List<Integer>> routeArray = new ArrayList<>();
        List<Integer> locationArray = problem.generateLocationArray();
        List<Integer> excludedLocationArray = new ArrayList<>();
        int currentLocation = 0;
        int possibleLocation = -1;
        int i = 0;

        while (!locationArray.isEmpty()) {
            possibleLocation = problem.findNearestAvailableLocation(currentLocation, locationArray, excludedLocationArray);

            if (i >= routeArray.size()) {
                routeArray.add(new ArrayList<>());
                routeArray.get(i).add(possibleLocation);
                locationArray.remove(locationArray.indexOf(possibleLocation));
                excludedLocationArray.clear();
                currentLocation = possibleLocation;
            } else if ((problem.getDemandArray().get(possibleLocation) + individual.calculateRouteDemand(routeArray.get(i), problem)) <= problem.getCapacity()) {
                routeArray.get(i).add(possibleLocation);
                locationArray.remove(locationArray.indexOf(possibleLocation));
                excludedLocationArray.clear();
                currentLocation = possibleLocation;
            } else if ((problem.getDemandArray().get(possibleLocation) + individual.calculateRouteDemand(routeArray.get(i), problem)) > problem.getCapacity()) {
                excludedLocationArray.add(possibleLocation);
            }
            if (excludedLocationArray.size() == locationArray.size()) {
                i++;
                excludedLocationArray.clear();
                currentLocation = 0;
            }

        }

        individual.setRouteArray(routeArray);
        if (individual.isIndividualCorrect(problem)) {
            System.out.println("Generating greedy individual completed successfully!");
            return individual;
        } else {
            return null;
        }
    }
}
