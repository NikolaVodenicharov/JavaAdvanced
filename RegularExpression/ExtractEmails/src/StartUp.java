import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StartUp {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();
        String emailRegex = createEmailRegex();
        Matcher emailMatcher = createMatcher(emailRegex, text);
        String emails = getEmails(emailMatcher);
        System.out.println(emails);
    }

    public static String createEmailRegex(){
        String lookbehindRegex = "(?<=\\s|^)";
        String userRegex = "(?<user>[a-zA-Z][a-zA-Z0-9._-]*)";
        String hostRegex = "(?<host>@[a-zA-Z][a-zA-Z.-]*)";
        String domainRegex = "(?<domain>[.][a-zA-Z]+)";
        String lookaheadRegex = "(?=[,.!? ])";
        String emailRegex = lookbehindRegex + userRegex + hostRegex + domainRegex + lookaheadRegex;

        return emailRegex;
    }
    public static Matcher createMatcher (String regex, String text){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        return  matcher;
    }
    public static String getEmails(Matcher matcher){
        StringBuilder emailsCollector = new StringBuilder();

        while (matcher.find()){
            String email = matcher.group(0);

            emailsCollector
                    .append(email)
                    .append(System.lineSeparator());
        }

        String emails = emailsCollector.toString().trim();
        return  emails;
    }
}
