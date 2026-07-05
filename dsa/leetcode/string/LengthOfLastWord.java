package dsa.leetcode.string;

/**
 * 
 * LengthOfLastWord
 * 
 * concept:
 * - start from the end and remove all the trailing spaces
 * - then untill we get a space we can increment the length to find the length of the last word
 * 
 * Time complexity: O(n), n being the length of the string
 * Space complexity: O(1), we are just using 2 variables so its negligible
 */

public class LengthOfLastWord {
    static int lengthOfLastWord (String s) {
        int i = s.length() - 1;

        // skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ')
            i--;

        int length = 0;

        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}
