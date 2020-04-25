package jcapi;

import java.util.Comparator;

/**
 * @author kamaj / jessevaa
 */
public class TrafficCard {
    int mTravellerNumber;
    String mOwnerName;
    float mBalance;

    TrafficCard(int tNumber, String oName, float balance) {
        mTravellerNumber = tNumber;
        mOwnerName = oName;
        mBalance = balance;
    }

    static class TravellerNumberComparator implements Comparator<TrafficCard> {
        @Override
        public int compare(TrafficCard o1, TrafficCard o2) {
            return o1.mTravellerNumber - o2.mTravellerNumber;
        }
    }

    static class BalanceComparator implements Comparator<TrafficCard> {
        @Override
        public int compare(TrafficCard o1, TrafficCard o2) {
            return Float.compare(o1.mBalance, o2.mBalance);
        }
    }

    @Override
    public String toString() {
        return "owner: " + mOwnerName + " number: " + mTravellerNumber + " balance: " + mBalance;
    }
}
