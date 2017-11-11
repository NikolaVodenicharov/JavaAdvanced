import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StartUp {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //List<String> inputNumbers = Arrays.asList(reader.readLine().split(", "));
        String[] inputNumbers = reader.readLine().split("[,\\s]+");
        ArrayList<Integer> numbers = parseIntegers(inputNumbers);

        numbers.removeIf(n -> n % 2 != 0);
        printNumbers(numbers);

        numbers.sort((a,b) -> a.compareTo(b));
        printNumbers(numbers);
    }

    public static ArrayList<Integer> parseIntegers(String[] collection){
        ArrayList<Integer> numbers = new ArrayList<>(collection.length);
        for (String s : collection) {
            numbers.add(Integer.parseInt(s));
        }

        return numbers;
    }
    public static void printNumbers (ArrayList<Integer> numbers){
        StringBuilder sb = new StringBuilder();
        for (Integer number : numbers) {
            sb.append(number + ", ");
        }
        sb.delete(sb.length() - 2, sb.length());

        System.out.println(sb);
    }
}
