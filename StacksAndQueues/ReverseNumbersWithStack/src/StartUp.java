import java.util.Scanner;
import java.util.ArrayDeque;

public class StartUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        ArrayDeque<String> numbers = new ArrayDeque<String>();

        for (int i = 0; i < input.length; i++) {
            numbers.push(input[i]);
        }

        while(numbers.size() > 0){
            System.out.printf("%s ", numbers.pop());
        }
    }
}
