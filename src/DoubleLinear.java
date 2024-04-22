import java.util.*;

/**
 * Consider a sequence u where u is defined as follows:
 * <pre>{@code
 * The number u(0) = 1 is the first one in u.
 * For each x in u, then y = 2 * x + 1 and z = 3 * x + 1 must be in u too.
 * There are no other numbers in u.
 * Ex: u = [1, 3, 4, 7, 9, 10, 13, 15, 19, 21, 22, 27, ...]
 * <p>
 * 1 gives 3 and 4, then 3 gives 7 and 10, 4 gives 9 and 13, then 7 gives 15 and 22 and so on...
 * }</pre>
 * Task:
 * Given parameter n the function dbl_linear (or dblLinear...) returns the element u(n) of the ordered (with <) sequence u (so, there are no duplicates).
 * <p>
 * Example:
 * dbl_linear(10) should return 22
 * <p>
 * Note:
 * Focus attention on efficiency
 */
public class DoubleLinear {

    public static void main(String[] args) {
        int data = 10;
        int result = dblLinear2(data);
        System.out.println(result);
    }

    public static int dblLinear(int n) {
        SortedSet<Integer> linearSet = new TreeSet<>();
        linearSet.add(1);
        List<Integer> linearList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            linearList = new ArrayList<>(linearSet);
            int x = linearList.get(i);
            linearSet.add(2 * x + 1);
            linearSet.add(3 * x + 1);
        }
        System.out.println(linearList.size());
        linearList.forEach(System.out::println);
        return linearList.get(n);
    }

    public static int dblLinear2(int n) {

        SortedSet<Integer> linearSet = new TreeSet<>();
        linearSet.add(1);
        for (int i = 0; i < n; i++) {
            int x = linearSet.first();
            linearSet.add(2 * x + 1);
            linearSet.add(3 * x + 1);
            linearSet.remove(x);
        }
        return linearSet.first();
    }
}
