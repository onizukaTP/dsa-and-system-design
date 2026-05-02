package neetcode150;

class PermutationInString {
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (char c : s1.toCharArray()) {
            count1[c - 'a']++;
        }

        int windowSize = s1.length();

        // initiate first window
        for (int i = 0; i < windowSize; i++) {
            count2[s2.charAt(i) - 'a']++;
        }

        // check match
        if (matches(count1, count2)) return true;

        // slide window
        for (int i = windowSize; i < s2.length(); i++) {
            // add element
            count2[s2.charAt(i) - 'a']++;

            // remove element
            count2[s2.charAt(i - windowSize) - 'a']--;

            // check match
            if (matches(count1, count2)) {
                return true;
            }
        }

        return false;
    }

    public static boolean matches (int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(checkInclusion(s1, s2)); // false
    }
}