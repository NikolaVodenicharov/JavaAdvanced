import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StartUp {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        List<Integer> nums = Arrays.stream(reader.readLine().split("\\s+"))
//                .map(string -> Integer.valueOf(string))
//                .collect(Collectors.toList());

        String[] nonParsedNumbers = reader.readLine().split(" ");
        Integer[] parsedNumbers = parseIntegers(nonParsedNumbers);
        ArrayList<Integer> reversedNumbers = reverseIntegers(parsedNumbers);
        
        Integer divisor = Integer.parseInt(reader.readLine());
        
        reversedNumbers.removeIf(x -> x % divisor == 0);
        String result = collectionToString(reversedNumbers);
        System.out.println(result);
    }

    public static Integer[] parseIntegers(String[] nonParsedNumbers){
        Integer[] parsedNumbers = new Integer[nonParsedNumbers.length];
        for (int i = 0; i < nonParsedNumbers.length; i++) {
            parsedNumbers[i] = Integer.parseInt(nonParsedNumbers[i]);
        }

        return parsedNumbers;
    }
    public static ArrayList<Integer> reverseIntegers(Integer[] numbers){
        ArrayList<Integer> reversedIntegers = new ArrayList<>(numbers.length);
        for (int i = numbers.length - 1; i >= 0 ; i--) {
            reversedIntegers.add(numbers[i]);
        }
        
        return reversedIntegers;
    }
    public static String collectionToString(ArrayList<Integer> numbers){
        StringBuilder sb = new StringBuilder();
        for (Integer number : numbers) {
            sb.append(number + " ");
        }

        return sb.toString().trim();
    }
}
