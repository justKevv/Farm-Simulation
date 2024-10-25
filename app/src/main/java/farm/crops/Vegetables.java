package farm.crops;

public class Vegetables extends Crop {
    public Vegetables() {
        super("Vegetables", 3, 15);
    }

    @Override
    public void grow() {
        System.out.println("Vegetables are growing...");
    }

    @Override
    public void harvest() {
        System.out.println("Vegetables are harvested.");
    }
}
