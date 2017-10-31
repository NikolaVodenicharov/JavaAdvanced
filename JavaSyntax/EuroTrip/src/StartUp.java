import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class StartUp {
    public static void main(String[] args) {
        BigDecimal exchangeRateDMtoBGN = new BigDecimal(4210500000000l);
        double exchangeRateWurstToBGN = 1.2D;

        Scanner scanner = new Scanner(System.in);
        double wurstQuantity = Double.parseDouble(scanner.nextLine());

        BigDecimal levaPrice = new BigDecimal(exchangeRateWurstToBGN * wurstQuantity);
        BigDecimal result = exchangeRateDMtoBGN.multiply(levaPrice);

        System.out.printf("%.2f marks", result);
    }
}
