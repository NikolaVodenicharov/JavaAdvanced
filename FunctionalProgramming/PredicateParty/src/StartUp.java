import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

public class StartUp {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = Arrays.asList(reader.readLine().split(" "));
        BiPredicate<String, String> isStartsWith = (s1, s2) -> s1.startsWith(s2);
        BiPredicate<String, String> isEndsWith = (s1, s2) -> s1.endsWith(s2);
        BiPredicate<String, String> isLengthEnought = (s, n) -> s.length() == Integer.parseInt(n);

        while(true){
            String[] inputCommands = reader.readLine().split(" ");
            String command = inputCommands[0];

            if (command.equals("Party!")){
                break;
            }

            String condition = inputCommands[1];
            String parameter = inputCommands[2];

            if (command.equals("Remove")){
                switch (condition){
                    case "StartsWith":
                        names = removeNames(names, isStartsWith, parameter);
                        break;
                    case "EndsWith":
                        names = removeNames(names, isEndsWith, parameter);
                        break;
                    case "Length":
                        names = removeNames(names, isLengthEnought, parameter);
                        break;
                }
            }
            else if(command.equals("Double")){
                switch (condition){
                    case "StartsWith":
                        names = addNames(names, isStartsWith, parameter);
                        break;
                    case "EndsWith":
                        names = addNames(names, isEndsWith, parameter);
                        break;
                    case "Length":
                        names = addNames(names, isLengthEnought, parameter);
                        break;
                }
            }
        }

        printPartyGuests(names);
    }

    public static List<String> removeNames (
            List<String> names,
            BiPredicate<String, String> predicate,
            String parameter){
        List<String> nonRemovedNames = new ArrayList<>();
        for (String name : names) {
            boolean isRemoveName = predicate.test(name, parameter);
            if (!isRemoveName){
                nonRemovedNames.add(name);
            }
        }

        return nonRemovedNames;
    }
    public static List<String> addNames(
            List<String> names,
            BiPredicate<String, String> predicate,
            String parameter){
        List<String> doubleSomeNames = new ArrayList<>();
        for (String name : names) {
            boolean isDoubling = predicate.test(name, parameter);
            doubleSomeNames.add(name);
            if (isDoubling){
                doubleSomeNames.add(name);
            }
        }

        return doubleSomeNames;
    }
    public static String joinStrings (List<String> names, String joinBy){
        StringBuilder sb = new StringBuilder();
        for (String name : names) {
            sb.append(name + joinBy);
        }

        String gatheredNames = sb.delete(sb.length() - 2, sb.length()).toString();
        return gatheredNames;
    }
    public static void printPartyGuests (List<String> names){
        if (names.size() != 0){
            String message = joinStrings(names, ", ") + " are going to the party!";
            System.out.println(message);
        }
        else{
            System.out.println("Nobody is going to the party!");
        }
    }
}
