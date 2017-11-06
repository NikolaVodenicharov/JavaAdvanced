import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartUp {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inputText = reader.readLine();
        String base = "\\u00";

        StringBuilder sb = new StringBuilder();
        for (char c : inputText.toCharArray()) {
            sb.append(base + Integer.toHexString(c));
        }

        System.out.println(sb);
    }
}
