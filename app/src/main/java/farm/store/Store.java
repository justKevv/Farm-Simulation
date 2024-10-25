package farm.store;

import farm.crops.Crop;
import farm.player.Player;

import java.util.Scanner;

public class Store {
    private Player player;

    public Store(Player player) {
        this.player = player;
    }

    public void visitShop() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== SHOP MENU ===");
            System.out.println("1. Buy Seeds ($10 each)");
            System.out.println("2. Sell Crops");
            System.out.println("3. Return to Main Menu");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("You buy seeds.");
                    player.spendMoney(10);
                    player.getInventory().addItem("Spring Seed", 1); // Add the bought seed to the inventory
                    break;
                case 2:
                    sellCrops();
                    break;
                case 3:
                    return; // Return to main menu
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

 private void sellCrops() {
    Scanner scanner = new Scanner(System.in);
    if (!player.getInventory().hasItem("Corn") && !player.getInventory().hasItem("Rice") && !player.getInventory().hasItem("Vegetables")) {
        System.out.println("You have no crops to sell.");
        return;
    }

    player.getInventory().displayInventory();

    System.out.print("Which crop would you like to sell (Corn, Rice, Vegetables)? ");
    String crop = scanner.nextLine();

    if (player.getInventory().hasItem(crop)) {
        System.out.print("How many would you like to sell? ");
        int amount = scanner.nextInt();

        player.getInventory().removeItem(crop, amount);
        player.gainMoney(amount * 20); // Assume each crop sells for $20
        System.out.println("You sold " + amount + " " + crop + "(s).");
    } else {
        System.out.println("You don't have that crop.");
    }
}
}
