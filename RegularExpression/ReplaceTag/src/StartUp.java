import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StartUp {
    public static void main(String[] args) throws IOException {
        String regex = "<a\\s+(href=[^>]+)>([^<]+)<\\/a>";
        String text = readInputLines();
        Matcher matcher = createMatcher(text, regex); // .ToString().trimEnd() ?
        String replacedTags = replaceTags(matcher, text);
        consolePrint(replacedTags);

    }

    public static String readInputLines() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder text = new StringBuilder();

        while (true){
            String inputLine = reader.readLine();

            boolean isLoopEnd = inputLine.equals("end");
            if (isLoopEnd){
                break;
            }

            text.append(inputLine + System.lineSeparator());
        }

        return text.toString();
    }
    public static Matcher createMatcher(String text, String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        return matcher;
    }
    public static String createTagReplacement(Matcher matcher){
        String replacement =
                String.format(
                        "[URL %s]%s[/URL]",
                        matcher.group(1),
                        matcher.group(2));

        return replacement;
    }
    public static String replaceTags (Matcher matcher, String text){
        StringBuilder replacedTags = new StringBuilder(text);

        while(matcher.find()){
            int start = matcher.start();
            int end = matcher.start() + matcher.group(0).length();
            String replacement = createTagReplacement(matcher);
            replacedTags.replace(start, end, replacement);
        }

        return  replacedTags.toString();
    }
    public static void consolePrint (String text){
        System.out.println(text);
    }
}
