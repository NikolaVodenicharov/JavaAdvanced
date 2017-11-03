import java.util.Map;
import java.util.Scanner;
import java.util.HashSet;
import java.util.HashMap;

public class StartUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, HashSet<String>> players = new HashMap<String, HashSet<String>>();

        updatePlayers(scanner, players);
        printPlayersCardsValue(players);
    }

    public static void updatePlayers(Scanner scanner, HashMap<String, HashSet<String>> players){
        while(true){
            String inputLine = scanner.nextLine();

            if (isLoopEnd(inputLine)){
                break;
            }

            String[] splitInput = inputLine.split(": ");
            String name = splitInput[0];
            String[] cards = splitInput[1].split(", ");

            createPlayer(name, players);
            addCardsToPlayer(name, players, cards);
        }
    }
    public static boolean isLoopEnd(String inputLine){
        boolean isEnd = inputLine.equals("JOKER");
        return isEnd;
    }
    public static void createPlayer(String name, HashMap<String, HashSet<String>> players){
        if (!players.containsKey(name)) {
            players.put(name, new HashSet<String>());
        }
    }
    public static void addCardsToPlayer(String name, HashMap<String, HashSet<String>> players, String[] cards){
        for (String card : cards) {
            players.get(name).add(card);
        }
    }

    public static void printPlayersCardsValue(HashMap<String, HashSet<String>> players){
        for (Map.Entry<String, HashSet<String>> entry : players.entrySet()) {
            System.out.printf(
                    "%s: %d" + System.lineSeparator(),
                    entry.getKey(),
                    calculateTotalCardsValue(entry.getValue()));
        }
    }
    public static Integer calculateTotalCardsValue(HashSet<String> cards){
        int sum = 0;
        for (String card : cards) {
            sum += calculateCardValue(card);
        }

        return sum;
    }
    public static Integer calculateCardValue(String card){
        String power = card.substring(0, card.length()-1);
        String type = card.substring(card.length()-1);

        int powerValue = getCardPowerValue(power);
        int typeValue = getCardTypeValue(type);

        int result = powerValue * typeValue;
        return  result;
    }
    public static Integer getCardTypeValue (String type){
        int typeValue = 0;

        switch (type){
            case "C":
                typeValue = 1;
                break;
            case "D":
                typeValue = 2;
                break;
            case "H":
                typeValue = 3;
                break;
            case "S":
                typeValue = 4;
                break;
            default:
                break;
        }

        return typeValue;
    }
    public static Integer getCardPowerValue (String power){
        int powerValue = 0;

        if (Character.isLetter(power.charAt(0))){
            switch (power){
                case "J":
                    powerValue = 11;
                    break;
                case "Q":
                    powerValue = 12;
                    break;
                case "K":
                    powerValue = 13;
                    break;
                case "A":
                    powerValue = 14;
                    break;
                default:
                    break;
            }
        }
        else{
            powerValue = Integer.parseInt(power);
        }

        return powerValue;
    }

}
