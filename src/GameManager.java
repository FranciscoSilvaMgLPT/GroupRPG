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
        } while(!choice.equals("0"));
    }

    public void playMenu() {
        Scanner scan = new Scanner(System.in);
        String choice;
        do {
            System.out.println("PLAY Menu");
            System.out.println();
            System.out.println("1. PLAY");
            System.out.println("0. Exit the program");
            System.out.println();
            System.out.print("Enter choice: ");
            choice = scan.next();
            switch (choice) {
                case "1":
                    play();
                    break;
                case "0":
                    System.out.println("Exit...");
                    break;
                default:
                    System.out.println("Enter a valid option:");
            }
        } while(!choice.equals("0"));
    }

    public static void play() {
        Scanner scan = new Scanner(System.in);
        Map map = new Map();
        User user = new User();
        map.createMap();
        map.CreateLimits();
        map.showMap();

        String playerMove;
        do {
            map.updateMap();
            System.out.println("Player Menu");
            System.out.println();
            System.out.println("[WASD] - Move");
            System.out.println("\n0. Exit");
            System.out.println();
            System.out.print("Enter choice: ");
            playerMove = scan.next();
            user.move(playerMove.toUpperCase());
        } while(!playerMove.equals("0"));
    }

}
