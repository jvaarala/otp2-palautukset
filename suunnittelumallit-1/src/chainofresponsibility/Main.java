package chainofresponsibility;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        ManagerAuthority manager = new ManagerAuthority();
        DirectorAuthority director = new DirectorAuthority();
        CeoAuthority ceo = new CeoAuthority();

        manager.setSuccessor(director);
        director.setSuccessor(ceo);

        try {
            while (true) {
                System.out.println("Enter the amount to check who should approve your raise.");
                System.out.print(">");
                double d = Double.parseDouble(new BufferedReader(new InputStreamReader(System.in)).readLine());
                manager.processRequest(new RaiserRequest(d)); }
        } catch(Exception e) {
            System.exit(1); }
    }
}
