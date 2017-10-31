import java.util.Scanner;

public class StartUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");
        String word1 = words[0];
        String word2 = words[1];

        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        int sum = num1 + num2 + num3;
        scanner.nextLine();

        String word3 = scanner.nextLine();

        System.out.println(word1 + " " + word2 + " " + word3 + " " + sum);
    }
}
