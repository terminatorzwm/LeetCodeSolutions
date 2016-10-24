/**
 * Created by z00195317 on 2016/10/24.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String processedString = preProcess(s);
        int len = processedString.length();
        if (0 == len) {
            return "";
        }
        if (1 == len) {
            return s;
        }
        int[] pRecord = new int[len];
        pRecord[0] = 1;
        int maxLocate = 0;
        for (int i = 1; i < len; i++) {
            int j = 1;
            for (int m = 0; m < i; m++) {
                if (m + pRecord[m] - 1 >= i && pRecord[2 * m - i] > j) {
                    j = i + pRecord[2 * m - i] > m + pRecord[m] ? m
                            + pRecord[m] - i : pRecord[2 * m - i];
                }
            }
            while (j < i + 1
                    && j + i < len
                    && processedString.charAt(i + j) == processedString
                    .charAt(i - j)) {
                j++;
            }
            pRecord[i] = j;
            if (j >= pRecord[maxLocate]) {
                maxLocate = i;
            }
        }
        StringBuilder longestPal = new StringBuilder();
        longestPal.append(processedString.charAt(maxLocate));
        if (pRecord[maxLocate] == 1) {
            return longestPal.toString();
        } else {
            for (int n = 1; n < pRecord[maxLocate]; n++) {
                longestPal.append(processedString.charAt(maxLocate + n));
                longestPal.insert(0, processedString.charAt(maxLocate - n));
            }
            return longestPal.toString().replace("#", "");
        }
    }

    private String preProcess(String s) {
        if (0 == s.length()) {
            return "";
        }
        if (1 == s.length()) {
            return s;
        }
        String newString = "#";
        for (int i = 0; i < s.length(); i++) {
            newString += s.charAt(i) + "#";
        }
        return newString;
    }
}