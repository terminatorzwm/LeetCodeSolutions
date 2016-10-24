/**
 * Created by z00195317 on 2016/10/24.
 */
public class ReverseInteger {
    public int reverse(int x) {
        if (x == 0)
            return 0;
        Integer ix = x;
        while (ix.intValue() % 10 == 0)
            ix = ix / 10;
        String sx = ix.toString();
        String rsx = reverseString(sx);
        if (x > 0 && rsx.length() == Integer.toString(Integer.MAX_VALUE).length()
                && rsx.compareTo(Integer.toString(Integer.MAX_VALUE)) > 0) {
            return 0;
        }
        if (x < 0 && rsx.length() == Integer.toString(Integer.MIN_VALUE).length()
                && rsx.replace("-", "").compareTo(
                Integer.toString(Integer.MIN_VALUE).replace("-", "")) > 0) {
            return 0;
        }
        Integer rix = x < 0 ? Integer.decode("-".concat(rsx.replace("-", "")))
                : Integer.decode(rsx);
        return rix.intValue();
    }

    private String reverseString(String s) {
        if (s == null)
            return null;
        int size = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= size; i++) {
            sb.append(s.charAt(size - i));
        }
        return sb.toString();
    }
}