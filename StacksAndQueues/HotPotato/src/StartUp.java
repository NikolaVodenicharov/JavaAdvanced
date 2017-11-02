import java.util.Scanner;
import java.util.ArrayDeque;

public class StartUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputKids = scanner.nextLine().split("\\s+");
        ArrayDeque<String>  kids = new ArrayDeque<>();
        for (String inputKid : inputKids) {
            kids.add(inputKid);
        }

        int n = scanner.nextInt();

        while(kids.size() > 1){

            for (int i = 1; i < n; i++) {
                String kid = kids.remove();
                kids.add(kid);
            }
            System.out.printf("Removed %s"+ System.lineSeparator(), kids.remove());
        }

        System.out.printf("Last is %s", kids.peek());
    }
}
