import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringMerger {

    public static void main(String[] args) {
        System.out.println(isMerge("N$aT,5Bl):mh", "$aTl):m", "h,5BN"));
        System.out.println(isMerge("codewars", "code", "wars"));
    }

    /**
     * At a job interview, you are challenged to write an algorithm to check if a given string, s, can be formed from two other strings, part1 and part2.
     * <br>
     * The restriction is that the characters in part1 and part2 should be in the same order as in s.
     * <br>
     * The interviewer gives you the following example and tells you to figure out the rest from the given test cases.
     * <br>
     * For example:
     * <pre> {@code
     * 'codewars' is a merge from 'cdw' and 'oears':
     *
     *     s:  c o d e w a r s   = codewars
     * part1:  c   d   w         = cdw
     * part2:    o   e   a r s   = oears
     * }</pre>
     * @param s
     * @param part1
     * @param part2
     * @return
     */
    public static boolean isMerge(String s, String part1, String part2) {

        if (s.length() != part1.length() + part2.length()) {
            return false;
        }

        if (s.isEmpty()) {
            return true;
        }

        if (!part1.isEmpty() && s.charAt(0) == part1.charAt(0)) {
            return isMerge(s.substring(1), part1.substring(1), part2);
        }

        if (!part2.isEmpty() && s.charAt(0) == part2.charAt(0)) {
            return isMerge(s.substring(1), part1, part2.substring(1));
        }

        return false;
    }
}
