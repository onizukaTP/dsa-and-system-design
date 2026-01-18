package foundations.patternprinting.starpatterns;

//    *
//   ***
//  *****
// *******

public class pattern4 {
    public static void main(String[] args) {
        printPattern4(5);
    }

    static void printPattern4(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2*i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
