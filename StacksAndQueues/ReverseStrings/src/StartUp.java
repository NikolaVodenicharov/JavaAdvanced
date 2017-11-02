import java.util.Scanner;
import java.util.ArrayDeque;

public class StartUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ArrayDeque<Character> stack = new ArrayDeque<Character>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
