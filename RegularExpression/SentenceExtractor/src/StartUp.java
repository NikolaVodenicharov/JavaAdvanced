import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StartUp {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String keyword = reader.readLine();
        String regexKeyword = "\\b" + keyword + "\\b";

        // alternative, match better: "([^.!?]*\b" + keyword + "\b[^.!?]*[.!?])"

        String sentences = reader.readLine();
        String regexSentences = "([^.!?]+[.!?])";
        Matcher sentencesMatcher = createMatcher(sentences, regexSentences);

        printSentencesContainingKeyword(sentencesMatcher, regexKeyword);
    }

    public static Matcher createMatcher(String text, String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        return matcher;
    }
    public static void printSentencesContainingKeyword(Matcher sentencesMatcher, String regexKeyword){
        while (sentencesMatcher.find()) {
            String sentence = sentencesMatcher.group(1);
            Matcher keywordMatcher = createMatcher(sentence, regexKeyword);
            if (keywordMatcher.find()){
                System.out.println(sentence.trim());
            }
        }
    }
}
