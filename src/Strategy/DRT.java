package Strategy;

import java.util.Random;

/**
 * @author RoFire
 * @date 2020/9/21
 **/
public class DRT {
    /**
     * the test profile of DRT
     */
    private double[] DRT;

    private double DRT_epsilon = 0.05;

    private double DRT_delta;

    private void setDRT_delta(double DRT_delta) {
        this.DRT_delta = DRT_delta;
    }

    /**
     * initialize the test profile of DRT
     *
     * @param numberOfPartitions the number of partitions
     */
    public void initializeDRT(int numberOfPartitions) {
        DRT = new double[numberOfPartitions];
        for (int i = 0; i < numberOfPartitions; i++) {
            DRT[i] = 1.0 / numberOfPartitions;
        }
    }

    /**
     * get a index of partition
     * Note that the first number of partitions is 0
     *
     * @return the index
     */
    public int nextPartition4DRT() {
        double[] tempArray = DRT;
        int index = -1;
        double randomNumber = new Random().nextDouble();
        double sum = 0;
        do {
            index++;
            sum += tempArray[index];
        } while (randomNumber >= sum && index < tempArray.length - 1);
        return index;
    }

    /**
     * adjust the test profile for DRT testing
     *
     * @param formerSourcePartitionIndex
     * @param isKilledMutans
     */
    public void adjustDRT(int formerSourcePartitionIndex,
                          boolean isKilledMutans) {
        //the source test case and follow-up test case belong to the same partition

        // the test case killed a mutant
        if (isKilledMutans) { //same partition and killed a mutant
            double sum = 0;
            double threshold = DRT_epsilon / (DRT.length - 1);
            for (int i = 0; i < DRT.length; i++) {
                if (i != formerSourcePartitionIndex) {
                    if (DRT[i] > threshold) {
                        DRT[i] -= threshold;
                    } else {
                        DRT[i] = 0;
                    }
                }
                sum += DRT[i];
            }
            DRT[formerSourcePartitionIndex] = 1 - sum;
        } else { // same partition and do not kill a mutant
            double threshod;
            if (DRT[formerSourcePartitionIndex] >= DRT_delta) {
                threshod = DRT_delta / (DRT.length - 1);
                DRT[formerSourcePartitionIndex] -= DRT_delta;
            } else {
                threshod = DRT[formerSourcePartitionIndex] / (DRT.length - 1);
                DRT[formerSourcePartitionIndex] = 0;
            }
            for (int i = 0; i < DRT.length; i++) {
                if (i != formerSourcePartitionIndex) {
                    DRT[i] += threshod;
                }
            }
        }
    }

    public void setParameters4DRT(String program_name, String version) {
        if (program_name.equals("Grep")) {
            if (version.equals("v1")) setDRT_delta(4.0017852457362E-4);
            else if (version.equals("v2")) setDRT_delta(0);
            else if (version.equals("v3")) setDRT_delta(0);
            else if (version.equals("v4")) setDRT_delta(0);
            else setDRT_delta(0);
        } else if (program_name.equals("Gzip")) {
            if (version.equals("v1")) setDRT_delta(0);
            else if (version.equals("v2")) setDRT_delta(0);
            else if (version.equals("v3")) setDRT_delta(0);
            else if (version.equals("v4")) setDRT_delta(0);
            else setDRT_delta(0);
        } else if (program_name.equals("Make")) {
            if (version.equals("v1")) setDRT_delta(0);
            else if (version.equals("v2")) setDRT_delta(0);
            else setDRT_delta(0);
        }
    }
}
