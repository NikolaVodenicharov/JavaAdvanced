import java.util.Scanner;
import java.math.BigInteger;

public class StartUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        BigInteger result = BigInteger.ONE;

        for (int i = n; i <= m; i++) {
            BigInteger num = new BigInteger("" + i);
            result = result.multiply(num);
        }

        System.out.printf("product[%d..%d] = %d", n, m, result);
    }
}