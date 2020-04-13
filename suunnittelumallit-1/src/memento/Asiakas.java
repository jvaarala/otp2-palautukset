package memento;

public class Asiakas extends Thread {

    private Object memento;
    private Arvuuttaja arvuuttaja;

    void setOikeinArvattu(boolean oikeinArvattu) {
        this.oikeinArvattu = oikeinArvattu;
    }

    volatile boolean oikeinArvattu = false;

    Asiakas(Arvuuttaja a) {
        this.arvuuttaja = a;
    }

    @Override
    public void run() {
        memento = arvuuttaja.liityPeliin(this);
        int arvaus = 1;
        while (!oikeinArvattu) {
            arvuuttaja.arvaa(memento, arvaus);
            arvaus++;
        }
    }


}
