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

    public Individual swap() {
        Random random = new Random();
        int firstPosition;
        int secondPosition;
        int temp;

        firstPosition = random.nextInt(routeArray.length);
        secondPosition = random.nextInt(routeArray.length);

        temp = routeArray[firstPosition];
        routeArray[firstPosition] = routeArray[secondPosition];
        routeArray[secondPosition] = temp;

        return this;
    }

    public Individual inversion() {
        Random random = new Random();
        int firstPosition;
        int secondPosition;
        int temp;
        int range;

        firstPosition = random.nextInt(routeArray.length);
        secondPosition = random.nextInt(routeArray.length);

        if (firstPosition > secondPosition) {
            temp = firstPosition;
            firstPosition = secondPosition;
            secondPosition = temp;
        }

        if (firstPosition != secondPosition) {
            range = secondPosition - firstPosition + 1;
            Integer[] tempArray = new Integer[range];
            for (int i = firstPosition; i <= secondPosition; i++) {
                tempArray[i - firstPosition] = routeArray[i];
            }
            for (int i = range; i > 0; i--) {
                routeArray[firstPosition] = tempArray[i - 1];
                firstPosition++;
            }
        }
        return this;
    }
}
