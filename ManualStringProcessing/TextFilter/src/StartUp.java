import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartUp {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] bannedWords = reader.readLine().split(", ");
        String text = reader.readLine();

        String filteredText = filterText(text, bannedWords);
        System.out.println(filteredText);
    }

    public static String filterText (String text, String[] bannedWords){
        String[] textSpaceSplited = text.split(" ");
        replaceBannedWords(textSpaceSplited, bannedWords);
        String formatedText = arrayToString(textSpaceSplited);

        return formatedText;
    }
    public static void replaceBannedWords(String[] textSpaceSplited, String[] bannedWords){
        for (int i = 0; i < textSpaceSplited.length; i++) {

            for (int j = 0; j < bannedWords.length; j++) {

                if (textSpaceSplited[i].contains(bannedWords[j])){
                    textSpaceSplited[i] =
                            textSpaceSplited[i].replace(
                                    bannedWords[j],
                                    createAsterisks(bannedWords[j].length()));
                }
            }
        }
    }
    public static String createAsterisks(int length){
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < length; k++) {
            sb.append("*");
        }

        return sb.toString();
    }
    public static String arrayToString(String[] array){
        StringBuilder sb = new StringBuilder();
        for (String s : array) {
            sb
                    .append(s)
                    .append(" ");
        }
        String formatedText = sb.toString();

        return formatedText;
    }
}
