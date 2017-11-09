import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StartUp {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String regex = "\\+\\d{3}( |-)[2]\\1\\d{3}\\1\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;

        while(true){
            String inputLine = reader.readLine();

            boolean isLoopEnd = inputLine.equals("end");
            if(isLoopEnd){
                break;
            }

            matcher = pattern.matcher(inputLine);
            boolean isMatch = matcher.find();
            if (isMatch){
                System.out.println(inputLine);
            }
        }
    }
}
