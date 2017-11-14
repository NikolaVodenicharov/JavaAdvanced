import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StartUp {
    public static void main(String[] args) throws IOException {
        Map<String, List<Integer>> students = readStudents();
        Map<String, List<Integer>> filteredStudents =
                students
                .entrySet()
                .stream()
                .filter(entry -> {
                    boolean isContainExcellentGrade = false;
                            for (Integer integer : entry.getValue()) {
                                if (integer == 6){
                                    isContainExcellentGrade = true;
                                    break;
                                }
                            }
                    return isContainExcellentGrade;
                })
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue(),
                        (e, e2) -> e,
                        LinkedHashMap<String, List<Integer>>::new));
        printKeys(filteredStudents);
    }

    public static Map<String, List<Integer>> readStudents() throws IOException {
        Map<String, List<Integer>> students = new LinkedHashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String inputLine = reader.readLine();

            boolean isLoopBreak = inputLine.equals("END");
            if (isLoopBreak){
                break;
            }

            String[] splitInput = inputLine.split("\\s+");
            String name = splitInput[0] + " " + splitInput[1];
            List<Integer> grades = getIntegers(splitInput);

            students.put(name, grades);
        }

        return students;
    }
    public static List<Integer> getIntegers(String[] splitInput) {
        List<Integer> grades = new ArrayList<>();

        for (int i = 2; i < splitInput.length; i++) {
            String nonParsedGrade = splitInput[i];
            Integer parsedGrade = Integer.parseInt(nonParsedGrade);
            grades.add(parsedGrade);
        }

        return grades;
    }
    public static void printKeys (Map<String, List<Integer>> map){
        StringBuilder sb = new StringBuilder();
        for (String key : map.keySet()) {
            sb.append(key + System.lineSeparator());
        }

        System.out.println(sb.toString().trim());
    }
}
