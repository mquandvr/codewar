import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * There is a secret string which is unknown to you. Given a collection of random triplets from the string, recover the original string.
 * <br>
 * A triplet here is defined as a sequence of three letters such that each letter occurs somewhere before the next in the given string.
 * "whi" is a triplet for the string "whatisup".
 * <br>
 * As a simplification, you may assume that no letter occurs more than once in the secret string.
 * <br>
 * You can assume nothing about the triplets given to you other than that they are valid triplets and that they contain sufficient information to deduce the original string.
 * <br>
 * In particular, this means that the secret string will never contain letters that do not occur in one of the triplets given to you.
 */
public class SecretDetective {

    public static void main(String[] args) {
//        char[][] triplets = {
//                {'t','u','p'},
//                {'w','h','i'},
//                {'t','s','u'},
//                {'a','t','s'},
//                {'h','a','p'},
//                {'t','i','s'},
//                {'w','h','s'}
//        };
//        System.out.println(recoverSecret(triplets));

        char[][] tripletABC = {
                //{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r'},{'s','t','u'},{'v','w','x'},{'a','y','z'}
                //{'a','b','c'},{'b','c','d'}, {'a','y','z'}
                {'[','a','b'},{'b','c','f'},{'a','c','d'},{'d','e','f'},{'a','g','h'},{'h','i',']'},{'a','f','g'}
        };
        System.out.println(recoverSecret(tripletABC));
    }

    public static String recoverSecret(char[][] triplets) {
        List<Character> recoverList = new ArrayList<>();
        for (char[] triplet : triplets) {
            final char x = triplet[0];
            final char y = triplet[1];
            final char z = triplet[2];

            if (!recoverList.contains(x)) {
                recoverList.add(0, x);
            }
            checkExists(recoverList, x, y);
            checkExists(recoverList, y, z);
        }

        return recoverList.stream().map(String::valueOf).collect(Collectors.joining());
    }

    private static void checkExists(List<Character> recoverList, char x, char y) {
        if (!recoverList.contains(y)) {
            recoverList.add(recoverList.indexOf(x), y);
        }
        if (recoverList.contains(y) && recoverList.indexOf(x) > recoverList.indexOf(y)) {
            recoverList.remove(recoverList.indexOf(y));
            recoverList.add(recoverList.indexOf(x) + 1, y);
        }
    }
}
