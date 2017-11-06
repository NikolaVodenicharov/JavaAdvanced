import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class StartUp {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num1 = reader.readLine();
        String num2 = reader.readLine();

        ArrayDeque<Integer> digits = sumNumbersDigits(num1, num2);

        String result = digitsToString(digits);
        System.out.println(result);
    }

    public static ArrayDeque<Integer> sumNumbersDigits(String num1, String num2){
        ArrayDeque<Integer> digits = new ArrayDeque<>();
        String longerNum = getLongerNum(num1, num2);
        String shorterNum = getShorterNum(num1, num2);

        int addition = 0;
        int longerLength = longerNum.length();
        int shorterLength = shorterNum.length();

        addEqualLengthPartDigits(
                digits,
                longerNum,
                shorterNum,
                longerLength,
                shorterLength,
                addition
        );

        addRemainderOfLongerNum(
                digits,
                addition,
                longerNum,
                longerLength,
                shorterLength
        );

        return digits;
    }
    public static String getLongerNum(String num1, String num2){
        if (num1.length() >= num2.length()){
            return num1;
        }
        return  num2;
    }
    public static String getShorterNum(String num1, String num2){
        if (num1.length() < num2.length()){
            return num1;
        }
        return  num2;
    }
    public static void addEqualLengthPartDigits(
            ArrayDeque<Integer> digits,
            String longerNum,
            String shorterNum,
            int longerLength,
            int shorterLength,
            int addition
    ){
        for (int i = 0; i < shorterLength; i++) {
            int digit1 = (longerNum.charAt(longerLength - i - 1)) - '0';
            int digit2 = (shorterNum.charAt(shorterLength - i - 1)) - '0';

            int sum = digit1 + digit2 + addition;

            int addingDigit = sum % 10;
            int additionalDigit = sum / 10;

            digits.push(addingDigit);
            addition = additionalDigit;
        }
    }
    public static void addRemainderOfLongerNum(
            ArrayDeque<Integer> digits,
            int addition,
            String longerNum,
            int longerLength,
            int shorterLength){
        int lengthDifferent = longerLength - shorterLength;
        if (lengthDifferent > 0){
            for (int i = 0; i < lengthDifferent; i++) {
                int digit = (longerNum.charAt(lengthDifferent - i - 1)) - '0';

                int sum = digit + addition;

                int addingDigit = sum % 10;
                int additionalDigit = sum / 10;

                digits.push(addingDigit);
                addition = additionalDigit;
            }
        }

        if (addition > 0){
            digits.push(addition);
        }
    }

    public static String digitsToString(ArrayDeque<Integer> digits){
        StringBuilder result = new StringBuilder();
        int digitsSize = digits.size();
        for (int i = 0; i < digitsSize; i++) {
            result.append(digits.pop());
        }

        return result.toString();
    }
}
