import java.util.ArrayList;
import java.util.List;

public class Individual {

    private List<List<Integer>> routeArray;

    public Individual() {
        routeArray = new ArrayList<>();
    }

    public List<List<Integer>> getRouteArray() {
        return routeArray;
    }

    public void setRouteArray(List<List<Integer>> routeArray) {
        this.routeArray = routeArray;
    }

    public boolean isIndividualCorrect(Problem problem) {
        // checking capacity constraint
        for (int i = 0; i < routeArray.size(); i++) {
            if (this.calculateRouteDemand(routeArray.get(i), problem) > problem.getCapacity()) {
                return false;
            }
        }
        // checking if all locations are included (only once)
        if (!checkLocationUniqueness(problem)) {
            return false;
        }

        return true;
    }

    public int calculateRouteDemand(List<Integer> routeList, Problem problem) {
        int wholeRouteDemand = 0;
        for (int i = 0; i < routeList.size(); i++) {
            wholeRouteDemand += problem.getDemandArray().get(routeList.get(i));
        }
        return wholeRouteDemand;
    }

    public boolean checkLocationUniqueness(Problem problem) {
        int[] locationArray = problem.generateEmptyLocationMatrix();

        for (int i = 0; i < routeArray.size(); i++) {
            for (int j = 0; j < routeArray.get(i).size(); j++) {
                locationArray[routeArray.get(i).get(j) - 1]++;
            }
        }

        for (int i = 0; i < locationArray.length; i++) {
            if (locationArray[i] != 1) {
                return false;
            }
        }

        return true;
    }

    // fitness function
    public int calculateIndividualCost(Problem problem) {
        float wholeRouteCost = 0;
        int previousLocation;
        for (int i = 0; i < routeArray.size(); i++) {
            previousLocation = 0;
            for (int j = 0; j < routeArray.get(i).size(); j++) {
                wholeRouteCost += problem.getDistanceMatrix()[previousLocation][routeArray.get(i).get(j)];
                previousLocation = routeArray.get(i).get(j);
            }
            wholeRouteCost += problem.getDistanceMatrix()[0][previousLocation];
        }
        return (int) wholeRouteCost;
    }
}
