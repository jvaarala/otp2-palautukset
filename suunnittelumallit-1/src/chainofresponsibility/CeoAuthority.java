package chainofresponsibility;

public class CeoAuthority extends Authority{

    public void processRequest(RaiserRequest request) {
        System.out.println("CEO will approve raises above 5%.");
    }
}
