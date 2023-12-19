package Missions.RockPaperScissor;

import FrontEnd.Colors;

import java.util.Scanner;

public class RockPaperScissor {
    private String player;
    private String cpu;
    private String playerResponse = "";
    private String cpuResponse = "";

    public int rockPaperScissorMission() {
        Scanner scan = new Scanner(System.in);
        System.out.println(Colors.CYAN_BOLD_BRIGHT + "0 - Rock");
        System.out.println("1 - Paper");
        System.out.println("2 - Scissors" + Colors.RESET);
        System.out.print(Colors.WHITE_BOLD_BRIGHT + "=> " + Colors.RESET);
        player = scan.next();

        cpu = String.valueOf((int) (Math.random() * 3));

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

                System.out.println(Colors.RED_BOLD_BRIGHT + "\nInvalid number. Please try again.\n" + Colors.RESET);
                return rockPaperScissorMission();

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
                break;
        }
        return checkWhoWon();
    }

    private int checkWhoWon() {
        String outcomeString = Colors.MAGENTA + "\nThe computer picked " + cpuResponse + " You picked " + playerResponse + Colors.RESET;
        String outcomeLose = outcomeString + Colors.RED_BRIGHT + " You lose!" + Colors.RESET;
        String outcomeWon = outcomeString + Colors.GREEN_BRIGHT + " You won!" + Colors.RESET;
        String outcomeDraw = outcomeString + Colors.YELLOW_BRIGHT + "too. It's a Draw!!" + Colors.RESET;
        if ((playerResponse.equals("✌\uFE0F") && cpuResponse.equals("✊")) ||
                (playerResponse.equals("✋") && cpuResponse.equals("✌\uFE0F")) ||
                (playerResponse.equals("✊") && cpuResponse.equals("✋"))) {
            System.out.println(outcomeLose);
            return 0;
        } else if ((playerResponse.equals("✌\uFE0F") && cpuResponse.equals("paper")) ||
                (playerResponse.equals("✋") && cpuResponse.equals("✊")) ||
                (playerResponse.equals("✊") && cpuResponse.equals("✌\uFE0F"))) {
            System.out.println(outcomeWon);
            return 2;
        } else {
            System.out.println(outcomeDraw);
            return 1;
        }
    }
}


