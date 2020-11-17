package Util;

import java.util.Arrays;

/**
 * @author RoFire
 * @date 2020/11/17
 **/
public class CalculateDelta {
    /**
     * calculate delta
     *
     * @param M largest failure rate
     * @param D second largest failure rate
     * @return
     */
    public static double[] cal_delta(double M, double D) {
        double epsilon = 0.05;
        double[] range = new double[2];
        range[0] = epsilon / (1 / (D - 1) - 1);
        range[1] = epsilon / (1 / M - 1);
        return range;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(cal_delta(0.0091, 0.0041)));
    }
}
