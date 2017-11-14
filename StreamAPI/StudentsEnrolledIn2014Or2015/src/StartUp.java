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
                        .filter(entry -> {
                            boolean isEnrolled = false;
                            if (entry.getKey().endsWith("14") || entry.getKey().endsWith("15")) {
                                isEnrolled = true;
                            }

                            return isEnrolled;
                        })
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e, e2) -> e,
                                LinkedHashMap::new));
        printValues(filteredStudents);
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

            String facultyNumber = inputLine.substring(0,6);
            String grades = inputLine.substring(7);

            students.put(facultyNumber, grades);
        }

        return students;
    }
    public static void printValues(Map<String, String> map){
        StringBuilder sb = new StringBuilder();
        for (String value : map.values()) {
            sb
                    .append(value)
                    .append(System.lineSeparator());
        }

        System.out.println(sb.toString().trim());
    }
}
