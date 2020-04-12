package chainofresponsibility;

public class RaiserRequest {

    private double raiseAmount;

    public RaiserRequest (double raiseAmount) {
        this.raiseAmount = raiseAmount;
    }

    public double getRaiseAmount() {
        return raiseAmount;
    }

    public void setRaiseAmount(double raiseAmount) {
        this.raiseAmount = raiseAmount;
    }
}
