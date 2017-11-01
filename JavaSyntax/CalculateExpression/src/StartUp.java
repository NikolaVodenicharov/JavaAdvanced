import java.util.Scanner;

public class StartUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double formula1 = Math.pow(((a * a + b * b) / (a * a - b * b)), ((a + b + c)/ Math.sqrt(c)));
        double formula2 = Math.pow((a * a + b * b - c * c * c), (a - b));
        double formula3 = Math.abs(((a + b + c) / 3) - ((formula1 + formula2) / 2));

        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", formula1, formula2, formula3);
    }
}
