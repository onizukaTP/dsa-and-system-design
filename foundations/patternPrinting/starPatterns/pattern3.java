package foundations.patternPrinting.starPatterns;

//     *
//    **
//   ***
//  ****
// *****

public class pattern3 {
    public static void main(String[] args) {
        printPattern3(5);
    }
    static void printPattern3(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
