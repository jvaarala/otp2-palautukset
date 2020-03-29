package singleton;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ArrayTest {
    private static Random RANDOM = new Random();
    private static final String RESULTS_CSV = "list-types_test.csv";
    private static final int SAMPLES_FOR_AVERAGE = 10000;

    public static void main(String[] args) {

        TimerSingleton timer = TimerSingleton.getINSTANCE();

        ArrayList<Long> arraySamplesForAverage = new ArrayList<>();
        ArrayList<Long> arrayListSamplesForAverage = new ArrayList<>();
        ArrayList<Long> listSamplesForAverage = new ArrayList<>();
        long stoptime;

        int nMax = 1000;
        long[][] finalResult = new long[nMax][];
        for (int i = 0; i < nMax; i++) {
            finalResult[i] = new long[3];
            int testInput = RANDOM.nextInt();

            for (int z = 0; z < SAMPLES_FOR_AVERAGE; z++) {
                int[] testArray = new int[i];
                List<Integer> testList = new ArrayList<>();
                ArrayList<Integer> testArrayList = new ArrayList<>();

                // testing start
                timer.reset();
                for (int j = 0; j < i; j++) {
                    testArray[j] = testInput;
                }
                stoptime = timer.getNanotime();
                arraySamplesForAverage.add(stoptime);

                timer.reset();
                for (int j = 0; j < i; j++) {
                    testList.add(testInput);
                }
                stoptime = timer.getNanotime();
                listSamplesForAverage.add(stoptime);

                timer.reset();
                for (int j = 0; j < i; j++) {
                    testArrayList.add(testInput);
                }
                stoptime = timer.getNanotime();
                arrayListSamplesForAverage.add(stoptime);
            }


            finalResult[i][0] = average(arraySamplesForAverage);
            finalResult[i][1] = average(listSamplesForAverage);
            finalResult[i][2] = average(arrayListSamplesForAverage);

            arrayListSamplesForAverage.clear();
            arraySamplesForAverage.clear();
            listSamplesForAverage.clear();
        }

        System.out.println(Arrays.deepToString(finalResult));

        System.out.println("\n\nKirjoitetaan tulokset tiedostoon.");
        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(RESULTS_CSV));
                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.EXCEL
                        .withHeader("array", "List", "ArrayList"));
        ) {
            for (long[] resultSet : finalResult) {
                csvPrinter.printRecord(String.valueOf(resultSet[0]), String.valueOf(resultSet[1]), String.valueOf(resultSet[2]));
            }
            csvPrinter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static long average(ArrayList<Long> arrayList) {
        long sum = 0;
        for (Long i : arrayList) {
            sum = sum + i;
        }

        return sum / arrayList.size();
    }
}
