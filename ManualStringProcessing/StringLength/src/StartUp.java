import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StartUp {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inputText = reader.readLine();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < 20; i++) {
            if (inputText.length() > i){
                builder.append(inputText.charAt(i));
            }
            else{
                builder.append('*');
            }
        }

        System.out.println(builder);
    }
}
