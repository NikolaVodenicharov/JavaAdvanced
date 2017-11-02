import java.util.Scanner;
import java.util.ArrayDeque;

public class StartUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ArrayDeque<Integer> index = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '('){
                index.push(i);
            }
            else if (ch == ')'){
                int startIndex = index.pop();
                int endIndex = i + 1;
                String content = input.substring(startIndex, endIndex);
                System.out.println(content);
            }
        }
    }
}
