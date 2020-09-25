package Testcase_Info;

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
 * @date 2020/9/22
 **/
public class get_testcase_info {
    public static void record_tc_info(String program_name, String version) {
        /**
         * get tc
         */
        testcase[] tc = generate.generate(program_name);
        get_partition gp = new get_partition();
        gp.partiton_tc(tc, program_name);
        get_fault_matrix gfm = new get_fault_matrix();
        gfm.get_fm(tc, program_name, version);

        String path = System.getProperty("user.dir") + separator + "src" + separator + "Testcase_Info" + separator + program_name + separator + program_name + "_" + version;
        File file = new File(path);
        PrintWriter printWriter = null;

        /**
         * record txt
         */
        for (testcase t : tc) {
            String content = t.toString();
            try {
                printWriter = new PrintWriter(new FileWriter(file, true));
                printWriter.write(content + "\n");
                printWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String[] program_name = {"Grep", "Gzip", "Make"};
        for (String s : program_name) {
            if (s == "Grep") {
                String[] version = {"v1", "v2", "v3", "v4"};
                for (String v : version) {
                    record_tc_info(s, v);
                }
            } else if (s == "Gzip") {
//                String[] version = {"v1","v2","v4","v5"};
//                for (String v : version) {
//                    record_tc_info(s,v);
//                }
            } else {
                String[] version = {"v1", "v2"};
                for (String v : version) {
                    record_tc_info(s, v);
                }
            }
        }
    }
}
