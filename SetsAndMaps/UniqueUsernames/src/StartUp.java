import java.util.Scanner;
import java.util.LinkedHashSet;

public class StartUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<String> names = new LinkedHashSet<>();
        int inputLinesNumber = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < inputLinesNumber; i++) {
            names.add(scanner.nextLine());
        }

        for (String name : names) {
            System.out.println(name);
        }
    }
}
