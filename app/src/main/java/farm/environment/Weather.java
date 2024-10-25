package farm.environment;

import java.util.Random;

public class Weather {
    private String currentWeather;
    private String[] weatherTypes = {"Sunny", "Rainy", "Cloudy", "Stormy"};

    public Weather() {
        currentWeather = "Sunny"; // Default weather at start
    }

    public void changeWeather(int day) {
        Random random = new Random();

        // Change weather every day
        currentWeather = weatherTypes[random.nextInt(weatherTypes.length)];

        // Announce the new weather
        System.out.println("Day " + day + ": The weather today is " + currentWeather + ".");
    }

    public String getCurrentWeather() {
        return currentWeather;
    }

    public String getSeason(int day) {
        int seasonLength = 7; // Each season lasts for 7 days

        if (day <= seasonLength) {
            return "Spring";
        } else if (day <= seasonLength * 2) {
            return "Summer";
        } else if (day <= seasonLength * 3) {
            return "Autumn";
        } else {
            return "Winter";
        }
    }

    public void displaySeason(int day) {
        String season = getSeason(day);
        System.out.println("It's currently " + season + ".");
    }
}
