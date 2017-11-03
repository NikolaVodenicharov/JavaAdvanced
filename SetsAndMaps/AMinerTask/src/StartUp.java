import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class StartUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> resources = new HashMap<>();

        while(true){
            String resourceName = scanner.nextLine();

            boolean isLoopEnd = resourceName.equals("stop");
            if (isLoopEnd){
                break;
            }

            int resourceQuantity = Integer.parseInt(scanner.nextLine());

            resources.put(resourceName, resourceQuantity);
        }

        for (Map.Entry<String, Integer> entry : resources.entrySet()) {
            System.out.printf("%s -> %s" + System.lineSeparator(), entry.getKey(), entry.getValue());
        }
    }
}
