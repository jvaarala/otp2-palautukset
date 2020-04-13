package memento;

public class Main {
    public static void main(String[] args) {

        Arvuuttaja r = new Arvuuttaja();
        for (int i = 0; i < 10; i++) {
            Asiakas asiakas = new Asiakas(r);
            asiakas.start();
        }
    }
}
