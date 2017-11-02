import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Arrays;

public class StartUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> numbers = new ArrayDeque<Integer>();

        String[] commands = scanner.nextLine().split("\\s+");
        int pushNumber = Integer.parseInt(commands[0]);
        int popNumber = Integer.parseInt(commands[1]);
        int checkForNumber = Integer.parseInt(commands[2]);

        String[] inputNumbers = scanner.nextLine().split("\\s+");

        for (int i = 0; i < pushNumber; i++) {
            numbers.push(Integer.parseInt(inputNumbers[i]));
        }

        for (int i = 0; i < popNumber; i++) {
            numbers.pop();
        }

        if (numbers.contains(checkForNumber)){
            System.out.println("true");
        }
        else{
            int smallestNum = 0;

            if (numbers.size()> 0){
                smallestNum = numbers.pop();

                while(numbers.size() > 0){
                    int popedNum = numbers.pop();

                    if (popedNum < smallestNum){
                        smallestNum = popedNum;

                    }
                }
            }

            System.out.println(smallestNum);
        }
    }
}
