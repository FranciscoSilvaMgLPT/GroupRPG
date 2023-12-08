import java.util.Scanner;

public class Menus {
    Scanner scan = new Scanner(System.in);


    public String menuRegisterLogin() {
        RegisterLogin registerLogin = new RegisterLogin();
            String choice;
            System.out.println("Main Menu");
            System.out.println();
            System.out.println("0. Exit the program");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println();
            System.out.print("Enter choice: ");
            choice = scan.next();

            switch (choice) {

                case "0":
                    System.out.println("Exit...");
                    System.exit(0);
                    break;
                case "1":
                    registerLogin.register();
                    break;
                case "2":
                    registerLogin.login();
                    break;
                default:
                    System.out.println("Enter a valid option:");
            }
        return choice;
    }

    }

