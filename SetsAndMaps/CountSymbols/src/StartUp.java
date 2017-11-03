import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class StartUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] inputSymbols = scanner.nextLine().toCharArray();

        TreeMap<Character, Integer> symbolsCount = new TreeMap<>();
        for (char symbol : inputSymbols) {

            if (!symbolsCount.containsKey(symbol)){
                symbolsCount.put(symbol, 1);
            }
            else{
                symbolsCount.put(symbol, symbolsCount.get(symbol) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : symbolsCount.entrySet()) {
            System.out.printf("%s: %d time/s" + System.lineSeparator(), entry.getKey(), entry.getValue());
        }
    }
}
