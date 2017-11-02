import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class StartUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Character> word = new ArrayDeque<>();
        for (char c : input.toCharArray()) {
            word.add(c);
        }

        boolean isPalindrome = true;
        while(word.size() > 1){
            char firstChar = word.removeFirst();
            char lastChar = word.removeLast();

            if (firstChar != lastChar){
                isPalindrome = false;
                break;
            }
        }

        System.out.println(isPalindrome);

    }
}
