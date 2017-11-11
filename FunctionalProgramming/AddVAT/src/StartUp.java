import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.UnaryOperator;

public class StartUp {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputNumbers = reader.readLine().split(", ");
        Double[] numbers = parseDoubles(inputNumbers);
        UnaryOperator<Double> addVAT = num -> num*1.2;

        StringBuilder sb = new StringBuilder();
        sb
                .append("Prices with VAT:")
                .append(System.lineSeparator());
        for (Double number : numbers) {
            sb
                    .append(String.format("%.2f", addVAT.apply(number)))
                    .append(System.lineSeparator());
        }


        System.out.println(sb.toString().trim().replaceAll("\\.", ","));
    }

    public static Double[] parseDoubles(String[] inputNumbers){
        Double[] parsedNumbers = new Double[inputNumbers.length];
        for (int i = 0; i < inputNumbers.length; i++) {
            parsedNumbers[i] = Double.parseDouble(inputNumbers[i]);
        }

        return parsedNumbers;
    }
}
