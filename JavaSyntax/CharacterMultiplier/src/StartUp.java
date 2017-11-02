import java.util.Scanner;

public class StartUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split("\\s+");
        String word1 = words[0];
        String word2 = words[1];

        String longerWord = null;
        String shorterWord = null;
        if (word1.length() >= word2.length()){
            longerWord = word1;
            shorterWord = word2;
        }
        else{
            longerWord = word2;
            shorterWord = word1;
        }

        int sum = 0;

        for (int i = 0; i < longerWord.length(); i++) {
            int longerWordNum = longerWord.charAt(i);
            int shorterWordNum = 1;
            if (shorterWord.length() > i){
                shorterWordNum = shorterWord.charAt(i);
            }

            sum += shorterWordNum * longerWordNum;
        }

        System.out.println(sum);
    }
}
