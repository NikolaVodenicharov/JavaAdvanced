import java.util.Scanner;

public class StartUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        String hexadecimal = Integer.toHexString(a).toUpperCase();
        String binary = Integer.toBinaryString(a);
        String binaryPrint = String.format("%10s", binary).replace(" ", "0");
        String twoDigitAfterDecimal = String.format("%.2f", b);
        String threeDigitAfterDecimal = String.format("%.3f", c);

        System.out.printf("|%-10s|%s|%10s|%-10s|", hexadecimal, binaryPrint, twoDigitAfterDecimal, threeDigitAfterDecimal);
    }
}


