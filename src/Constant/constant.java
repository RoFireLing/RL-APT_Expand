package Constant;

import static java.io.File.separator;

/**
 * @author RoFire
 * @date 2020/9/21
 **/
public class constant {
    /**
     * the number of repeating times for testing
     */
    public static final int repeatnum = 30;

    /**
     * The number of test cases generated
     * the length of the test sequence
     */
    public static final int testcasenum = 500000;
    /**
     * The number of partitions
     */
    public static final int grep_partition_num = 9;
    public static final int gzip_partition_num = 6;
    public static final int make_partition_num = 8;
    /**
     * The number of test cases for each program
     */
    public static final int grep_tc_num = 470;
    public static final int gzip_tc_num = 214;
    public static final int make_tc_num = 793;
    /**
     * Number of versions of each program
     */
    public static final int grep_version_num = 4;
    public static final int gzip_version_num = 4;
    public static final int make_version_num = 2;
    /**
     * Number of used-mutants in each program
     */
    public static final int grep_v1_mutant_num = 2;
    public static final int grep_v2_mutant_num = 2;
    public static final int grep_v3_mutant_num = 2;
    public static final int grep_v4_mutant_num = 1;
    public static final int gzip_v1_mutant_num = 3;
    public static final int gzip_v2_mutant_num = 1;
    public static final int gzip_v4_mutant_num = 2;
    public static final int gzip_v5_mutant_num = 3;
    public static final int make_v1_mutant_num = 2;
    public static final int make_v2_mutant_num = 1;
    /**
     * Index of used-mutants in each program
     */
    public static final int[] grep_v1_mutant = {8, 14};
    public static final int[] grep_v2_mutant = {1, 6};
    public static final int[] grep_v3_mutant = {1, 18};
    public static final int[] grep_v4_mutant = {2};
    public static final int[] gzip_v1_mutant = {2, 14};
    public static final int[] gzip_v2_mutant = {3};
    public static final int[] gzip_v4_mutant = {1, 10};
    public static final int[] gzip_v5_mutant = {7, 9, 13};
    public static final int[] make_v1_mutant = {13, 15};
    public static final int[] make_v2_mutant = {4};
    /**
     * local path
     */
    public static final String grep_tc_path = System.getProperty("user.dir") + separator + "src" + separator + "Program_Info" + separator + "Grep" + separator + "grep_tc.txt";
    public static final String gzip_tc_path = System.getProperty("user.dir") + separator + "src" + separator + "Program_Info" + separator + "Gzip" + separator + "gzip_tc.txt";
    public static final String make_tc_path = System.getProperty("user.dir") + separator + "src" + separator + "Program_Info" + separator + "Make" + separator + "make_tc.txt";
    public static final String grep_fm_v1_path = System.getProperty("user.dir") + separator + "src" + separator + "Program_Info" + separator + "Grep" + separator + "grep_fm_v1.txt";
    public static final String grep_fm_v2_path = System.getProperty("user.dir") + separator + "src" + separator + "Program_Info" + separator + "Grep" + separator + "grep_fm_v2.txt";
    public static final String grep_fm_v3_path = System.getProperty("user.dir") + separator + "src" + separator + "Program_Info" + separator + "Grep" + separator + "grep_fm_v3.txt";
    public static final String grep_fm_v4_path = System.getProperty("user.dir") + separator + "src" + separator + "Program_Info" + separator + "Grep" + separator + "grep_fm_v4.txt";
    public static final String gzip_fm_v1_path = System.getProperty("user.dir") + separator + "src" + separator + "Program_Info" + separator + "Gzip" + separator + "gzip_fm_v1.txt";
    public static final String gzip_fm_v2_path = System.getProperty("user.dir") + separator + "src" + separator + "Program_Info" + separator + "Gzip" + separator + "gzip_fm_v2.txt";
    public static final String gzip_fm_v4_path = System.getProperty("user.dir") + separator + "src" + separator + "Program_Info" + separator + "Gzip" + separator + "gzip_fm_v4.txt";
    public static final String gzip_fm_v5_path = System.getProperty("user.dir") + separator + "src" + separator + "Program_Info" + separator + "Gzip" + separator + "gzip_fm_v5.txt";
    public static final String make_fm_v1_path = System.getProperty("user.dir") + separator + "src" + separator + "Program_Info" + separator + "Make" + separator + "make_fm_v1.txt";
    public static final String make_fm_v2_path = System.getProperty("user.dir") + separator + "src" + separator + "Program_Info" + separator + "Make" + separator + "make_fm_v2.txt";
    public static final String result_path = System.getProperty("user.dir") + separator + "src" + separator + "Result";
    /**
     * test sequence
     */
    public static int[] testseq = new int[testcasenum];

