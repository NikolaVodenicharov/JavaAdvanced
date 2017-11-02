import java.util.Scanner;
import java.util.TreeSet;

public class StartUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> chemicalCompounds = new TreeSet<>();

        int inputLinesNumber =Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < inputLinesNumber; i++) {
            String[] inputLine = scanner.nextLine().split("\\s+");
            for (String input : inputLine) {
                chemicalCompounds.add(input);
            }
        }

        System.out.println(chemicalCompounds);
    }
}
