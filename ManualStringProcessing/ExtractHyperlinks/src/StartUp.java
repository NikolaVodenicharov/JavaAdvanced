import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class StartUp {
    public static void main(String[] args) throws IOException {
        String text = readInputLines();
        String[] tags = getTags(text);
        String validHyperlinks =getValidHyperlinks(tags);
        System.out.println(validHyperlinks);
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
    public static String[] getTags(String text){
        ArrayList<String> tagsCollector = new ArrayList<>();
        int textStart = 0;

        while (true) {
            int tagStart = text.indexOf("<a", textStart);
            int tagEnd = text.indexOf(">", tagStart);

            if (tagStart < 0 || tagEnd < 0) {
                break;
            }

            String tag = text.substring(tagStart, tagEnd + 1);
            tagsCollector.add(tag);
            textStart = tagEnd;
        }

        String[] tags = tagsCollector.toArray(new String[0]);
        return tags;
    }
    public static String getValidHyperlinks(String[] tags){
        StringBuilder hyperlinks = new StringBuilder();

        for (String tag : tags) {
            int hrefStart = tag.indexOf(" href");
            boolean isValidTag = hrefStart > 0;

            if (isValidTag){
                int equalStart = tag.indexOf("=", hrefStart);
                String hyperlink = getHyperlink(tag, equalStart);
                hyperlinks
                        .append(hyperlink)
                        .append(System.lineSeparator());
            }
        }

        String validHyperlinks = hyperlinks.toString().trim();
        return validHyperlinks;
    }
    public static String getHyperlink(String text, int start){
        char space = ' ';
        char singleQuotes = '\'';
        char doubleQuotes = '\"';

        String substring = null;
        for (int i = start + 1 ; i < text.length(); i++) {
            char trigger = text.charAt(i);

            if (trigger == doubleQuotes){
                substring = getSubstring(text, i, doubleQuotes);
                break;
            }
            else if(trigger == singleQuotes){
                substring = getSubstring(text, i, singleQuotes);
                break;
            }
            else if (trigger != space){
                substring = getSubstring(text, i - 1, space);
                break;
            }
        }

        return substring;
    }
    public static String getSubstring (String text, int startIndex, char endSymbol){
        StringBuilder substring = new StringBuilder();

        while (true){
            startIndex++;
            char ch = text.charAt(startIndex);

            boolean isValidSymbol = (ch != endSymbol && ch != '>');
            if (!isValidSymbol){
                break;
            }

            substring.append(ch);
        }

        return substring.toString().trim();
    }
}
