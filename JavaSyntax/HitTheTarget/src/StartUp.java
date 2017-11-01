import java.util.Scanner;

public class StartUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int targetNumber = scanner.nextInt();

        for (int num1 = 1; num1 <= 20 ; num1++) {
            int num2 = targetNumber - num1;

            if (num1 <= 20 && num2 <= 20) {
                if (num2 > 0) {
                    System.out.printf("%d + %d = %d" + System.lineSeparator(), num1, num2, targetNumber);
                } else if (num2 < 0) {
                    num2 = Math.abs(num2);
                    System.out.printf("%d - %d = %d" + System.lineSeparator(), num1, num2, targetNumber);
                }
            }
        }
    }
}
