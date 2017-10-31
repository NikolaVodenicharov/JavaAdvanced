import java.util.Scanner;

public class StartUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double distance = Double.parseDouble(scanner.nextLine());
        String dayNightCycle = scanner.nextLine();

        double cheapestTravelPrice = CheapestTravel(distance, dayNightCycle);

        System.out.printf("%.2f", cheapestTravelPrice);
    }

    public static Double CheapestTravel(double distance, String dayNightCycle){
        double price = 0;

        if (distance < 20){
            price = TaxiPriceCalculator(distance, dayNightCycle);
        }
        else if (distance >= 20 && distance < 100){
            price = BustPriceCalculator(distance);

        }
        else{
            price = TraintPriceCalculator(distance);
        }

        return  price;
    }
    public static Double TaxiPriceCalculator(double distance, String dayNightCycle){
        double initialTax = 0.70;
        double daytimeCostPerKm = 0.79;
        double nighttimeCostPerKm = 0.90;
        boolean isDay = dayNightCycle.equals("day");
        double result = 0;

        result += initialTax;
        if (isDay){
            result += distance * daytimeCostPerKm;
        }
        else{
            result  += distance * nighttimeCostPerKm;
        }

        return result;
    }
    public static Double BustPriceCalculator(double distane){
        double costPerKm = 0.09;
        double result = costPerKm * distane;

        return result;
    }
    public static Double TraintPriceCalculator(double distane){
        double costPerKm = 0.06;
        double result = costPerKm * distane;

        return result;
    }
}
