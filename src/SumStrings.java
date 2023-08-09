public class SumStrings {

    public static void main(String[] args) {
        System.out.println(sumStrings("00103", "08567"));
    }

    /**
     * Given the string representations of two integers, return the string representation of the sum of those integers.
     * <br>
     * For example:
     * <pre> {@code
     * sumStrings('1','2') // => '3'
     * }</pre>
     * A string representation of an integer will contain no characters besides the ten numerals "0" to "9".
     * <br>
     * I have removed the use of BigInteger and BigDecimal in java
     * <br>
     * Python: your solution need to work with huge numbers (about a milion digits), converting to int will not work.
     * @param a
     * @param b
     * @return
     */
    public static String sumStrings(String a, String b) {
        int tempHund = 0;
        int total;
        int elementA;
        int elementB;
        StringBuilder result = new StringBuilder();
        boolean isLonger = a.length() > b.length();
        String dataA = isLonger ? a : b;
        String dataB = isLonger ? b : a;
        for (int i = 0; i < dataA.length(); i++) {
            elementA = Integer.parseInt(String.valueOf(dataA.charAt(dataA.length() - 1 - i)));
            elementB = 0;
            if (dataB.length() >= i + 1) {
                elementB = Integer.parseInt(String.valueOf(dataB.charAt(dataB.length() - 1 - i)));
            }
            total = elementA + elementB + tempHund;
            tempHund = total / 10;
            result.append(total % 10);
            if (i == dataA.length() - 1) {
                result.append(tempHund);
            }
        }
        result.reverse();
        while(result.length() > 0 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        return result.toString();
    }
}
