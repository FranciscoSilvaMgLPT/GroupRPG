import FrontEnd.Colors;

import java.util.Scanner;

public class RockPaperScissor {
    private int SCISSOR_VALUE = 0;
    private int ROCK_VALUE = 1;
    private int PAPER_VALUE = 2;
    private String player;
    private String cpu;
    private String playerResponse = "";
    private String cpuResponse = "";

    public void rockPaperScissorMission() {
        Scanner scan = new Scanner(System.in);
        System.out.println(Colors.CYAN_BOLD_BRIGHT + "0 - Rock");
        System.out.println("1 - Paper");
        System.out.println("2 - Scissors" + Colors.RESET);

        player = scan.next(); // Use int for player input

        cpu = String.valueOf((int) (Math.random() * 3)); // Use int for CPU response

        switch (player) {
            case "0":
                playerResponse = "✊";
                break;
            case "1":
                playerResponse = "✋";
                break;
            case "2":
                playerResponse = "✌\uFE0F";
                break;
            default:
                // Handle invalid input if needed
                System.out.println("Invalid number. Please try again.");
                return;
        }

        switch (cpu) {
            case "0":
                cpuResponse = "✊";
                break;
            case "1":
                cpuResponse = "✋";
                break;
            case "2":
                cpuResponse = "✌\uFE0F";
                break;
            default:
                // Handle unexpected CPU response if needed
                break;
        }
        checkWhoWon();
    }

    private void checkWhoWon() {
        String outcomeString = Colors.MAGENTA + "\nThe computer picked " + cpuResponse + ". You picked " + playerResponse + Colors.RESET;
        String outcomeLose = outcomeString + Colors.RED_BRIGHT + ". You lose!" + Colors.RESET;
        String outcomeWon = outcomeString + Colors.GREEN_BRIGHT + ". You won!" + Colors.RESET;
        String outcomeDraw = outcomeString + Colors.YELLOW_BRIGHT + "too. It's a Draw!!" + Colors.RESET;
        // Use equals to compare strings, not ==
        if ((playerResponse.equals("✌\uFE0F") && cpuResponse.equals("✊")) ||
                (playerResponse.equals("✋") && cpuResponse.equals("✌\uFE0F")) ||
                (playerResponse.equals("✊") && cpuResponse.equals("✋"))) {
            System.out.println(outcomeLose);
        } else if ((playerResponse.equals("✌\uFE0F") && cpuResponse.equals("paper")) ||
                (playerResponse.equals("✋") && cpuResponse.equals("✊")) ||
                (playerResponse.equals("✊") && cpuResponse.equals("✌\uFE0F"))) {
            // Player won
            System.out.println(outcomeWon);
        } else {
            // Both players entered the same response, so it's a draw
            System.out.println(outcomeDraw);
        }
    }
}

