package foundations.patternPrinting.starPatterns;

// *
// **
// ***
// ****
// *****

public class pattern1 {
    public static void main(String[] args) {
        printPattern1(5);
    }

    public static void printPattern1(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
