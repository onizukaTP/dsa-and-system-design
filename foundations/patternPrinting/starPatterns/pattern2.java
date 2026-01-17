package foundations.patternprinting.starpatterns;

// *****
// ****
// ***
// **
// *

public class pattern2 {
    public static void main(String[] args) {
        printPattern2(5);
    }

    static void printPattern2(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n - i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
