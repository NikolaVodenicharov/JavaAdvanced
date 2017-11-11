import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class StartUp {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Consumer<String> sirPrefix = name -> System.out.println("Sir " + name);
        String[] names = reader.readLine().split("\\s");
        for (String name : names) {
            sirPrefix.accept(name);
        }
    }
}
