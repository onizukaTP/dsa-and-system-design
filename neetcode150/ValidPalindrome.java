package neetcode150;

public class ValidPalindrome {
    public boolean validPalindrome (String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            char left = s.charAt(l);
            char right = s.charAt(r);
            if (left != right) return false;
            l++;
            r--;
        }
        return true;
    }
}
