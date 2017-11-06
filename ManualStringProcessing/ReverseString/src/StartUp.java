import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StartUp {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();
        StringBuilder reversedText = new StringBuilder();

        for (int i = text.length() - 1; i >= 0 ; i--) {
            reversedText.append(text.charAt(i));
        }

        System.out.println(reversedText);
    }
}
