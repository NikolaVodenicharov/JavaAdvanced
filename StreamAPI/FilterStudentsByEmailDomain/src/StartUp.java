import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StartUp {
    public static void main(String[] args) throws IOException {
        Map<String, String> students = readStudents();
        Map<String, String> filteredStudents =
                students
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().endsWith("@gmail.com"))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e, e2) -> e,
                        LinkedHashMap<String, String>::new
                ));

        for (String studentName : filteredStudents.keySet()) {
            System.out.println(studentName);
        }
    }

    public static Map<String, String> readStudents() throws IOException {
        Map<String, String> students = new LinkedHashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String inputLine = reader.readLine();

            boolean isLoopBreak = inputLine.equals("END");
            if (isLoopBreak){
                break;
            }

            String[] splitInput = inputLine.split("\\s+");
            String name = splitInput[0] + " " + splitInput[1];
            String email = splitInput[2];

            students.put(name, email);
        }

        return students;
    }
}
