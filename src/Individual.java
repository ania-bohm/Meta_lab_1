import java.util.*;

public class Individual {
    private Integer[] routeArray;
    private float fitness;

    public Individual(int dimension) {
        routeArray = new Integer[dimension - 1];
    }

    public Integer[] getRouteArray() {
        return routeArray;
    }

    public void setRouteArray(Integer[] routeArray) {
        this.routeArray = routeArray;
    }

    public float getFitness() {
        return fitness;
    }

    public void setFitness(float fitness) {
        this.fitness = fitness;
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

    public Individual partiallyMatchedCrossover(Individual parentIndividual) {
        Individual childIndividual = new Individual(this.routeArray.length + 1);
        Integer[] childRouteArray = new Integer[this.routeArray.length];
        Random random = new Random();
        HashMap<Integer, Integer> mappedLocations = new HashMap<>();

        int rangeStart = random.nextInt(this.routeArray.length);
        int rangeEnd = random.nextInt(this.routeArray.length);

        if (rangeEnd < rangeStart) {
            int rangeTemp = rangeEnd;
            rangeEnd = rangeStart;
            rangeStart = rangeTemp;
        }

        if (rangeStart != rangeEnd) {
            for (int i = rangeStart; i <= rangeEnd; i++) {
                mappedLocations.put(parentIndividual.routeArray[i], routeArray[i]);
            }
            for (int i = 0; i < rangeStart; i++) {
                int temp = routeArray[i];
                while (mappedLocations.containsKey(temp)) {
                    temp = mappedLocations.get(temp);
                }
                childRouteArray[i] = temp;
//                if (mappedLocations.containsKey(routeArray[i])) {
//                    childRouteArray[i] = mappedLocations.get(routeArray[i]);
//                } else {
//                    childRouteArray[i] = routeArray[i];
//                }
            }
            for (int i = rangeStart; i <= rangeEnd; i++) {
                childRouteArray[i] = parentIndividual.routeArray[i];
            }

            for (int i = rangeEnd + 1; i < routeArray.length; i++) {
                int temp = routeArray[i];
                while (mappedLocations.containsKey(temp)) {
                    temp = mappedLocations.get(temp);
                }
                childRouteArray[i] = temp;
//                if (mappedLocations.containsKey(routeArray[i])) {
//                    childRouteArray[i] = mappedLocations.get(routeArray[i]);
//                } else {
//                    childRouteArray[i] = routeArray[i];
//                }
            }

            childIndividual.setRouteArray(childRouteArray);
            return childIndividual;
        }
        return this;
    }

    public Individual swap(float pm) {
        Random random = new Random();
        int firstPosition;
        int secondPosition;
        int temp;

        for (int i = 0; i < routeArray.length; i++) {
            if (random.nextFloat() < pm) {
                firstPosition = i;
                secondPosition = random.nextInt(routeArray.length);

                temp = routeArray[firstPosition];
                routeArray[firstPosition] = routeArray[secondPosition];
                routeArray[secondPosition] = temp;
            }
        }

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
