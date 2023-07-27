import java.util.Arrays;

public class FindUniq {

    public static void main(String[] args) {
        double[] test = new double[]{1, 1, 1, 2, 1, 1};
        double uniqVal = findUniq(test);

        System.out.println(2.0 == uniqVal);
    }

    /**
     * There is an array with some numbers. All numbers are equal except for one. Try to find it!
     * <br>
     * <pre> {@code
     * Kata.findUniq(new double[]{ 1, 1, 1, 2, 1, 1 }); // => 2
     * Kata.findUniq(new double[]{ 0, 0, 0.55, 0, 0 }); // => 0.55
     * }</pre>
     * It’s guaranteed that array contains at least 3 numbers.
     * <br>
     * The tests contain some very huge arrays, so think about performance.
     * @param arr
     * @return
     */
    public static double findUniq(double arr[]) {
//        double uniqVal = 0.0;
//        Map<Double, Integer> mapVal = new HashMap<>();
//        int cntUniq = 0;
//        for (double value : arr) {
//            if (mapVal.get(value) != null) {
//                cntUniq = mapVal.get(value) + 1;
//            } else {
//                cntUniq = 1;
//            }
//            mapVal.put(value, cntUniq);
//        }
//        if (mapVal.containsValue(1)) {
//            uniqVal = mapVal.entrySet().stream().filter(entry -> entry.getValue().equals(1))
//                    .mapToDouble(Map.Entry::getKey)
//                    .findFirst().getAsDouble();
//        }
//        // Do the magic
//        return uniqVal;
        Arrays.sort(arr);
        if (arr[0] == arr[1]) {
            return arr[arr.length - 1];
        } else {
            return arr[0];
        }
    }
}
