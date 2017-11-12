import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StartUp {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays
                .stream(reader.readLine().split(" "))
                .map(string -> Integer.valueOf(string))
                .collect(Collectors.toList());
        Comparator<Integer> evenBeforeOdd = (num1, num2) -> {
            if (num1 % 2 == 0 && num2 % 2 != 0){
                return -1;
            }
            else if (num1 % 2 != 0 && num2 % 2 == 0){
                return 1;
            }
            else{
                if (num1 > num2){
                    return 1;
                }
                if (num1 < num2){
                    return -1;
                }
                else{
                    return 0;
                }
            }
        };
        numbers.sort(evenBeforeOdd);
        String forPrinting = numbersToString(numbers);

        System.out.println(forPrinting);
    }

    public static String numbersToString(List<Integer> numbers){
        StringBuilder sb = new StringBuilder();
        for (Integer number : numbers) {
            sb.append(number + " ");
        }

        return sb.toString().trim();
    }
}
