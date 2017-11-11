import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.function.Predicate;

public class StartUp {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] words = reader.readLine().split(" ");

        ArrayList<String> uppercaseWords = new ArrayList<>();
        Predicate<String> isUppercase = word -> Character.isUpperCase(word.charAt(0));
        for (String word : words) {
            if (isUppercase.test(word)){
                uppercaseWords.add(word);
            }
        }

        System.out.println(uppercaseWords.size());
        for (String uppercaseWord : uppercaseWords) {
            System.out.println(uppercaseWord);
        }
    }
}
