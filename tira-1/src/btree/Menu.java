package btree;

/**
 * @author kamaj / jessevaa
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
        tree.insert("b");
        tree.insert("a");
        tree.insert("c");
        tree.insert("f");
        tree.insert("e");
        tree.insert("h");
        tree.insert("g");

        String data;
        do {

            System.out.println("\n\t\t\t1. Lisää avain.");
            System.out.println("\t\t\t2. Etsi avaimella.");
            System.out.println("\t\t\t3. Käy puu läpi sisäjärjestyksessä.");
            System.out.println("\t\t\t4. Poista avain.");
            System.out.println("\t\t\t5. Etsi pienin avain.");
            System.out.println("\t\t\t0. lopetus ");
            System.out.print("\n\n"); // tehdään tyhjiä rivejä
            select = Lue.merkki();
            switch (select) {
                case '1':
                    System.out.println("Anna uusi avain (merkkijono)");
                    data = Lue.rivi();
                    tree.insert(data);
                    break;
                case '2':
                    System.out.println("Anna etsittävä avain (merkkijono)");
                    data = Lue.rivi();
                    System.out.println("Aloitetaan etsintä:");
                    if (tree.find(data) != null) {
                        System.out.println("\nAvain löytyi.");
                    } else
                        System.out.println("\nAvainta ei löytynyt.");

                    break;
                case '3':
                    tree.inOrder();
                    char h = Lue.merkki(); // pysäytetään kontrolli
                    break;
                case '4':
                    System.out.println("Anna poistettava avain (merkkijono)");
                    data = Lue.rivi();
                    if (tree.deleteNode(tree, data) != null) {
                        System.out.println("\nAvain poistettu.");
                    }
                    break;
                case '5':
                    System.out.println("Etsitään pienin avain.");
                    tree.getSmallest(tree);
                    break;
                case '0':
                    break;
            }
        }
        while (select != '0');
    }
//printMenu loppuu ----------------------------------------------------------------
}

