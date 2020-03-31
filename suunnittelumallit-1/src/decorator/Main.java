package decorator;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        printMenu();
    }

    private static void printMenu() {
        int select;

        ArrayAuthDecorator arrayAuthDec = new ArrayAuthDecorator();

        Integer data; // Pinon data-kenttä
        do {

            System.out.println("\n\t\t\t1. Alkion lisääminen.");
            System.out.println("\t\t\t2. Alkion poistaminen.");
            System.out.println("\t\t\t3. Pinon sisältö.");
            System.out.println("\t\t\t4. Alkioiden lukumäärä.");
            System.out.println("\t\t\t5. lopetus ");
            System.out.print("\n\n"); // tehdään tyhjiä rivejä
            select = Lue.kluku();
            switch (select) {
                case 1:
                    System.out.println("Anna alkion sisältö (kokonaisluku)");
                    data = Lue.kluku();
                    arrayAuthDec.add(data);
                    break;
                case 2:
                    System.out.println("Anna alkion indeksi (kokonaisluku)");
                    data = Lue.kluku();
                    if (data == null)
                        System.out.println("Ei alkioita!");
                    else
                        arrayAuthDec.delete(data);
                    break;
                case 3:
                    ArrayList<Integer> temp = arrayAuthDec.get();
                    System.out.println(Arrays.deepToString(temp.toArray()));
                    break;
                case 4:
                    System.out.println(arrayAuthDec.get().size());
                    break;
                case 5:
                    break;
            }
        }
        while (select != 5);
    }
}
