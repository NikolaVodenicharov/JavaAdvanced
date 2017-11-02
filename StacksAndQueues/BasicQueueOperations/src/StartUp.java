import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Arrays;

public class StartUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> numbers = new ArrayDeque<Integer>();

        String[] commands = scanner.nextLine().split("\\s+");
        int addNumber = Integer.parseInt(commands[0]);
        int removeNumber = Integer.parseInt(commands[1]);
        int checkForNumber = Integer.parseInt(commands[2]);

        String[] inputNumbers = scanner.nextLine().split("\\s+");

        for (int i = 0; i < addNumber; i++) {
            numbers.add(Integer.parseInt(inputNumbers[i]));
        }

        for (int i = 0; i < removeNumber; i++) {
            numbers.remove();
        }

        if (numbers.contains(checkForNumber)){
            System.out.println("true");
        }
        else{
            int smallestNum = 0;

            if (numbers.size()> 0){
                smallestNum = numbers.remove();

                while(numbers.size() > 0){
                    int popedNum = numbers.remove();

                    if (popedNum < smallestNum){
                        smallestNum = popedNum;

                    }
                }
            }

            System.out.println(smallestNum);
        }
    }
}