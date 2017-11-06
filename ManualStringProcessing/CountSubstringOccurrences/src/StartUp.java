import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartUp {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine().toLowerCase();
        String substring = reader.readLine();
        int counter = 0;

        for (int fromIndex = 0; fromIndex < text.length(); fromIndex++) {
            int foundedIndex = text.indexOf(substring, fromIndex);
            if (foundedIndex >= 0){
                counter++;
                fromIndex = foundedIndex;
            }
            else{
                break;
            }
        }

        System.out.println(counter);
    }
}
