package farm.crops;

public abstract class Crop {
    protected String name;
    protected int daysToHarvest;
    protected int waterNeeds;

    public Crop(String name, int daysToHarvest, int waterNeeds) {
        this.name = name;
        this.daysToHarvest = daysToHarvest;
        this.waterNeeds = waterNeeds;
    }

    public String getName() {
        return name;
    }

    public abstract void grow();

    public abstract void harvest();
}
