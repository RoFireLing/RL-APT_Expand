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
public class get_mutant_info {
    public static void get_mutant_info(String program_name, String version) throws IOException {
        /**
         * get tc
         */
        testcase[] tc = generate.generate(program_name);
        get_partition gp = new get_partition();
        gp.partiton_tc(tc, program_name);
        get_fault_matrix gfm = new get_fault_matrix();
        gfm.get_fm(tc, program_name, version);

        String path = System.getProperty("user.dir") + separator + "src" + separator + "Testcase_Info" + separator + program_name + separator + program_name + "_" + version + "_mutant_stat";
        File file = new File(path);
        PrintWriter printWriter = null;

        /**
         * record txt
         */
        // killable mutant stat.
        int[] mutant_stat = new int[constant.get_all_mutant_num(program_name, version)];
        int mutant_sum = 0;
        if (program_name == "Grep") {
            mutant_sum = 470;
        }
        if (program_name == "Gzip") {
            mutant_sum = 214;
        }
        if (program_name == "Make") {
            mutant_sum = 793;
        }
        for (testcase t : tc) {
            for (int i = 0; i < t.getKillableMutants().size(); i++) {
                mutant_stat[t.getKillableMutants().get(i) - 1]++;
            }
        }
        for (int i = 0; i < mutant_stat.length; i++) {
            if (mutant_stat[i] != 0) {
                printWriter = new PrintWriter(new FileWriter(file, true));
                printWriter.write("Mutant_" + String.valueOf(i + 1) + ": " + String.valueOf(mutant_stat[i]) + ": " + String.valueOf((double) mutant_stat[i] / (double) mutant_sum) + "\n");
                printWriter.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String[] program_name = {"Grep", "Gzip", "Make"};
        for (String s : program_name) {
            if (s == "Grep") {
                String[] version = {"v1", "v2", "v3", "v4"};
                for (String v : version) {
                    get_mutant_info(s, v);
                }
            } else if (s == "Gzip") {
                String[] version = {"v1", "v2", "v4", "v5"};
                for (String v : version) {
                    get_mutant_info(s, v);
                }
            } else {
                String[] version = {"v1", "v2"};
                for (String v : version) {
                    get_mutant_info(s, v);
                }
            }
        }
    }
}
