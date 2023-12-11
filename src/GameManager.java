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
        Map map = new Map();
        map.createMap();
        map.CreateLimits();
        map.showMap();
    }

}
