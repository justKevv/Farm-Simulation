package farm.environment;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import farm.crops.Crop;
import farm.crops.Corn;
import farm.crops.Rice;
import farm.crops.Vegetables;
import farm.player.Player;

public class Land {
    private Player player;
    private Random random;
    private List<Crop> plantedCrops;
    private List<Boolean> wateredCrops;


    public Land(Player player) {
        this.player = player;
        this.random = new Random();
        this.plantedCrops = new ArrayList<>();
        this.wateredCrops = new ArrayList<>();
    }

    public void manageLand(String season) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayPlantedCrop();

            System.out.println("\n=== LAND MENU ===");
            System.out.println("1. Plant Crops");
            System.out.println("2. Water Crops");
            System.out.println("3. Harvest Crops");
            System.out.println("4. Return to Main Menu");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    plantCrops(season);
                    break;
                case 2:
                    waterCrops();
                    break;
                case 3:
                    harvestCrops();
                    break;
                case 4:
                    return; // Return to main menu
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    private void plantCrops(String season) {
        if (player.getInventory().hasItem("Spring Seed")) {
            System.out.println("You plant crops, but make sure it's the right season!");

            if (season.equals("Spring")) {
                if (random.nextInt(10) < 3) { // 30% chance crops get sick
                    System.out.println("Oh no! Your crops got sick. You need to replace them.");
                    player.decreaseEnergy(10);
                    player.getInventory().removeItem("Spring Seed", 1);
                } else {
                    player.decreaseEnergy(10); // Planting crops costs energy
                    System.out.println("You planted healthy crops!");

                    // Randomly select a crop type from the available crops
                    Crop[] cropTypes = {new Corn(), new Rice(), new Vegetables()};
                    Crop randomCrop = cropTypes[random.nextInt(cropTypes.length)];

                    plantedCrops.add(randomCrop); // Add a new crop to the list
                    wateredCrops.add(false); // Initialize watering status for the new crop
                    player.getInventory().removeItem("Spring Seed", 1);
                }
            } else {
                System.out.println("You cannot plant crops outside of Spring!");
            }
        } else {
            System.out.println("You need to have 'Spring Seed' in your inventory to plant crops.");
        }
    }

    private void harvestCrops() {
        if (!plantedCrops.isEmpty()) {
            for (int i = 0; i < plantedCrops.size(); i++) {
                Crop crop = plantedCrops.get(i);
                System.out.println("You harvest crop #" + (i + 1) + ": " + crop.getName());
                player.decreaseEnergy(20); // Harvesting costs energy

                // Randomly select a crop type from the available crops
                Crop[] cropTypes = {new Corn(), new Rice(), new Vegetables()};
                Crop randomCrop = cropTypes[random.nextInt(cropTypes.length)];

                player.getInventory().addItem(randomCrop.getName(), 1); // Add harvested crop to inventory
            }
            plantedCrops.clear(); // Remove all harvested crops from the land
            wateredCrops.clear(); // Reset watering status for all crops
        } else {
            System.out.println("There are no crops to harvest.");
        }
    }
    private void displayPlantedCrop() {
        if (!plantedCrops.isEmpty()) {
            for (int i = 0; i < plantedCrops.size(); i++) {
                Crop crop = plantedCrops.get(i);
                System.out.println("Crop #" + (i + 1) + ": " + crop.getName());
                if (wateredCrops.get(i)) {
                    System.out.println("Watered: Yes");
                } else {
                    System.out.println("Watered: No");
                }
            }
        } else {
            System.out.println("No crops planted.");
        }
    }

    private void waterCrops() {
        if (!plantedCrops.isEmpty()) {
            for (int i = 0; i < plantedCrops.size(); i++) {
                if (!wateredCrops.get(i)) {
                    System.out.println("You water crop #" + (i + 1) + ": " + plantedCrops.get(i).getName());
                    player.decreaseEnergy(5); // Watering costs energy
                    wateredCrops.set(i, true); // Mark the crop as watered
                } else {
                    System.out.println("Crop #" + (i + 1) + " has already been watered today.");
                }
            }
        } else {
            System.out.println("There are no crops to water.");
        }
    }
}
