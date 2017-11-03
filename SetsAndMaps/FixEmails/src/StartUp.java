import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class StartUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> contacts = new HashMap<>();

        while(true){
            String name = scanner.nextLine();

            boolean isLoopEnd = name.equals("stop");
            if (isLoopEnd){
                break;
            }

            String email = scanner.nextLine();
            String domain = email.substring(email.length()-2);

            if (!domain.equals("uk") && !domain.equals("us")){
                contacts.put(name, email);
            }
        }

        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            System.out.printf("%s -> %s" + System.lineSeparator(), entry.getKey(), entry.getValue());
        }
    }
}
