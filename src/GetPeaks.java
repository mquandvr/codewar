import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetPeaks {

    public static void main(String[] args) {
        int[] arr = {0, 1, -2, 7, 6, -5, 15, 0, -4, 2, 2, 15, 1, 3, 13, 16, 8, 4, 14, 13, 13, -4};
        Map<String, List<Integer>> result = getPeaks(arr);
        System.out.println(result.get("pos"));
        System.out.println(result.get("peaks"));
    }

    /**
     * In this kata, you will write a function that returns the positions and the values of the "peaks" (or local maxima) of a numeric array.
     * <br>
     * For example, the array
     * <pre> {@code arr = [0, 1, 2, 5, 1, 0] }</pre> has a peak at position 3 with a value of 5 (since arr[3] equals 5).
     * <br>
     * The output will be returned as a ``Map<String,List>with two key-value pairs:"pos"and"peaks". If there is no peak in the given array, simply return
     * {@code {"pos" => [], "peaks" => []} }`.
     * Example: {@code pickPeaks([3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 3]) }
     * should return {@code {pos: [3, 7], peaks: [6, 3]} }(or equivalent in other languages)
     * <br>
     * All input arrays will be valid integer arrays (although it could still be empty), so you won't need to validate the input.
     * <br>
     * The first and last elements of the array will not be considered as peaks (in the context of a mathematical function, we don't know what is after and before and therefore, we don't know if it is a peak or not).
     *
     * @Note: Also, beware of plateaus !!! <pre> {@code [1, 2, 2, 2, 1] }</pre>
     * has a peak while {@code [1, 2, 2, 2, 3] } and {@code [1, 2, 2, 2, 2]} do not. In case of a plateau-peak, please only return the position and value of the beginning of the plateau.
     * For example: {@code pickPeaks([1, 2, 2, 2, 1]) }
     * returns
     * {@code {pos: [1], peaks: [2]} }
     * (or equivalent in other languages)
     * Have fun!
     */
    public static Map<String, List<Integer>> getPeaks(int[] arr) {
        List<Integer> peaks = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();

        int tempIdx = 0;
        boolean orderAsc = false;
        for (int idx = 1; idx < arr.length; idx++) {
            if (arr[idx - 1] < arr[idx]) {
                orderAsc = true;
                tempIdx = idx;
            }
            if (orderAsc && arr[idx - 1] > arr[idx]) {
                orderAsc = false;
                pos.add(tempIdx);
                peaks.add(arr[tempIdx]);
            }
        }

        Map<String, List<Integer>> result = new HashMap<>();
        result.put("pos", pos);
        result.put("peaks", peaks);

        return result;
    }
}
