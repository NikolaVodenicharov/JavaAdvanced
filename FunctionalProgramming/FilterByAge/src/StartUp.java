import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StartUp {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Integer> people = readPeople(reader);
        String condition = reader.readLine();
        int age = Integer.parseInt(reader.readLine());
        String format = reader.readLine();

        Predicate<Integer> tester = createTester(condition, age);
        Consumer<Map.Entry<String, Integer>> printer = createPrinter(format);
        printFilteredStudent(people, tester, printer);

    }
    public static LinkedHashMap<String, Integer> readPeople(BufferedReader reader) throws IOException {
        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();

        int inputLinesNumber = Integer.parseInt(reader.readLine());
        for (int i = 0; i < inputLinesNumber; i++) {
            String[] inputLine = reader.readLine().split(", ");
            String name = inputLine[0];
            int age = Integer.parseInt(inputLine[1]);
            people.put(name, age);
        }

        return people;
    }
    public static Predicate<Integer> createTester(String condition, Integer age){
        switch (condition){
            case "younger":
                return x -> x < age;
            case "older":
                return x -> x >= age;
            default:
                return null;
        }
    }
    private static Consumer<Map.Entry<String,Integer>> createPrinter(String format) {
        switch (format){
            case "name age":
                return person -> System.out.printf("%s - %d" + System.lineSeparator(), person.getKey(), person.getValue());
            case "name":
                return person -> System.out.printf("%s" + System.lineSeparator(), person.getKey());
            case "age":
                return person -> System.out.printf("%s" + System.lineSeparator(), person.getValue());
            default:
                return null;
        }
    }
    public static void printFilteredStudent(
            LinkedHashMap<String, Integer> people,
            Predicate<Integer> tester,
            Consumer<Map.Entry<String, Integer>> printer) {

        for (Map.Entry<String, Integer> person : people.entrySet()) {
            if (tester.test(people.get(person.getKey()))) {
                printer.accept(person);
            }
        }
    }


}