    public static int[] getTestseq() {
        return testseq;
    }

    public static void setTestseq(int[] testseq) {
        constant.testseq = testseq;
    }

    public static int get_num_of_partition(String program_name) {
        if (program_name == "Grep") {
            return grep_partition_num;
        }
        if (program_name == "Gzip") {
            return gzip_partition_num;
        }
        if (program_name == "Make") {
            return make_partition_num;
        }
        return -1;
    }

    public static int get_tc_num(String program_name) {
        if (program_name == "Grep") {
            return grep_tc_num;
        } else if (program_name == "Gzip") {
            return gzip_tc_num;
        } else if (program_name == "Make") {
            return make_tc_num;
        } else {
            return -1;
        }
    }

    public static int get_version_num(String program_name) {
        if (program_name == "Grep") {
            return grep_version_num;
        } else if (program_name == "Gzip") {
            return gzip_version_num;
        } else if (program_name == "Make") {
            return make_version_num;
        } else {
            return -1;
        }
    }

    public static int get_mutant_num(String program_name, String version) {
        if (program_name == "Grep") {
            if (version == "v1") return grep_v1_mutant_num;
            if (version == "v2") return grep_v2_mutant_num;
            if (version == "v3") return grep_v3_mutant_num;
            if (version == "v4") return grep_v4_mutant_num;
            else return -1;
        } else if (program_name == "Gzip") {
            if (version == "v1") return gzip_v1_mutant_num;
            if (version == "v2") return gzip_v2_mutant_num;
            if (version == "v4") return gzip_v4_mutant_num;
            if (version == "v5") return gzip_v5_mutant_num;
            else return -1;
        } else {
            if (version == "v1") return make_v1_mutant_num;
            if (version == "v2") return make_v2_mutant_num;
            else return -1;
        }
    }

    public static int[] get_mutant(String program_name, String version) {
        if (program_name == "Grep") {
            if (version == "v1") return grep_v1_mutant;
            if (version == "v2") return grep_v2_mutant;
            if (version == "v3") return grep_v3_mutant;
            if (version == "v4") return grep_v4_mutant;
            else return null;
        } else if (program_name == "Gzip") {
            if (version == "v1") return gzip_v1_mutant;
            if (version == "v2") return gzip_v2_mutant;
            if (version == "v4") return gzip_v4_mutant;
            if (version == "v5") return gzip_v5_mutant;
            else return null;
        } else {
            if (version == "v1") return make_v1_mutant;
            if (version == "v2") return make_v2_mutant;
            else return null;
        }
    }

    /**
     * The number of all mutants of each program and corresponding version
     *
     * @param program_name
     * @param version
     * @return
     */
    public static int get_all_mutant_num(String program_name, String version) {
        if (program_name == "Grep") {
            if (version == "v1") return 18;
            if (version == "v2") return 8;
            if (version == "v3") return 18;
            if (version == "v4") return 12;
            else return -1;
        } else if (program_name == "Gzip") {
            if (version == "v1") return 16;
            if (version == "v2") return 7;
            if (version == "v4") return 12;
            if (version == "v5") return 14;
            else return -1;
        } else {
            if (version == "v1") return 19;
            if (version == "v2") return 6;
            else return -1;
        }
    }

    public static String getGrep_fm_v1_path() {
        return grep_fm_v1_path;
    }

    public static String getGrep_fm_v2_path() {
        return grep_fm_v2_path;
    }

    public static String getGrep_fm_v3_path() {
        return grep_fm_v3_path;
    }

    public static String getGrep_fm_v4_path() {
        return grep_fm_v4_path;
    }

    public static String getGzip_fm_v1_path() {
        return gzip_fm_v1_path;
    }

    public static String getGzip_fm_v2_path() {
        return gzip_fm_v2_path;
    }

    public static String getGzip_fm_v4_path() {
        return gzip_fm_v4_path;
    }

    public static String getGzip_fm_v5_path() {
        return gzip_fm_v5_path;
    }

    public static String getMake_fm_v1_path() {
        return make_fm_v1_path;
    }

    public static String getMake_fm_v2_path() {
        return make_fm_v2_path;
    }

}
