package iterator;



public class Main {

    public static void main(String[] args) {

        printMenu();

    }

    //main loppuu --------------------------------------------------------------------------
//printMenu alkaa------------------------------------------------------------------
    private static void printMenu() {
        char select;
        // Stack tietorakenne = new Stack(); // pino-olio
        Queue tietorakenne = new Queue();
        String data; // Pinon data-kenttä
        do {

            System.out.println("\n\t\t\t1. Alkion lisääminen.");
            System.out.println("\t\t\t2. Alkion poistaminen.");
            System.out.println("\t\t\t3. Pinon sisältö.");
            System.out.println("\t\t\t4. Alkioiden lukumäärä.");
            System.out.println("\t\t\t5. lopetus ");
            System.out.print("\n\n"); // tehdään tyhjiä rivejä
            select = Lue.merkki();
            switch (select) {
                case '1':
                    System.out.println("Anna alkion sisältö (merkkijono)");
                    data = Lue.rivi();
                    System.out.println(data);
                    tietorakenne.push(data);
                    break;
                case '2':
                    ListItem item = tietorakenne.pop();
                    if (item == null)
                        System.out.println("Ei alkioita!");
                    else
                        System.out.println("Poistettu alkio: " + item.getData());
                    break;
                case '3':
                    QueueIterator itr = tietorakenne.iterator();
                    while (itr.hasNext())
                        System.out.println(itr.next().getData());
                    break;
                case '4':
                    System.out.println("Lukumäärä = " + tietorakenne.getSize());
                    break;
                case '5':
                    break;
            }
        }
        while (select != '5');
    }
}
