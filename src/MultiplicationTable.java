import java.util.Arrays;

public class MultiplicationTable {

    public static void main(String[] args) {
        int[][] test = {{1, 2, 3}, {2, 4, 6}, {3, 6, 9}};
        int[][] multiTable = multiplicationTable(3);

        boolean check = Arrays.deepEquals(test, multiTable);
        System.out.println(check);
    }

    /**
     * Your task, is to create N×N multiplication table, of size provided in parameter.
     * <br>
     * For example, when given size is 3:
     * <pre> {@code
     * 1 2 3
     * 2 4 6
     * 3 6 9
     * }</pre>
     *
     * @param n
     * @return <pre> {@code
     *       [[1,2,3],[2,4,6],[3,6,9]]
     *       }</pre>
     */
    public static int[][] multiplicationTable(int n) {
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = (i + 1) * (j + 1);
            }
        }
//        int result2[][] = IntStream.rangeClosed(1, n)
//                .mapToObj(i -> IntStream.rangeClosed(1, n)
//                        .map(v -> v * i)
//                        .toArray())
//                .toArray(int[][]::new);
        return result;
    }
}
