package chainofresponsibility;

public class ManagerAuthority extends Authority {

    private final double ALLOWABLE = 2;

    public void processRequest(RaiserRequest request) {
        if (request.getRaiseAmount() <= ALLOWABLE) {
            System.out.println(
                    "Manager will approve raises up to " + ALLOWABLE + "%");
        } else {
            super.processRequest(request);
        }
    }
}
