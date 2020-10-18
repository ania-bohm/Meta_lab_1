import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GreedyAlgorithm extends Algorithm {

    public static Individual generateGreedyIndividual(Problem problem, int startLocation) {
        Individual individual = new Individual(problem.getDimension());
        Integer[] routeArray = new Integer[problem.getDimension() - 1];
        List<Integer> locationArray = problem.generateLocationArrayList();
        int currentLocation = startLocation;
        int possibleLocation = -1;
        int i = 0;

        routeArray[i] = currentLocation;
        locationArray.remove(locationArray.indexOf(currentLocation));
        i++;

        while (!locationArray.isEmpty()) {
            possibleLocation = problem.findNearestAvailableLocation(currentLocation, locationArray);
            routeArray[i] = possibleLocation;
            locationArray.remove(locationArray.indexOf(possibleLocation));
            currentLocation = possibleLocation;
            i++;
        }
        individual.setRouteArray(routeArray);
        return individual;
    }

}
