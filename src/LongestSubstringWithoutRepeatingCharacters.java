public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (-1 != sb.toString().indexOf(s.charAt(i))) {
                sb.delete(0, sb.toString().indexOf(s.charAt(i)) + 1);
                sb.append(s.charAt(i));
            } else {
                sb.append(s.charAt(i));
                int tempLength = sb.length();
                if (tempLength > maxLength) {
                    maxLength = tempLength;
                }
            }
        }
        return maxLength;
    }
}