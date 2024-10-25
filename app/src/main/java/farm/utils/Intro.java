package farm.utils;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Intro {


    public void displayTitleScreen() {
        System.out.println(
                "                                ______                     _ _   _ \r\n" + //
                        "                               |  ____|                   (_) | | |\r\n" + //
                        "                               | |__ __ _ _ __ _ __ ___    _| |_| |\r\n" + //
                        "                               |  __/ _` | '__| '_ ` _ \\  | | __| |\r\n" + //
                        "                               | | | (_| | |  | | | | | | | | |_|_|\r\n" + //
                        "                               |_|  \\__,_|_|  |_| |_| |_| |_|\\__(_)\r\n" + //
                        "                                                                     \r\n" + //
                        "                         Farming Simulator: Grow and Sell Your Crops!                  \r\n" + //
                        ""
        );
        System.out.println("Press 'S' to start the game...");
    }

    public void waitForStart() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("S")) {
                break;
            } else {
                System.out.println("Invalid input. Press 'S' to start the game.");
            }
        }
    }

    public void displayStory() throws InterruptedException {
        String message = "You were once a skilled programmer, navigating the fast-paced world of tech. But one day, it all ended. "
                + "A layoff notice left you lost. Tired of the city and its demands, you escaped to the countryside, seeking a fresh start.\r\n"
                + "\r\n"
                + "Now, with only the open fields and a few seeds in hand, you've traded coding for farming. Can you grow a new life from the ground up, far from the digital world you once knew?";

        // Set a desired max width for each line (could be terminal width, here it's 100)
        int terminalWidth = 100; // You can adjust this value based on your terminal size or try calculating it

        // Break the message into words
        String[] words = message.split(" ");
        List<String> lines = new ArrayList<>();

        StringBuilder currentLine = new StringBuilder();
        for (String word : words) {
            if (currentLine.length() + word.length() + 1 > terminalWidth) {
                lines.add(currentLine.toString());
                currentLine = new StringBuilder(word);
            } else {
                if (currentLine.length() > 0) {
                    currentLine.append(" ");
                }
                currentLine.append(word);
            }
        }
        if (currentLine.length() > 0) {
            lines.add(currentLine.toString());
        }

        // Output each line with a delay
        for (String line : lines) {
            for (char c : line.toCharArray()) {
                System.out.print(c);
                Thread.sleep(45);
            }
            System.out.println();
        }

        System.out.println("\nPress any key to continue...");
        new Scanner(System.in).nextLine();
    }
}
