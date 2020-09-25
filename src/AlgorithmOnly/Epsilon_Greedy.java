package AlgorithmOnly;

import java.util.Random;

/**
 * @author RoFire
 * @date 2020/9/21
 **/
public class Epsilon_Greedy {

    /**
     * Get the next partition index
     * epsilon method
     */
    double[][] RLAPT;

    public int nextPartition4RLAPT(int formerPartitionNumber, int noTC) {
        int index = -1;
        double randomNumber = new Random().nextDouble();
//        double epsilon = 1 / Math.sqrt(noTC);
        double epsilon;
        if (noTC < 10 * RLAPT.length)
            epsilon = 1 - 0.05 * (noTC / RLAPT.length);
        else
            epsilon = 0.5;

        if (randomNumber <= epsilon) {
            System.out.println("exploration");
            index = new Random().nextInt(RLAPT.length);
        } else {
            System.out.println("exploitation");
            index = (int) new Get_Max_Val_or_Index().getMax(RLAPT[formerPartitionNumber])[1];
        }
        return index;
    }
}
