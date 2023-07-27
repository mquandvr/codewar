public class AlphaNumeric {

    public static void main(String[] args) {

    }

    /**
     * In this example you have to validate if a user input string is alphanumeric. The given string is not nil/null/NULL/None, so you don't have to check that.
     * <br><br>
     * The string has the following conditions to be alphanumeric:
     * <br><br>
     * At least one character ("" is not valid)<br>
     * Allowed characters are uppercase / lowercase latin letters and digits from 0 to 9<br>
     * No whitespaces / underscore
     * @param s
     * @return
     */
    public static boolean alphanumeric(String s){
        return !s.matches("[^a-zA-Z0-9]+");
    }
}
