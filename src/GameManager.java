import FrontEnd.Colors;

import java.util.Scanner;

public class GameManager {
    FileManager fileManager = new FileManager();
    User user = new User();
    Scanner scan = new Scanner(System.in);
    String choice;

    public void initialMenu() {
        do {
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
                    registerUser();
                    break;
                case "2":
                    loginUser();
                    break;
                case "0":
                    System.out.println("Exit...");
                    break;
                default:
                    System.out.println("Enter a valid option:");
            }
        } while (!choice.equals("0"));
    }

    public void playMenu(User user) {
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
                    play(user);
                    break;
                case "0":
                    System.out.println("Exit...");
                    break;
                default:
                    System.out.println("Enter a valid option:");
            }
        } while (!choice.equals("0"));
    }

    public void play(User user) {
        Map map = new Map(15, 30);
        map.createMap(user);
        map.CreateLimits();
        do {
            map.showMap(user);
            System.out.println("Player Menu");
            System.out.println();
            System.out.println("[WASD] - Move");
            System.out.println("\n0. Exit");
            System.out.println();
            System.out.print("Enter choice: ");
            choice = scan.next();
            map.checkUserMove(user, choice.toUpperCase());
        } while (!choice.equals("0"));
    }

    public void registerUser() {
        System.out.println(Colors.MAGENTA_BOLD+"\n\n📝REGISTER📝"+Colors.RESET);
        System.out.println();
        System.out.print("Username:");
        user.setPlayerName(scan.next());
        System.out.print("Password:");
        user.setPlayerPassword(scan.next());
        fileManager.saveUserLog(user);
    }

    public void loginUser() {
        System.out.println(Colors.MAGENTA_BOLD+"\n\n🔑LOGIN🔑"+Colors.RESET);
        System.out.println();
        System.out.print("Username:");
        String username = scan.next();
        System.out.print("Password:");
        String password = scan.next();
        System.out.println();
        if(fileManager.findUser(username, password)){
            user =new User(username,password);
            playMenu(user);
        }
    }

}
