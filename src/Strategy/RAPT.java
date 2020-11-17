package Strategy;

import java.util.Random;

/**
 * @author RoFire
 * @date 2020/9/21
 **/
public class RAPT {
    // 70% testcases in each partition
    private static final int[] pun4Grep = {173, 4, 154};
    private static final int[] pun4Gzip = {143, 3, 4, 2};
    private static final int[] pun4Make = {135, 135, 135, 152};

    /**
     * the test profile of RAPT
     */
    private double[] RAPT;

    private double RAPT_epsilon = 0.05;

    private double RAPT_delta;

    /**
     * the factor of reward
     */
    private int[] rew;

    /**
     * the factor of punishment
     */
    private int[] bou;

    private int[] pun;

    private void setRAPT_delta(double RAPT_delta) {
        this.RAPT_delta = RAPT_delta;
    }

    private void setBou_RAPT(String program_name, int[] punArray) {
        if (program_name.equals("Grep")) {
            rew = new int[9];
            pun = new int[9];
            bou = new int[9];
            for (int i = 0; i < punArray.length; i++) {
                bou[i] = punArray[i];
            }
        } else if (program_name.equals("Gzip")) {
            rew = new int[6];
            pun = new int[6];
            bou = new int[6];
            for (int i = 0; i < punArray.length; i++) {
                bou[i] = punArray[i];
            }
        } else if (program_name.equals("Make")) {
            rew = new int[8];
            pun = new int[8];
            bou = new int[8];
            for (int i = 0; i < punArray.length; i++) {
                bou[i] = punArray[i];
            }
        }

    }

    /**
     * initialize the test profile of RAPT
     *
     * @param numberOfPartitions the number of partitions
     */
    public void initializeRAPT(int numberOfPartitions) {
        RAPT = new double[numberOfPartitions];
        for (int i = 0; i < RAPT.length; i++) {
            RAPT[i] = 1.0 / numberOfPartitions;
            pun[i] = 0;
        }
    }

    /**
     * get a index of partition
     * Note that the first number of partitions is 0
     *
     * @return the index
     */
    public int nextPartition4RAPT() {
        boolean flag = false;
        int partitionindex = 0;
        for (int i = 0; i < rew.length; i++) {
            if (rew[i] > 0) {
                flag = true;
                partitionindex = i;
                break;
            }
        }
        if (flag) {
            return partitionindex;
        } else {
            int index = -1;
            double randomNumber = new Random().nextDouble();
            double sum = 0;
            do {
                index++;
                sum += RAPT[index];
            } while (randomNumber >= sum && index < RAPT.length - 1);
            return index;
        }
    }


    /**
     * adjust the test profile for RAPT testing
     *
     * @param
     * @param isKilledMutant
     */
    public void adjustRAPT(int formersourcePartitionIndex, boolean isKilledMutant) {
        double old_i = RAPT[formersourcePartitionIndex];

        if (isKilledMutant) {
            double sum = 0;
            for (int i = 0; i < RAPT.length; i++) {
                if (i != formersourcePartitionIndex) {
                    RAPT[i] -= (1 + Math.log(rew[formersourcePartitionIndex]))
                            * RAPT_epsilon / (RAPT.length - 1);
                    if (RAPT[i] < 0) {
                        RAPT[i] = 0;
                    }
                }
                sum += RAPT[i];
            }
            RAPT[formersourcePartitionIndex] = 1 - sum;
        } else {
            for (int i = 0; i < RAPT.length; i++) {
                if (i == formersourcePartitionIndex) {
                    if (old_i >= RAPT_delta) {
                        RAPT[i] -= RAPT_delta;
                    }
                    if (old_i < RAPT_delta || bou[i] == pun[i]) {
                        RAPT[i] = 0;
                    }
                } else {
                    if (old_i >= RAPT_delta) {
                        RAPT[i] += RAPT_delta / (RAPT.length - 1);
                    }
                    if (old_i < RAPT_delta || bou[i] == pun[i]) {
                        RAPT[i] += old_i / (RAPT.length - 1);
                    }
                }
            }
        }
    }


    public void setParameters4RAPT(String program_name, String version) {
        if (program_name.equals("Grep")) {
            if (version.equals("v1")) setRAPT_delta(4.0017852457362E-4);
            else if (version.equals("v2")) setRAPT_delta(0);
            else if (version.equals("v3")) setRAPT_delta(0);
            else if (version.equals("v4")) setRAPT_delta(0);
            else setRAPT_delta(0);
            setBou_RAPT(program_name, pun4Grep);
        } else if (program_name.equals("Gzip")) {
            if (version.equals("v1")) setRAPT_delta(0);
            else if (version.equals("v2")) setRAPT_delta(0);
            else if (version.equals("v4")) setRAPT_delta(0);
            else if (version.equals("v5")) setRAPT_delta(0);
            else setRAPT_delta(0);
            setBou_RAPT(program_name, pun4Gzip);
        } else if (program_name.equals("Make")) {
            if (version.equals("v1")) setRAPT_delta(0);
            else if (version.equals("v2")) setRAPT_delta(0);
            else setRAPT_delta(0);
            setBou_RAPT(program_name, pun4Make);
        }
    }
}
