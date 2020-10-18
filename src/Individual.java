import java.util.*;

public class Individual {
    private Integer[] routeArray;

    public Individual(int dimension) {
        routeArray = new Integer[dimension - 1];
    }

    public Integer[] getRouteArray() {
        return routeArray;
    }

    public void setRouteArray(Integer[] routeArray) {
        this.routeArray = routeArray;
    }

    public Individual generateRandomIndividual(Problem problem) {
        Integer[] locationArray = problem.generateLocationArray();
        Collections.shuffle(Arrays.asList(locationArray));
        routeArray = locationArray;
        return this;
    }

    public void printRouteArray() {
        System.out.print("[");
        for (int i = 0; i < routeArray.length; i++) {
            if (i != routeArray.length - 1) {
                System.out.print(routeArray[i] + ", ");
            } else {
                System.out.print(routeArray[i]);
            }
        }
        System.out.print("]\n");
    }

    public Individual orderedCrossover(Individual parentIndividual) {
        int routeArrayLength = this.routeArray.length;
        Individual childIndividual = new Individual(routeArrayLength + 1);
        Integer[] childRouteArray = new Integer[routeArrayLength];
        List<Integer> usedLocations = new ArrayList<>();
        Random random = new Random();
        
        int rangeStart = random.nextInt(routeArrayLength);
        int rangeEnd = random.nextInt(routeArrayLength);

        if (rangeEnd < rangeStart) {
            int rangeTemp = rangeEnd;
            rangeEnd = rangeStart;
            rangeStart = rangeTemp;
        }

        for (int i = rangeStart; i <= rangeEnd; i++) {
            childRouteArray[i] = this.getRouteArray()[i];
            usedLocations.add(childRouteArray[i]);
        }

        for (int i = 0; i < rangeStart; i++) {
            for (int j = 0; j < routeArrayLength; j++) {
                if (!usedLocations.contains(parentIndividual.getRouteArray()[j])) {
                    childRouteArray[i] = parentIndividual.getRouteArray()[j];
                    usedLocations.add(childRouteArray[i]);
                    break;
                }
            }
        }

        for (int i = rangeEnd + 1; i < routeArrayLength; i++) {
            for (int j = 0; j < routeArrayLength; j++) {
                if (!usedLocations.contains(parentIndividual.getRouteArray()[j])) {
                    childRouteArray[i] = parentIndividual.getRouteArray()[j];
                    usedLocations.add(childRouteArray[i]);
                    break;
                }
            }
        }
        childIndividual.setRouteArray(childRouteArray);
        return childIndividual;
    }
}
