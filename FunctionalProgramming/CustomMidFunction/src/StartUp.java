import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class StartUp {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Integer[] numbers = null;
        if (input.length() > 0){
            numbers =
                    Arrays
                    .stream(input.split(" "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
        }

        Function<Integer[], Integer> minInteger = nums -> {
            if (nums != null){
                int min = nums[0];
                for (int i = 1; i < nums.length; i++) {
                    if(nums[i] < min){
                        min = nums[i];
                    }
                }
                return  min;
            }
            else{
                return 0;
            }
        };
        int min = minInteger.apply(numbers);
        System.out.println(min);
    }
}
