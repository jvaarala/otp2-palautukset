package state;

public class Main {
    public static void main(String[] args) {
        Pokemon pokemon = new Pokemon();
        ExperienceVisitor experienceVisitor = new ExperienceVisitor();

        pokemon.attack();
        pokemon.bonus(experienceVisitor);
        pokemon.evolve();
        pokemon.attack();
        pokemon.bonus(experienceVisitor);
        pokemon.evolve();
        pokemon.attack();
        pokemon.bonus(experienceVisitor);
    }
}
