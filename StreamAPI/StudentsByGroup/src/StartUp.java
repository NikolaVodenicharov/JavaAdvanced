import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StartUp {
    public static void main(String[] args) throws IOException {
        //Map<String, Integer> students = readStudents();

        Map<String, Integer> students = new HashMap<>();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            while(true){
                String inputLine = reader.readLine();

                boolean isLoopEnd = inputLine.equals("END");
                if (isLoopEnd){
                    break;
                }

                String[] splitInput = inputLine.split(" ");
                String firstName = splitInput[0];
                String lastName = splitInput[1];
                String fullName = firstName + " " + lastName;
                Integer group = Integer.parseInt(splitInput[2]);

                students.put(fullName, group);
            }
        } catch(IOException e){
            e.printStackTrace();
        }



        Map<String, Integer> groupStundets =
                students
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 2)
                .sorted((entry1, entry2) -> entry1.getKey().compareTo(entry2.getKey()))
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
        for (String studentName : groupStundets.keySet()) {
            System.out.println(studentName);
        }
    }

    public static Map<String,Integer> readStudents() throws IOException {
        Map<String, Integer> students = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while(true){
                String inputLine = reader.readLine();

                boolean isLoopEnd = inputLine.equals("END");
                if (isLoopEnd){
                    break;
                }

                String[] splitInput = inputLine.split(" ");
                String firstName = splitInput[0];
                String lastName = splitInput[1];
                String fullName = firstName + " " + lastName;
                Integer group = Integer.parseInt(splitInput[2]);

                students.put(fullName, group);
            }

        return students;
    }
}
