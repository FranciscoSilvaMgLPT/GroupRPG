import FrontEnd.Colors;

import java.util.Scanner;

public class GameManager {
    public void initialMenu() {
        Scanner scan = new Scanner(System.in);
        String choice;
        do {
            RegisterLogin registerLogin = new RegisterLogin();
            System.out.println("Main Menu");
            System.out.println();
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("0. Exit the program");
            System.out.println();
            System.out.print("Enter choice: ");
            choice = scan.next();
            switch (choice) {
                case "1":
                    registerLogin.register();
                    break;
                case "2":
                    registerLogin.login();
                    break;
                case "0":
                    System.out.println("Exit...");
                    break;
                default:
                    System.out.println("Enter a valid option:");
            }
        } while (!choice.equals("0"));
    }

    public void playMenu() {
        Scanner scan = new Scanner(System.in);
        String choice;
        do {
            System.out.println("PLAY Menu");
            System.out.println();
            System.out.println("1. PLAY");
            System.out.println("2. Change your player background");
            System.out.println("0. Exit the program");
            System.out.println();
            System.out.print("Enter choice: ");
            choice = scan.next();
            switch (choice) {
                case "1":
                    play();
                    break;
                case "2":
                    choiceBackground();
                    break;
                case "0":
                    System.out.println("Exit...");
                    break;
                default:
                    System.out.println("Enter a valid option:");
            }
        } while (!choice.equals("0"));
    }

    public void choiceBackground() {
        Scanner scan = new Scanner(System.in);
        User user = new User();
        String choice;
        System.out.println("Background player Menu");
        System.out.println();
        System.out.println("Default Background: " + Colors.BLUE_BACKGROUND_BRIGHT + "◻️" + Colors.RESET);
        System.out.println();
        System.out.println("1. " + Colors.YELLOW_BACKGROUND + "◻️" + Colors.RESET);
        System.out.println("2. " + Colors.CYAN_BACKGROUND + "◻️" + Colors.RESET);
        System.out.println("3. " + Colors.RED_BACKGROUND + "◻️" + Colors.RESET);
        System.out.println("4. " + Colors.GREEN_BACKGROUND + "◻️" + Colors.RESET);
        System.out.println("0. Exit the program");
        System.out.println();
        System.out.print("Enter choice: ");
        choice = scan.next();

        switch (choice) {
            case "1":
                user.setPlayerBackgroundColor(Colors.YELLOW_BACKGROUND + "◻️" + Colors.RESET);
                break;
            case "2":
                user.setPlayerBackgroundColor(Colors.CYAN_BACKGROUND + "◻️" + Colors.RESET);
                break;
            case "3":
                user.setPlayerBackgroundColor(Colors.RED_BACKGROUND+ "◻️" + Colors.RESET);
                break;
            case "4":
                user.setPlayerBackgroundColor(Colors.GREEN_BACKGROUND + "◻️" + Colors.RESET);
                break;
            case "0":
                System.out.println("Exit...");
                break;
            default:
                System.out.println("Enter a valid option:");
        }
        playMenu();
    }

    public static void play() {
        Scanner scan = new Scanner(System.in);
        Map map = new Map();
        User user = new User();
        map.createMap(user);
        map.CreateLimits();

        String playerMove;
        do {
            map.showMap(user);
            System.out.println("Player Menu");
            System.out.println();
            System.out.println("[WASD] - Move");
            System.out.println("\n0. Exit");
            System.out.println();
            System.out.print("Enter choice: ");
            playerMove = scan.next();
            map.checkUserMove(user, playerMove.toUpperCase());
        } while (!playerMove.equals("0"));
    }

}
