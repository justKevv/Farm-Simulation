package farm.player;

public class Player {
    private int money;
    private int energy;
    private Inventory inventory;
    public Player(int money, int energy) {
        this.money = money;
        this.energy = energy;
        this.inventory = new Inventory();
    }


    public void spendMoney(int amount) {
        if (money >= amount) {
            money -= amount;
            System.out.println("Spent " + amount + " money.");
        } else {
            System.out.println("Not enough money.");
        }
    }

    public void decreaseEnergy(int amount) {
        if (energy >= amount) {
            energy -= amount;
            System.out.println("Spent " + amount + " energy.");
        } else {
            System.out.println("You don't have enough energy.");
        }
    }

    public void resetEnergy() {
        energy = 100;
        System.out.println("You had a good rest. Energy restored to 100.");
    }

    public void displayStatus() {
        System.out.println("\n=== Player Status ===");
        System.out.println("Energy: " + energy);
        System.out.println("Money: $" + money);
        inventory.displayInventory(); // Display inventory along with player status
    }


    public void gainMoney(int amount) {
        money += amount;
        System.out.println("Gained " + amount + " money.");
    }

    public int getMoney() {
        return money;
    }

    public int getEnergy() {
        return energy;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
