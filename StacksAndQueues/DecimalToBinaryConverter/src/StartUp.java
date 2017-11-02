import java.util.Scanner;
import  java.util.ArrayDeque;

public class StartUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decimal = Integer.parseInt(scanner.nextLine());

        if (decimal > 0){
            ArrayDeque<Integer> binary = new ArrayDeque<>();
            while(decimal > 0){
                binary.push(decimal % 2);
                decimal /= 2;
            }

            while(binary.size() > 0){
                System.out.print(binary.pop());
            }
        }
        else{
            System.out.println(0);
        }

    }
}
