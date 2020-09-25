package AlgorithmOnly;

import java.util.Arrays;
import java.util.Random;

/**
 * @author RoFire
 * @date 2020/9/21
 **/
public class Boltzmann_Exploration {

    /**
     * Get the next partition index
     * Boltzmann method
     */
    double[][] RLAPT;

    public int nextPartition4RLAPT(int formerPartitionNumber, int noTC) {
        double[] probability = new double[RLAPT.length];
        double prosum = 0;
        for (int i = 0; i < probability.length; i++) {
            probability[i] = Math.exp(RLAPT[formerPartitionNumber][i]);
            prosum += probability[i];
        }
        for (int i = 0; i < probability.length; i++) {
            probability[i] /= prosum;
        }
        System.out.println(Arrays.toString(probability));
        int index = -1;
        double randomNumber = new Random().nextDouble();
        System.out.println(randomNumber);
        double sum = 0;
        do {
            index++;
            sum += probability[index];
        } while (randomNumber >= sum && index < probability.length - 1);
        System.out.println(index);
        return index;
    }
}
