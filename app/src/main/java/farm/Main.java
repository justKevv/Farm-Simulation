package farm;

import farm.environment.Land;
import farm.environment.Weather;
import farm.player.Player;
import farm.store.Store;
import farm.utils.Intro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Intro intro = new Intro();
        intro.displayTitleScreen();
        intro.waitForStart();
        intro.displayStory();

        // Clear the screen before proceeding to the main menu
        clearTerminal();

        Player player = new Player(100, 50); // 100 energy, 50 money
        Land land = new Land(player);
        Store shop = new Store(player);
        Weather weather = new Weather();
        int day = 1;

        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("Day: " + day + " | Energy: " + player.getEnergy() + " | Money: $" + player.getMoney());
            System.out.println("1. Go to Land");
            System.out.println("2. Go to Shop");
            System.out.println("3. Check Inventory");
            System.out.println("4. Go to Sleep");
            System.out.println("5. Exit");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    land.manageLand(weather.getSeason(day));
                    break;
                case 2:
                    shop.visitShop();
                    break;

                case 3:
                System.out.println("\n=== Inventory ===");
                player.getInventory().displayInventory();

                System.out.println("1. Return to Main Menu");

                System.out.print("Choose an option: ");
                choice = scanner.nextInt();

                if (choice == 1) {
                    break;
                }

                case 4:
                    if (player.getEnergy() < 20) {
                        day++;
                        player.resetEnergy();
                        weather.changeWeather(day);
                    } else {
                        System.out.println("You don't need sleep right now.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting game...");
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    // Clear terminal for a fresh screen after the intro
    public static void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
