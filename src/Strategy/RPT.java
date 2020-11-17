package Strategy;

import java.util.Random;

/**
 * @author RoFire
 * @date 2020/11/16
 **/
public class RPT {
    /**
     * the test profile of RPT
     */
    private double[][] RPT;

    /**
     * initialize the test profile of RPT
     *
     * @param numberOfPartitions the number of partitions
     */
    public void initializeRPT(int numberOfPartitions) {
        RPT = new double[numberOfPartitions][numberOfPartitions];
        for (int i = 0; i < numberOfPartitions; i++) {
            for (int j = 0; j < numberOfPartitions; j++) {
                RPT[i][j] = 1.0 / numberOfPartitions;
            }
        }
    }

    /**
     * get a index of partition
     * Note that the first number of partitions is 0
     *
     * @return the index
     */
    public int nextPartition4RPT(int formerPartitionNumber) {
        double[] tempArray = new double[RPT.length];
        for (int i = 0; i < tempArray.length; i++) {
            tempArray[i] = RPT[formerPartitionNumber][i];
        }
        int index = -1;
        double randomNumber = new Random().nextDouble();
        double sum = 0;
        do {
            index++;
            sum += tempArray[index];
        } while (randomNumber >= sum && index < tempArray.length - 1);
        return index;
    }
}
