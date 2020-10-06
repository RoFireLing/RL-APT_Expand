package GenerateTestSuit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author RoFire
 * @date 2020/9/21
 **/
public class get_partition {
    /**
     * Partition for test cases
     *
     * @param tc
     * @param program_name
     */
    public static void partiton_tc(testcase[] tc, String program_name) {
        if (program_name == "Grep") {
            for (testcase t : tc) {
                String content = t.getContent();
                if (content.indexOf("-E") != -1) {
                    // E single
                    if (content.indexOf("\'") != -1) {
                        t.setPartition(0);
                    }
                    // E double
                    else if (content.indexOf("\"") != -1) {
                        t.setPartition(1);
                    }
                    // E not
                    else {
                        t.setPartition(2);
                    }
                } else if (content.indexOf("-F") != -1) {
                    // F single
                    if (content.indexOf("\'") != -1) {
                        t.setPartition(3);
                    }
                    // F double
                    else if (content.indexOf("\"") != -1) {
                        t.setPartition(4);
                    }
                    // F not
                    else {
                        t.setPartition(5);
                    }
                } else {
                    // G or none single
                    if (content.indexOf("\'") != -1) {
                        t.setPartition(6);
                    }
                    // G or none double
                    else if (content.indexOf("\"") != -1) {
                        t.setPartition(7);
                    }
                    // G or none not
                    else {
                        t.setPartition(8);
                    }
                }

            }
        } else if (program_name == "Gzip") {
            for (testcase t : tc) {
                String content = t.getContent();
                if (content.indexOf("-r") != -1 || content.indexOf("-qr") != -1 || content.indexOf("-fr") != -1) {
                    if (content.indexOf("subdir") != -1) {
                        // -r dir
                        t.setPartition(2);
                    } else {
                        // -r normal
                        t.setPartition(0);
                    }
                } else {
                    if (content.indexOf("subdir") != -1) {
                        // dir
                        t.setPartition(3);
                    } else if (content.indexOf("zipfile") != -1) {
                        // zip
                        t.setPartition(4);
                    } else if (content.indexOf("binaryfile") != -1) {
                        // binary
                        t.setPartition(5);
                    } else {
                        // normal
                        t.setPartition(1);
                    }
                }

            }
        } else if (program_name == "Make") {
            for (testcase t : tc) {
                String content = t.getContent();

                // Extract the main part
                String pattern = "-P \\[[^\\]]{0,}\\]{1}";
                Pattern p = Pattern.compile(pattern);
                Matcher m = p.matcher(content);
                while (m.find()) {
                    content = m.group();
                }

                if (content.indexOf("-w") != -1) {
                    if (content.indexOf("-s") != -1) {
                        if (content.indexOf("-i") != -1) {
                            // -w -s -i
                            t.setPartition(0);
                        } else t.setPartition(1);// -w -s
                    } else {
                        if (content.indexOf("-i") != -1) {
                            // -w -i
                            t.setPartition(2);
                        } else t.setPartition(3);// -w
                    }
                } else {
                    if (content.indexOf("-s") != -1) {
                        if (content.indexOf("-i") != -1) {
                            // -s -i
                            t.setPartition(4);
                        } else t.setPartition(5);// -s
                    } else {
                        if (content.indexOf("-i") != -1) {
                            // -i
                            t.setPartition(6);
                        } else t.setPartition(7);// none
                    }
                }
            }
        }
    }
}
