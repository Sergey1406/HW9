import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ReadingWriting {
    public static void writeToFile() {
        String str = "INFO: Starting JuniorCrudServiceApplication using Java 17.0.7" + "\n"
                + "DEBUG: User admin created" + "\n" + "INFO1: Starting JuniorCrudServiceApplication using Java 17.0.7"
                + "\n" + "DEBUG1: User admin created";

        try {
            File file = new File("log.txt");
            FileOutputStream fop = new FileOutputStream(file);
            byte[] strToBytes = str.getBytes();
            fop.write(strToBytes);
            fop.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void readFromFile() {
        String fileName = "log.txt";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(fileName), StandardCharsets.UTF_8));) {
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void printByLevel(String info, String debug) {
        String fileName = "log.txt";
        StringBuffer strInfo = new StringBuffer(info).append(':');
        StringBuffer strDebug = new StringBuffer(debug).append(':');

        info = new String(strInfo);
        debug = new String(strDebug);


        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(fileName), StandardCharsets.UTF_8));) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] lineSplitted = line.split(" ");
                if (lineSplitted[0].equals(info) || lineSplitted[0].equals(debug)) {
                    System.out.println(line);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        readFromFile();
        printByLevel("INFO", "DEBUG");
    }
}
