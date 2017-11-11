import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.function.Function;

public class StartUp {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputNumbers = reader.readLine().split(", ");
        Function<String, Integer> parser = s -> Integer.parseInt(s);

        int sum = 0;
        for (String inputNumber : inputNumbers) {
            sum += parser.apply(inputNumber);
        }

        String output = String.format("Count = %d" + System.lineSeparator() + "Sum = %d", inputNumbers.length, sum);
        System.out.println(output);
    }
}
