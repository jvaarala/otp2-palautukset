package chainofresponsibility;

public class DirectorAuthority extends Authority {

    private final double ALLOWABLE = 5;

    public void processRequest(RaiserRequest request) {
        if (request.getRaiseAmount() < ALLOWABLE) {
            System.out.println(
                    "Director will approve raises up to " + ALLOWABLE + "%");
        } else {
            super.processRequest(request);
        }
    }
}
