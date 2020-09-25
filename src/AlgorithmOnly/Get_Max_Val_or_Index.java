package AlgorithmOnly;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author RoFire
 * @date 2020/9/21
 **/
public class Get_Max_Val_or_Index {
    /**
     * Get the maximum value and maximum value index of a row of the matrix
     * (if there are multiple maximum values, randomly select an index)
     *
     * @param arr
     * @return
     */
    public static double[] getMax(double[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int maxIndex = 0;
        double[] arrnew = new double[2];
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[maxIndex] < arr[i + 1]) {
                maxIndex = i + 1;
            }
        }
        List<Integer> maxlist = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[maxIndex]) {
                maxlist.add(i);
            }
        }
        arrnew[0] = arr[maxIndex];
        arrnew[1] = maxlist.get(new Random().nextInt(maxlist.size()));
        return arrnew;
    }
}
