public class Main {

    public static void main(String[] args) {
        Loader loader = new Loader();
        loader.load("test");
        Problem problem = new Problem(loader.getLoadedDimension(), loader.getLoadedCapacity(), loader.calculateDistance(), loader.getLoadedDemandArray());
        
    }
}
