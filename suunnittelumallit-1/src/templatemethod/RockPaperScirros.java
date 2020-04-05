package templatemethod;

import java.util.ArrayList;


public class RockPaperScirros extends Game {

    boolean gameFinished;
    int winner;
    ArrayList <String> playerChoices;
    @Override
    void initializeGame() {
        gameFinished = false;
        winner = -1;
        playerChoices = new ArrayList<>();
    }

    @Override
    void makePlay(int player) {
        System.out.println("Pick your choice player " + player + "!");
        char select;
        System.out.println("\n\t\t\t1. Rock");
        System.out.println("\t\t\t2. Paper");
        System.out.println("\t\t\t3. Scissors");
        System.out.println("\t\t\t0. Exit ");
        System.out.print("\n\n");
        select = Lue.merkki();
        switch (select) {
            case '1':
                playerChoices.add(player, "Rock");
                break;
            case '2':
                playerChoices.add(player, "Paper");
                break;
            case '3':
                playerChoices.add(player, "Scissors");
                break;
            case '0':
                gameFinished = true;
                break;
        }
        if (!gameFinished) {
            if (player == this.playersCount-1) {
                System.out.println("Both players have chosen");
                System.out.println(playerChoices.toString());

                winner = 0;
                String besthand = playerChoices.get(0);
                for (int i = 1; i < playersCount; i++){
                    if (playerChoices.get(i).contentEquals(besthand)) {
                        winner = -1;
                    } else if (besthand.contentEquals(getLosingHand(playerChoices.get(i)))) {
                        winner = i;
                    }
                }
                gameFinished = true;
                playerChoices.clear();
            }
        }

    }

    @Override
    boolean endOfGame() {
        return gameFinished;
    }

    @Override
    void printWinner() {
        if (winner == -1) {
            System.out.println("No winner this time..");
        } else {
            System.out.println("Winner is player " + winner + "!");
        }
    }

    public String getLosingHand(String winningHand) {
        switch (winningHand) {
            case "Rock":
                return "Scissors";
            case "Paper":
                return "Rock";
            case "Scissors":
                return "Paper";
            default:
                return null;
        }
    }

}
