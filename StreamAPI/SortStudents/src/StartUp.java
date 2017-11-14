import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StartUp {
    public static void main(String[] args) throws IOException {
        List<String> studentsNames = readStudentsNames();
        List<String> sortedStudentsNames =
                studentsNames
                .stream()
                .sorted((name1, name2) -> {
                    String[] splitedNames1 = name1.split(" ");
                    String firstName1 = splitedNames1[0];
                    String lastName1 = splitedNames1[1];

                    String[] splitedNames2 = name2.split(" ");
                    String firstName2 = splitedNames2[0];
                    String lastName2 = splitedNames2[1];


                    if (lastName1.equals(lastName2)){
                        return firstName2.compareTo(firstName1);
                    }
                    else{
                        return lastName1.compareTo(lastName2);
                    }
                })
                .collect(Collectors.toList());

        for (String name : sortedStudentsNames) {
            System.out.println(name);
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
