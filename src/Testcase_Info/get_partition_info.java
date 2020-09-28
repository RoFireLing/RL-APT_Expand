package Testcase_Info;

import Constant.constant;
import GenerateTestSuit.generate;
import GenerateTestSuit.get_fault_matrix;
import GenerateTestSuit.get_partition;
import GenerateTestSuit.testcase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static java.io.File.separator;

/**
 * @author RoFire
 * @date 2020/9/28
 **/
public class get_partition_info {
    public static void get_partition_info(String program_name) throws IOException {
        /**
         * get tc
         */
        testcase[] tc = generate.generate(program_name);
        get_partition gp = new get_partition();
        gp.partiton_tc(tc, program_name);
        get_fault_matrix gfm = new get_fault_matrix();

        String path = System.getProperty("user.dir") + separator + "src" + separator + "Testcase_Info" + separator + program_name + separator + program_name + "_partition";
        File file = new File(path);
        PrintWriter printWriter = null;

        /**
         * record txt
         */
        // partition
        for (int i = 0; i < constant.get_num_of_partition(program_name); i++) {
            printWriter = new PrintWriter(new FileWriter(file, true));
            printWriter.write("partition_" + String.valueOf(i) + "\n");
            printWriter.close();
            int cnt = 0;
            for (testcase t : tc) {
                if (t.getPartition() == i) {
                    cnt++;
                    String content = t.getContent();
                    printWriter = new PrintWriter(new FileWriter(file, true));
                    printWriter.write(content + "\n");
                    printWriter.close();
                }
            }
            printWriter = new PrintWriter(new FileWriter(file, true));
            printWriter.write("sum: " + String.valueOf(cnt) + "\n\n");
            printWriter.close();
        }
    }

    public static void main(String[] args) throws IOException {
        String[] program_name = {"Grep", "Gzip", "Make"};
        for (String s : program_name) {
            if (s == "Grep") {
                get_partition_info(s);
            } else if (s == "Gzip") {
//                    get_partition_info(s);
            } else {
                get_partition_info(s);
            }
        }
    }
}
