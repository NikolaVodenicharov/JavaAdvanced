import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StartUp {
    public static void main(String[] args) {
        String regex = "([A-Z][a-zA-Z+#]*_[A-Z][a-z]{2}_\\d{4})\\s+([A-Z][a-z]{0,3}\\d{2}_\\d{2,4})\\s+(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;

    }
}
