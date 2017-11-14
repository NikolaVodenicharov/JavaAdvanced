import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StartUp {
    public static void main(String[] args) throws IOException {
        List<String> studentsNames = readStudentsNames();
        List<String> filteredStudents =
                studentsNames
                .stream()
                .filter(student -> {
                    String[] splitNames = student.split(" ");
                    String firstName = splitNames[0];
                    String lastName = splitNames[1];

                    return firstName.compareTo(lastName) < 0;
                })
                .collect(Collectors.toList());

        for (String student : filteredStudents) {
            System.out.println(student);
        }
    }

    public static List<String> readStudentsNames() throws IOException {
        List<String> studentsName = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String inputLine = reader.readLine().trim();

            boolean isLoopEnd = inputLine.equals("END");
            if (isLoopEnd){
                break;
            }

            studentsName.add(inputLine);
        }

        return studentsName;
    }
}
