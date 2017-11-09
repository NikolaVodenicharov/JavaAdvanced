import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StartUp {
    public static void main(String[] args) throws IOException {
        String text = readInputLines();
        String regexHyperlink = "<a[^>]+href\\s*=\\s*(?:\"([^\"]*)\"|'([^']*)'|([^\\s>]*))[^>]*>";
        Matcher matcher = createMatcher(regexHyperlink, text);
        String selections = matcherExtractor(matcher);
        System.out.println(selections);
    }

    public static String readInputLines() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        while(true){
            String inputLine = reader.readLine();

            boolean isLoopEnd = inputLine.equals("END");
            if (isLoopEnd){
                break;
            }

            builder.append(inputLine);
        }

        String inputLines = builder.toString().trim();
        return  inputLines;
    }
    public static String matcherExtractor(Matcher matcher){
        StringBuilder matchCollector = new StringBuilder();

        while (matcher.find()){
            for (int i = 1; i <= 3; i++) {
                if (matcher.group(i) != null){
                    matchCollector
                            .append(matcher.group(i))
                            .append(System.lineSeparator());
                }
            }
        }

        String sellections = matchCollector.toString().trim();
        return sellections;
    }
    public static Matcher createMatcher(String regex, String text){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        return matcher;
    }
}
