import java.util.Scanner;
import java.util.ArrayDeque;

public class StartUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> numbers = new ArrayDeque<Integer>();

        int linesNumber = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < linesNumber; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            if (input[0].equals("1")){
                numbers.push(Integer.parseInt(input[1]));
            }
            else if(input[0].equals("2")){
                numbers.pop();
            }
            else{
                int maxElement = 0;

                for (int j = 0; j < numbers.size(); j++) {
                    int num = numbers.pop();

                    if (num > maxElement){
                        maxElement = num;
                    }

                    numbers.add(num);
                }

                System.out.println(maxElement);
            }
        }
    }
}
