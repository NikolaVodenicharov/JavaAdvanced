import java.util.Scanner;
import  java.util.stream.Collectors;

public class StartUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] nonParsedNumbers = scanner.nextLine().split("\\s+");
        int len = nonParsedNumbers.length;
        boolean isValidLength = isNumberEven(len);

        if (isValidLength){

            int[] parsedNumbers = new int[len];

            for (int i = 0; i < len; i++) {
                parsedNumbers[i] = Integer.parseInt(nonParsedNumbers[i]);
            }

            for (int i = 0; i < len; i += 2) {
                int num1 = parsedNumbers[i];
                int num2 = parsedNumbers[i + 1];

                boolean areBothNumbersEven = isNumberEven(num1) && isNumberEven(num2);
                boolean areBothNumbersOdd = !isNumberEven(num1) && !isNumberEven(num2);

                System.out.printf("%d, %d -> ", num1, num2);
                if (areBothNumbersOdd){
                    System.out.println("both are odd");
                }
                else if (areBothNumbersEven){
                    System.out.println("both are even");
                }
                else{
                    System.out.println("different");
                }
            }
        }
        else{
            System.out.println("invalid length");
        }
    }


    public static boolean isNumberEven(int number){
        boolean isEven = number % 2 == 0;
        return isEven;
    }
}
