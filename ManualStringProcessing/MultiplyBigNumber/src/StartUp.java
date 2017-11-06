import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class StartUp {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String longerNum = reader.readLine();
        String oneDigitNum = reader.readLine();

        ArrayDeque<Integer> digits = multiplyNumbers(longerNum, oneDigitNum);
        String result = joinDigits(digits);

        System.out.println(result);
    }

    public static int multiplyDigits(char char1, int shorterNumDigit){
        int num1 = char1 - '0';
        int result = num1 * shorterNumDigit;
        return  result;
    }
    public static String joinDigits(ArrayDeque<Integer> digits){
        StringBuilder sb = new StringBuilder();
        int digitsSize = digits.size();
        for (int i = 0; i < digitsSize; i++) {
            sb.append(digits.pop());
        }

        String result = sb.toString();
        return result;
    }
    public static ArrayDeque<Integer> multiplyNumbers(String longerNum, String oneDigitNum){
        int shorterNumDigit = Integer.parseInt(oneDigitNum);

        ArrayDeque<Integer> digits = new ArrayDeque<Integer>();
        int addition = 0;

        for (int i = longerNum.length(); i > 0 ; i--) {
            char longerNumDigit = longerNum.charAt(i - 1);

            int multiplyed = multiplyDigits(longerNumDigit, shorterNumDigit);
            int finalNum = multiplyed + addition;
            int addingDigit = finalNum % 10;
            digits.push(addingDigit);
            addition = finalNum / 10;
        }

        if (addition > 0){
            digits.push(addition);
        }

        return digits;
    }
}
