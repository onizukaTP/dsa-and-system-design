package neetcode150;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
    public String encode (List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String s : strs)
            encoded.append(s.length()).append("#").append(s);
        return encoded.toString();
    }

    public List<String> decode (String str) {
        List<String> decoded = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;

            // find #
            while (str.charAt(j) != '#') j++;

            // get length
            int length = Integer.parseInt(str.substring(i, j));

            // move j to start of the word
            j++;

            // extract the string
            String word = str.substring(j, j + length);
            decoded.add(word);

            i = j + length;
        }
        return decoded;
    }
}
