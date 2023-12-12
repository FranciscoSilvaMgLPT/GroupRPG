import FrontEnd.Colors;

import java.util.Scanner;

public class GameManager {
    FileManager fileManager = new FileManager();
    User user = new User();
    Scanner scan = new Scanner(System.in);
    String choice;

    public void initialMenu() {
        do {
            System.out.println("Initial menu");
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
        Map map = new Map();
        map.level1Map(user);
        do {
            map.showMap(user);
            System.out.println("\n" + Colors.WHITE_BRIGHT_UNDERLINED + "KEYS TO MOVE" + Colors.RESET);
            System.out.print(Colors.WHITE_BRIGHT + "W" + Colors.RESET + " - UP | " + Colors.WHITE_BRIGHT + "S" + Colors.RESET + " - DOWN | " + Colors.WHITE_BRIGHT + "A" + Colors.RESET + " - LEFT | " + Colors.WHITE_BRIGHT + "D" + Colors.RESET + " - RIGHT\n");
            System.out.println("\n" + Colors.WHITE_BRIGHT_UNDERLINED + "PLAYER OPTIONS" + Colors.RESET);
            System.out.println(Colors.WHITE_BRIGHT + "0." + Colors.RESET + " Exit");
            System.out.println();
            System.out.print(Colors.WHITE_BOLD_BRIGHT + "=> " + Colors.RESET);
            choice = scan.next();
            map.checkUserMove(user, choice.toUpperCase());
        } while (!choice.equals("0"));
    }

    public void registerUser() {
        System.out.println(Colors.MAGENTA_BOLD+"\n\n📝REGISTER📝"+Colors.RESET);
        System.out.println();
        System.out.print("Username:");
        String username = scan.next();
        if(!fileManager.findUserByName(username)){
            System.out.print("Password:");
            String password= scan.next();
            User newUser = new User(username,password);
            fileManager.saveUserLog(newUser);
        }
    }

    public void loginUser() {
        System.out.println(Colors.MAGENTA_BOLD+"\n\n🔑LOGIN🔑"+Colors.RESET);
        System.out.println();
        System.out.print("Username:");
        String username = scan.next();
        System.out.print("Password:");
        String password = scan.next();
        System.out.println();
        user=fileManager.findUser(username, password);
        if(user!=null){
            playMenu(user);
        }
    }

}
