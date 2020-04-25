package jcapi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * @author kamaj / jessevaa
 */
public class UsingJCAPI {
    private static TrafficCard.TravellerNumberComparator travellerNumberComparator = new TrafficCard.TravellerNumberComparator();
    private static TrafficCard.BalanceComparator balanceComparator = new TrafficCard.BalanceComparator();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<TrafficCard> cardUsers = new ArrayList<TrafficCard>();
        RandomString rString = new RandomString(10);
        float genBalance;
        TrafficCard myCard;
        Random r = new Random();
        int i;
        for (i = 0; i < 10; i++) {
            genBalance = ((float) r.nextInt(1000) / 10);
            myCard = new TrafficCard(r.nextInt(100), rString.nextString(), genBalance);
            cardUsers.add(myCard);
        }

        System.out.println("Tulostetaan alkuperäisessä järjestyksessä: ");
        printWithIterator(cardUsers);


//        System.out.println("\nJärjestetään matkustajan numeron mukaan käyttämällä Comparatoria\n" + travellerNumberComparator + "\n");
//        cardUsers.sort(travellerNumberComparator);
//        printWithIterator(cardUsers);

        System.out.println("\nJärjestetään matkustajan numeron mukaan käyttämällä Lambda-lauseketta\n");
        cardUsers.sort((TrafficCard o1, TrafficCard o2) -> Float.compare(o1.mTravellerNumber, o2.mTravellerNumber));
        printWithIterator(cardUsers);

        System.out.println("\nJärjestetään tilin balanssin mukaan käyttämällä Comparatoria\n" + balanceComparator + "\n");
        cardUsers.sort(balanceComparator);
        printWithIterator(cardUsers);

        System.out.println("\nSuurin balanssi:\n" + maxBalance(cardUsers));
    }

    private static TrafficCard maxBalance(ArrayList<TrafficCard> cards) {
        ArrayList<TrafficCard> cardsCopy = cards;
        cardsCopy.sort(balanceComparator);
        return cardsCopy.get(0);
    }

    private static void printWithIterator(ArrayList<TrafficCard> cardUsers) {
        Iterator itr = cardUsers.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
