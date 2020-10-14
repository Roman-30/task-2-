package Task24;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int vaporization = 2300000;
        double starttemperature = readStartTemperature();
        double startwatermass = readStartMass();
        double startheat = readHeat();
        double temperature = calculateTemperature(starttemperature);
        double steammass = calculateMass(temperature, vaporization, startwatermass, startheat);
        double remainingwater = calculateRemainingMass(steammass, startwatermass);
        print(starttemperature, vaporization, temperature, remainingwater, startheat);
    }

    public static double readStartTemperature() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the start water temperature: ");
        return scanner.nextDouble();
    }

    public static double readHeat() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of heat: ");
        return scanner.nextDouble();
    }

    public static double readStartMass() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the start water mass: ");
        return scanner.nextDouble();
    }

    public static void print(double startTemperature, int vaporization, double temperature, double remainingwater, double startHeat) {
        if (startTemperature == 100) {
            System.out.print("Steam mass: " + calculateSteamMass(vaporization, startHeat) + " kg");
        } else {
            System.out.println("Remaining water mass: " + remainingwater + " kg");
            System.out.print("Water temperature: " + temperature + " C");
        }
    }

    public static double calculateTemperature(double starttemperature) {
        double temperatureend = 100;
        return (temperatureend - starttemperature);
    }

    public static double calculateMass(double temperature, int vaporization, double startWaterMass, double startHeat) {
        int specificheat = 4200;
        return (startHeat - (startWaterMass * specificheat * temperature)) / vaporization;
    }

    public static double calculateRemainingMass(double steammass, double startwatermass) {
        return startwatermass - steammass;
    }

    public static double calculateSteamMass(int vaporization, double startHeat) {
        return startHeat / vaporization;
    }
}