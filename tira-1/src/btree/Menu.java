package btree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kamaj
 */
public class Menu {
    //main alkaa-----------------------------------------------------------------------------
    public static void main(String[] args) {

        printMenu();

    }

    //main loppuu --------------------------------------------------------------------------
//printMenu alkaa------------------------------------------------------------------
    private static void printMenu() {
        char select;
        BinaryTree tree = new BinaryTree();

        tree.insert("d");
        tree.insert("a");
        tree.insert("c");
        tree.insert("f");
        tree.insert("g");

        String data;
        do {

            System.out.println("\n\t\t\t1. Lisää avain.");
            System.out.println("\t\t\t2. Etsi avaimella.");
            System.out.println("\t\t\t3. Käy puu läpi esijärjestyksessä.");
            System.out.println("\t\t\t4. Tulosta puu.");
            System.out.println("\t\t\t0. lopetus ");
            System.out.print("\n\n"); // tehdään tyhjiä rivejä
            select = Lue.merkki();
            switch (select) {
                case '1':
                    System.out.println("Anna uusi avain (merkkijono)");
                    data = new String(Lue.rivi());
                    tree.insert(data);
                    break;
                case '2':
                    System.out.println("Anna etsittävä avain (merkkijono)");
                    data = Lue.rivi();
                    if (tree.find(data) != null) {
                        System.out.println("Avain löytyi.");
                    } else
                        System.out.println("Avainta ei löytynyt.");

                    break;
                case '3':
                    tree.preOrder();
                    char h = Lue.merkki(); // pysäytetään kontrolli
                    break;
                case '4':



                    break;
                case '0':
                    break;
            }
        }
        while (select != '0');
    }
//printMenu loppuu ----------------------------------------------------------------
}

