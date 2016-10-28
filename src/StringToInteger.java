import java.math.BigInteger;

/**
 * Created by z00195317 on 2016/10/27.
 */
public class StringToInteger {
    public int myAtoi(String str) {
        if (str == null || "".equals(str)) {
            return 0;
        } else {
            StringBuilder numBuilder = new StringBuilder();
            int startIndex = -1;
            int step = 0;
            while (step < str.length() && (str.charAt(step) == ' ' || str.charAt(step) == '\t')) {
                step += 1;
            }

            if (step == str.length()) {
                return 0;
            } else {
                startIndex = step;
                if (str.charAt(startIndex) == '+' || str.charAt(startIndex) == '-') {
                    if (str.length() == startIndex + 1) {
                        return 0;
                    } else if (str.charAt(startIndex + 1) > '9' || str.charAt(startIndex + 1) < '0') {
                        return 0;
                    } else {
                        if (str.charAt(startIndex) == '-') {
                            numBuilder.append(str.charAt(startIndex));
                        }
                        numBuilder.append(str.charAt(startIndex + 1));
                        int i = startIndex + 2;
                        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                            numBuilder.append(str.charAt(i));
                            i++;
                        }
                        return getNum(numBuilder);
                    }
                } else if (str.charAt(startIndex) >= '0' && str.charAt(startIndex) <= '9') {
                    numBuilder.append(str.charAt(startIndex));
                    int i = startIndex + 1;
                    while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                        numBuilder.append(str.charAt(i));
                        i++;
                    }
                    return getNum(numBuilder);
                } else {
                    return 0;
                }
            }
        }
    }

    private int getNum(StringBuilder sb) {
//        BigInteger Solution
//        BigInteger parsedNum = new BigInteger(sb.toString());
//        if (parsedNum.compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE))) >= 0) {
//            return Integer.MAX_VALUE;
//        } else if (parsedNum.compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE))) <= 0) {
//            return Integer.MIN_VALUE;
//        } else {
//            return Integer.parseInt(parsedNum.toString());
//        }
        String inputStr = sb.toString();
        if (inputStr.startsWith("-")) {
            if (inputStr.length() > String.valueOf(Integer.MIN_VALUE).length()) {
                return Integer.MIN_VALUE;
            } else if (inputStr.length() == String.valueOf(Integer.MIN_VALUE).length()) {
                if (inputStr.compareTo(String.valueOf(Integer.MIN_VALUE)) > 0) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.parseInt(inputStr);
                }
            } else {
                return Integer.parseInt(inputStr);
            }
        } else {
            if (inputStr.length() > String.valueOf(Integer.MAX_VALUE).length()) {
                return Integer.MAX_VALUE;
            } else if (inputStr.length() == String.valueOf(Integer.MAX_VALUE).length()) {
                if (inputStr.compareTo(String.valueOf(Integer.MAX_VALUE)) > 0) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.parseInt(inputStr);
                }
            } else {
                return Integer.parseInt(inputStr);
            }
        }
    }

    public static void main(String[] args) {
        StringToInteger sti = new StringToInteger();
        String inputStr = "-1234567890123456789012345678901234567890";
        int output = sti.myAtoi(inputStr);
        System.out.println(output);
    }
}