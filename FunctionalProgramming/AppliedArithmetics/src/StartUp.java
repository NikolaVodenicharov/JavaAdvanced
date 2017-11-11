import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class StartUp {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputNumbers = reader.readLine().split(" ");
        Integer[] numbers = parseIntegers(inputNumbers);

        while(true){
            String command = reader.readLine();

            if(command.equals("end")){
                break;
            }

            commandInterpreter(numbers, command);
        }
    }

    public static Integer[] parseIntegers(String[] nonParsedNumbers){
        Integer[] parsedNumbers = new Integer[nonParsedNumbers.length];
        for (int i = 0; i < nonParsedNumbers.length; i++) {
            parsedNumbers[i] = Integer.parseInt(nonParsedNumbers[i]);
        }

        return parsedNumbers;
    }
    public static void commandInterpreter(Integer[] numbers, String command){

        switch (command){
            case "add":
                iterateCommand(numbers, x -> x + 1);
                break;
            case "multiply":
                iterateCommand(numbers, x -> x * 2);
                break;
            case "subtract":
                iterateCommand(numbers, x -> x - 1);
                break;
            case "print":
                printNumbers(numbers);
                break;
            default:
                break;
        }
    }
    public static void iterateCommand (Integer[] numbers, Function<Integer, Integer> function){
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = function.apply(numbers[i]);
        }
    }
    public static void printNumbers(Integer[] numbers){
        Function<Integer[], String> printNumbers = nums -> {
            StringBuilder sb = new StringBuilder();
            for (Integer num : nums) {
                sb.append(num + " ");
            }

            return  sb.toString().trim();
        };

        System.out.println(printNumbers.apply(numbers));
    }
}
