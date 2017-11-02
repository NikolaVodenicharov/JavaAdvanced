import java.util.Scanner;
import java.util.HashSet;

public class StartUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashSet<Integer> firstNumbers = new HashSet<>();
        HashSet<Integer> secondNumbers = new HashSet<>();

        int firstNumbersSize = scanner.nextInt();
        int secondNumbersSize = scanner.nextInt();

        for (int i = 0; i < firstNumbersSize; i++) {
            firstNumbers.add(scanner.nextInt());
        }

        for (int i = 0; i < secondNumbersSize; i++) {
            secondNumbers.add(scanner.nextInt());
        }

        firstNumbers.retainAll(secondNumbers);
        System.out.println(firstNumbers);
    }
}
