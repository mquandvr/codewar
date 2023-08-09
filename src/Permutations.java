import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {

    public static void main(String[] args) {
        String s = "ABC";
        singlePermutations(s).forEach(System.out::println);
    }

    public static List<String> singlePermutations(String s) {
        Set<String> stringSet = new HashSet<>();

        int length = s.length();
        permute(s, 0, length - 1, stringSet);

        // Your code here!
        return stringSet.stream().toList();
    }

    public static void permute(String s, int start, int end, Set<String> stringSet) {
        if (start == end) {
            stringSet.add(s);
        } else {
            for (int i = start; i <= end; i++) {
                s = swap(s, start, i);
                permute(s, start+1, end, stringSet);
                s = swap(s, start, i);
            }
        }
    }

    public static String swap(String s, int i, int j) {
        char temp;
        char[] charArr = s.toCharArray();
        temp = charArr[i];
        charArr[i] = charArr[j];
        charArr[j] = temp;

        return String.valueOf(charArr);
    }
}
