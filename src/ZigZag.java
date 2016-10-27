/**
 * Created by z00195317 on 2016/10/24.
 */
public class ZigZag {
    public String convert(String s, int numRows) {
        if (s != null && (numRows == 1 || s.length() < numRows)) {
            return s;
        } else if (s == null) {
            return "";
        } else {
            StringBuilder[] sbs = new StringBuilder[numRows];
            for (int i = 0; i < numRows; i++) {
                sbs[i] = new StringBuilder();
            }
            int inputLength = s.length();
            for (int i = 0; i < inputLength; i++) {
                int segCount = numRows * 2 - 2;
                int modulo = (i + 1) % segCount;
                if (modulo == 0) modulo = segCount;
                if (modulo <= numRows) {
                    sbs[modulo - 1].append(s.charAt(i));
                } else {
                    sbs[numRows - (modulo - numRows) - 1].append(s.charAt(i));
                }
            }
            String outputString = "";
            for (int i = 0; i < numRows; i++) {
                outputString += sbs[i].toString();
            }
            return outputString;
        }
    }

    public static void main (String[] args) {
        ZigZag zz = new ZigZag();
        String inputString = "AJLDFJJFOQINVS89VWREGOIZNV,LQLRI";
        int numRows = 4;
        String outputString = zz.convert(inputString, numRows);
        System.out.println(outputString);
    }
}

