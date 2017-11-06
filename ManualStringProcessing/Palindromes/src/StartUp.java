import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StartUp {
    public static void main(String[] args) throws IOException {
        String[] words = getWords();
        ArrayList<String> palindromes = getPalindromes(words);
        lexicographicallySorting(palindromes);
        printPalindromes(palindromes);
    }

    public static String[] getWords() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inputText = reader.readLine();
        String[] words = inputText.split("\\W+");

        return words;
    }
    public static ArrayList<String> getPalindromes(String[] words){
        ArrayList<String> palindromes = new ArrayList<String>();

        for (String word : words) {
            if (isPalindrome(word)){
                palindromes.add(word);
            }
        }

        return palindromes;
    }
    public static boolean isPalindrome(String word){
        ArrayDeque<Character> wordCharacters = new ArrayDeque<>();
        for (char c : word.toCharArray()) {
            wordCharacters.add(c);
        }

        boolean isPalindrome = true;

        while(wordCharacters.size() > 1){
            char firstChar = wordCharacters.removeFirst();
            char lastChar = wordCharacters.removeLast();

            if (firstChar != lastChar){
                isPalindrome = false;
                break;
            }
        }

        return  isPalindrome;
    }
    public static void lexicographicallySorting(ArrayList<String> words){
        Collections.sort(words, String.CASE_INSENSITIVE_ORDER);
    }
    public static void printPalindromes(ArrayList<String> palindromes){

        System.out.println(palindromes);
    }

}
