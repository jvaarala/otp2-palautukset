package memento;

public class Asiakas extends Thread {

    Object memento;
    Arvuuttaja arvuuttaja;

    public void setOikeinArvattu(boolean oikeinArvattu) {
        this.oikeinArvattu = oikeinArvattu;
    }

    public volatile boolean oikeinArvattu = false;

    public Asiakas(Arvuuttaja a) {
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
