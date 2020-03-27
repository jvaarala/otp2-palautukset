/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package quicksort;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import sun.jvm.hotspot.memory.PlaceholderEntry;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author kamaj /jessevaa
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SortAlgorithms {

    private static final String TULOKSET_CSV = "./tulokset.csv";

    private static int[] tau;

    public static void main(String[] args) {
        ArrayList<Long> tulokset = new ArrayList<>();
        long selectSortTime;
        long mergeSortTime;
        long quickSortTime;
        int y = 10000;

        for (int z = 1; z < y; z++) {
            tau = new int[z]; // aputaulukko (ei varata tätä pinosta!)
            int[] taul = new int[z]; //taul tallettaa lajiteltavat tiedot
            Random r = new Random(); //luodaan satunnaislukugeneraattori
            System.out.println("\n");
            System.out.println("Elementtien määrä:\t" + z);
            System.out.println("Generoidaan syöttöaineisto:");
            for (int i = 0; i < z; i++) {
                taul[i] = r.nextInt(Integer.MAX_VALUE); //generoidaan luvut
                System.out.print("*");
                if (i > 0 && i % 100 == 0) // rivinvaihto
                    System.out.println();
            }
            ///////
            // run sorting algoriddims
            selectSortTime = selectSort(taul, z);
            quickSortTime = quickSort(taul, 0, z - 1);
            mergeSortTime = mergeSort(taul, 0, z - 1);


            tulokset.add(((long) z));
            tulokset.add(selectSortTime);
            tulokset.add(quickSortTime);
            tulokset.add(mergeSortTime);
        }

        ///////
        // write results down
        System.out.println("\n\nKirjoitetaan tulokset tiedostoon.");
        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(TULOKSET_CSV));
                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.EXCEL
                        .withHeader("n", "selectsort", "mergesort", "quicksort"));
        ) {

            int numberOfColumns = 4;
            for (int h = numberOfColumns; h <= tulokset.size(); h++) {
                if (h % numberOfColumns == 0) {
                    csvPrinter.printRecord(String.valueOf(tulokset.get(h - 4)), String.valueOf(tulokset.get(h - 3)), String.valueOf(tulokset.get(h - 2)), String.valueOf(tulokset.get(h - 1)));
                    if (h > 0 && h % 100 == 0) System.out.print(".");
                }
            }
            csvPrinter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n\nValmista.\n");

    }

    public static long selectSort(int table[], int max) {

        int i, j, k, apu, pienin;

        long startTime = System.nanoTime();
        for (i = 0; i < max; i++) {
            pienin = i;
            for (j = i + 1; j < max; j++) {
                /* löytyykö taulukon loppupäästä pienempää alkiota? */
                if (table[j] < table[pienin]) {
                    pienin = j;
                }
            }
            if (pienin != i) {
                /* jos löytyi suoritetaan alkioiden vaihto */
                apu = table[pienin];
                table[pienin] = table[i];
                table[i] = apu;
            }
        }
        long totalTimeNano = System.nanoTime() - startTime;
        return totalTimeNano;

    }

    public static long quickSort(int table[], int lo0, int hi0) {
        long startTime = System.nanoTime();
        int lo = lo0;
        int hi = hi0;
        int mid, swap;

        mid = table[(lo0 + hi0) / 2];
        while (lo <= hi) {
            while (table[lo] < mid) {
                ++lo;
            }

            while (table[hi] > mid) {
                --hi;
            }

            if (lo <= hi) {
                swap = table[lo];
                table[lo] = table[hi];
                ++lo;
                table[hi] = swap;
                --hi;
            }
        }

        if (lo0 < hi) {
            quickSort(table, lo0, hi);
        }
        if (lo < hi0) {
            quickSort(table, lo, hi0);
        }

        long totalTimeNano = System.nanoTime() - startTime;
        return totalTimeNano;
    }


    //oletus: osataulukot t[p..q] ja t[q+1...r] ovat järjestyksess„
    public static void merge(int t[], int p, int q, int r) {
        //i osoittaa 1. osataulukkoa, j osoittaa 2. osataulukkoa
        // k osoittaa aputaulukkoa, johon yhdiste kirjoitetaan.
        int i = p, j = q + 1, k = 0;
        while (i < q + 1 && j < r + 1) {
            if (t[i] < t[j]) {
                tau[k++] = t[i++];
            } else {
                tau[k++] = t[j++];
            }
        }
        //toinen osataulukko käsitelty, siirretään toisen käsittelemättömät
        while (i < q + 1)
            tau[k++] = t[i++];
        while (j < r + 1)
            tau[k++] = t[j++];
        //siirretään yhdiste alkuperäiseen taulukkoon
        for (i = 0; i < k; i++) {
            t[p + i] = tau[i];
        }
    }

    public static long mergeSort(int t[], int alku, int loppu) {
        long startTime = System.nanoTime();
        int ositus;
        long la, ll, lt;
        if (alku < loppu) { //onko väh. 2 alkiota, että voidaan suorittaa ositus

            la = alku;
            ll = loppu;
            lt = (la + ll) / 2;
            ositus = (int) lt;
            mergeSort(t, alku, ositus);//lajitellaan taulukon alkupää
            mergeSort(t, ositus + 1, loppu);//lajitellaan taulukon loppupää
            merge(t, alku, ositus, loppu);//yhdistetään lajitellut osataulukot
        }

        long totalTimeNano = System.nanoTime() - startTime;
        return totalTimeNano;

    }
}

