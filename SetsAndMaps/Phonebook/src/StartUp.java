import java.util.Scanner;
import java.util.HashMap;

public class StartUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> phonebook = new HashMap<>();

        while(true){

            String[] input = scanner.nextLine().split("-");

            boolean isEndLoop = input[0].equals("search");
            if (isEndLoop){
                break;
            }

            phonebook.put(input[0], input[1]);
        }

        while(true){
            String name = scanner.nextLine();

            boolean isEndLoop = name.equals("stop");
            if (isEndLoop){
                break;
            }

            if (phonebook.containsKey(name)){
                System.out.printf("%s -> %s" + System.lineSeparator(), name, phonebook.get(name));
            }
            else{
                System.out.printf("Contact %s does not exist." + System.lineSeparator(), name);
            }
        }
    }
}
