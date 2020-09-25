package Excuter;

import Constant.constant;

import java.util.Random;

/**
 * @author RoFire
 * @date 2020/9/24
 **/
public class excute {
    /**
     * initialize test sequence
     */
    public static void genearate_testseq() {
        int[] testseq = new int[constant.testcasenum];
        for (int s = 0; s < testseq.length; s++) {
            testseq[s] = new Random().nextInt(1000);
        }
        constant.setTestseq(testseq);
    }

    /**
     * test
     *
     * @param args
     */
    public static void main(String[] args) {
        genearate_testseq();
        String program_name = "Grep";
        String version = "v1";

        rlapt_q qtest = new rlapt_q();
        for (int repeatTime = 0; repeatTime < 10; repeatTime++) {
            qtest.executeTestCase(program_name, version, repeatTime);
        }
//        rlapt_s stest = new rlapt_s();
//        for (int repeatTime = 0; repeatTime < 10; repeatTime++) {
//            stest.executeTestCase(program_name, version, repeatTime);
//        }
        mapt mtest = new mapt();
        for (int repeatTime = 0; repeatTime < 10; repeatTime++) {
            mtest.executeTestCase(program_name, version, repeatTime);
        }
//        rapt rtest = new rapt();
//        for (int repeatTime = 0; repeatTime < 10; repeatTime++) {
//            rtest.executeTestCase(program_name, version, repeatTime);
//        }
//        drt dtest = new drt();
//        for (int repeatTime = 0; repeatTime < 10; repeatTime++) {
//            dtest.executeTestCase(program_name, version, repeatTime);
//        }
    }
}
