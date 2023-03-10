package org.gpadula.ai2sjobfairapp;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Utils {
    private Utils() {
        throw new IllegalStateException("Utility class");
    }

    static String[][] readCsv(String file) throws IOException {
        List<String[]> lines = new ArrayList<>();
        try (BufferedReader r = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = r.readLine()) != null)
                lines.add(line.split(",", -1));
        }
        return lines.toArray(new String[lines.size()][]);
    }

    static void writeCSV(String[][] data, String file, int rows, int columns) throws IOException {
        StringBuilder bld = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                bld.append(data[i][j]);
                if (j != columns - 1) {
                    bld.append(",");
                }
            }
            if (i != rows - 1) {
                bld.append("\n");
            }

        }
        String s = bld.toString();
        try (FileWriter myWriter = new FileWriter(file)) {
            myWriter.write(s);
        }
    }

}
