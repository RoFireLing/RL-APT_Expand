package AlgorithmOnly;

/**
 * @author RoFire
 * @date 2020/9/21
 **/
public class RLAPT_SARSA {

    // param of RL-APT
    private double[][] RLAPT;

    private double RLAPT_alpha = 1;

    private double RLAPT_gamma = 0.6;

    private double RLAPT_r0 = 1;

    /**
     * Update Q table using SARSA method
     *
     * @param NowPartitionIndex
     * @param NextPartitionIndex
     * @param NextNextPartitionIndex
     * @param isKilledMutans
     */
    public void adjustRLAPT_S(int NowPartitionIndex, int NextPartitionIndex, int NextNextPartitionIndex,
                              boolean isKilledMutans) {
        double r = 0;
        if (NowPartitionIndex == NextPartitionIndex) {
            if (isKilledMutans) {
                r = RLAPT_r0;
            } else
                r = -RLAPT_r0;
        } else {
            if (isKilledMutans) {
                r = -RLAPT_r0 / RLAPT.length;
            } else
                r = RLAPT_r0 / RLAPT.length;
        }
        RLAPT[NowPartitionIndex][NextPartitionIndex] += RLAPT_alpha
                * (r + RLAPT_gamma * RLAPT[NextPartitionIndex][NextNextPartitionIndex]
                - RLAPT[NowPartitionIndex][NextPartitionIndex]);
    }
}
