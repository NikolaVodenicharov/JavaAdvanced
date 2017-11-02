import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayDeque;

public class StartUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputs = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, inputs);

        while(stack.size() > 1){
            int firstNum = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int secondNum = Integer.parseInt(stack.pop());

            if (operator.equals("+")){
                stack.push(String.valueOf(firstNum + secondNum));
            }
            else{
                stack.push(String.valueOf(firstNum - secondNum));
            }
        }

        System.out.println(stack.pop());
    }
}
