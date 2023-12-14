package ManagerEntities;

import FrontEnd.Colors;
import GameMap.Map;
import Missions.Quiz.Quiz;
import UserManager.User;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

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
            System.out.println("2. Change your player background");
            System.out.println("3. quiz");
            System.out.println("0. Exit the program");
            System.out.println();
            System.out.print("Enter choice: ");
            choice = scan.next();
            switch (choice) {
                case "1":
                    play(user);
                    break;
                case "2":
                    choiceBackground();
                    break;
                case "3":
                    Quiz quiz = new Quiz();
                    long quiz1Level1 = quiz.playQuiz1Level1(user);
                    long quiz2Level1 = quiz.playQuiz2Level1(user);
                    long quiz3Level1 = quiz.playQuiz3Level1(user);
                    long quiz1Level2 = quiz.playQuiz1Level2(user);
                    long quiz2Level2 = quiz.playQuiz2Level2(user);
                    long quiz3Level2 = quiz.playQuiz3Level2(user);

                    long total = quiz1Level1 + quiz2Level1 + quiz3Level1 + quiz1Level2 + quiz2Level2 + quiz3Level2;

                    System.out.println("User points: " + user.getPlayerPoints());
                    System.out.println("User correction answers: " + total);

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
        List<Colors> colorsList = List.of(Colors.BLUE_BACKGROUND_BRIGHT, Colors.YELLOW_BACKGROUND, Colors.CYAN_BACKGROUND, Colors.RED_BACKGROUND, Colors.GREEN_BACKGROUND);
        System.out.println("Background player Menu");
        System.out.println();
        System.out.println("Default Background: " + colorsList.get(0) + "◻️" + Colors.RESET);
        System.out.println();
        IntStream.range(0, colorsList.size() - 1)
                .mapToObj(index -> (index + 1) + ": " + colorsList.get(index + 1) + "◻️" + Colors.RESET)
                .forEach(System.out::println);
        /*for (int i = 1; i < colorsList.size(); i++) {
            System.out.println(i + ": " + colorsList.get(i) + "◻️" + Colors.RESET);
        }*/
        System.out.println("0: Return to menu");
        if (choice.equals("0")) {
            playMenu(user);
        }

        System.out.println();
        System.out.print("Enter choice: ");
        String choice = scan.next();
        user.setPlayerBackgroundColor(colorsList.get(Integer.parseInt(choice)));
        playMenu(user);
    }

    public void play(User user) {
        Map map = new Map();
        map.level1Map(user);
        do {
            if (map.getMap()[user.getY()][user.getX()].isUser() && map.getMap()[user.getY()][user.getX()].isFinish()) {
                map.showMap(user);
                System.out.println("PARABENS! ENTER ANY KEY TO CONTINUE TO LEVEL 2");
                map.level2Map(user);
                choice = scan.next();
            } else {
                map.showMap(user);
                System.out.println("\n" + Colors.WHITE_BRIGHT_UNDERLINED + "KEYS TO MOVE" + Colors.RESET);
                System.out.print(Colors.WHITE_BRIGHT + "W" + Colors.RESET + " - UP | " + Colors.WHITE_BRIGHT + "S" + Colors.RESET + " - DOWN | " + Colors.WHITE_BRIGHT + "A" + Colors.RESET + " - LEFT | " + Colors.WHITE_BRIGHT + "D" + Colors.RESET + " - RIGHT\n");
                System.out.println("\n" + Colors.WHITE_BRIGHT_UNDERLINED + "PLAYER OPTIONS" + Colors.RESET);
                System.out.println(Colors.WHITE_BRIGHT + "0." + Colors.RESET + " Exit");
                System.out.println();
                System.out.print(Colors.WHITE_BOLD_BRIGHT + "=> " + Colors.RESET);
                choice = scan.next();
                map.checkUserMove(user, choice.toUpperCase());
            }
        } while (!choice.equals("0"));
    }

    public void registerUser() {
        System.out.println(Colors.MAGENTA_BOLD + "\n\n📝REGISTER📝" + Colors.RESET);
        System.out.println();
        System.out.print("Username:");
        String username = scan.next();
        if (!fileManager.isUsernameTaken(username)) {
            System.out.print("Password:");
            String password = scan.next();
            User newUser = new User(username, password);
            fileManager.saveUserLog(newUser);
        }
    }

    public void loginUser() {
        System.out.println(Colors.MAGENTA_BOLD + "\n\n🔑LOGIN🔑" + Colors.RESET);
        System.out.println();
        System.out.print("Username:");
        String username = scan.next();
        System.out.print("Password:");
        String password = scan.next();
        System.out.println();
        user = fileManager.findUser(username, password);
        if (user != null) {
            playMenu(user);
        }
    }

}
