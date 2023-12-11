import java.util.Scanner;

public class GameManager {
    public void gameManager() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            RegisterLogin registerLogin = new RegisterLogin();
            String choice;
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
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter a valid option:");
            }
        }
    }

    public static void showMap() {
        Map map = new Map();
        map.createMap();
        map.CreateLimits();
        map.showMap();
    }

}
