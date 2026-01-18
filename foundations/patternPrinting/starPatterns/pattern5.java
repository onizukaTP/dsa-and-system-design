package foundations.patternprinting.starpatterns;

//    *
//   ***
//  *****
// *******
//  *****
//   ***
//    *

public class pattern5 {
    public static void main(String[] args) {
        printPattern5(4);
    }
    static void printPattern5(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2*i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2*(n - i)-1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
