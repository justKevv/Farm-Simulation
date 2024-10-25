package farm.crops;

public class Corn extends Crop {

    public Corn() {
        super("Corn", 5, 10);
    }

    @Override
    public void grow() {
        System.out.println("Corn is growing...");
    }

    @Override
    public void harvest() {
        System.out.println("Corn is harvested.");
    }
}
