public class StartUp {
    public static void main(String[] args) {
        for (int num1 = 1; num1 <= 10; num1++) {
            for (int num2 = num1 + 1; num2 <= 10; num2++) {
                for (int num3 = num2 + 1; num3 <= 10; num3++) {
                    System.out.printf("%d %d %d" + System.lineSeparator(), num1, num2, num3);
                }
            }
        }
    }
}
