package state;

public class ExperienceVisitor {
    public void visit(Charmander charmander) {
        System.out.println("Charmander gained 30xp");
    }

    public void visit(Charmaleon charmaleon) {
        System.out.println("Charmander gained 20xp");
    }

    public void visit(Charizard charizard) {
        System.out.println("Charmander gained 10xp");
    }
}
