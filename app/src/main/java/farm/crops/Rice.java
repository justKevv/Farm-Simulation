package farm.crops;

public class Rice extends Crop{
    public Rice() {
        super("Rice", 2, 3);
    }

    @Override
    public void grow() {
        System.out.println("Rice is growing...");
    }

    @Override
    public void harvest() {
        System.out.println("Rice is harvested.");
    }

}
