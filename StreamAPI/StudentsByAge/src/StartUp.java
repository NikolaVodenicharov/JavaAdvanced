import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StartUp {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> students = readStudents();

        Map<String, Integer> filteredStudents =
                students
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= 18 && entry.getValue() <= 24)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e, e2) -> e,
                        LinkedHashMap<String,Integer>::new
                ));

        for (String name : filteredStudents.keySet()) {
            System.out.println(name);
        }
    }

    public static Map<String, Integer> readStudents() throws IOException {
        Map<String, Integer> students = new LinkedHashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String inputLine = reader.readLine();

            boolean isLoopEnd = inputLine.equals("END");
            if (isLoopEnd){
                break;
            }

            String[] splitInput = inputLine.split("[\\s]+");
            String fullName = splitInput[0] + " " + splitInput[1];
            Integer age = Integer.parseInt(splitInput[2]);

            students.put(fullName, age);
        }

        return students;
    }
}
