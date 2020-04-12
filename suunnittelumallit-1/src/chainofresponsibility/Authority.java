package chainofresponsibility;

public abstract class Authority {

    private Authority successor;

    public void setSuccessor(Authority successor) {
        this.successor = successor; }

    public void processRequest(RaiserRequest request){ if (successor != null)
        successor.processRequest(request); }
}
