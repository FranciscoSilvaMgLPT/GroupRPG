package ManagerEntities;

import FrontEnd.Colors;
import GameMap.Map;
import Missions.Quiz.Quiz;
import Missions.RockPaperScissor.RockPaperScissor;
import UserManager.User;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class GameManager {
    FileManager fileManager = new FileManager();
    Quiz quiz = new Quiz();
    User user = new User();
    Scanner scan = new Scanner(System.in);
    String choice;
    RockPaperScissor rockPaperScissor = new RockPaperScissor();

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
            System.out.println("3. Cheats");
            System.out.println("4. Ranking");
            System.out.println("5. Save");
            System.out.println("0. Exit the program");
            System.out.println();
            System.out.print("Enter choice: ");
            choice = scan.next();
            switch (choice) {
                case "1":
                    play(user);
                    break;
                case "2":
                    choiceBackground(user);
                    break;
                case "3":
                    cheats(user);
                    break;
                case "4":

                    break;
                case "5":
                    fileManager.updateUser(user);
                case "0":
                    System.out.println("Exit...");
                    break;
                default:
                    System.out.println("Enter a valid option:");
            }
        } while (!choice.equals("0"));
    }

    public void choiceBackground(User user) {
        Scanner scan = new Scanner(System.in);
        List<Colors> colorsList = List.of(Colors.BLUE_BACKGROUND_BRIGHT, Colors.YELLOW_BACKGROUND, Colors.CYAN_BACKGROUND, Colors.RED_BACKGROUND, Colors.GREEN_BACKGROUND);
        System.out.println("Background player Menu");
        System.out.println();
        System.out.println("Current Background: " + user.getPlayerBackgroundColor() + "◻️" + Colors.RESET);
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
        GameManager gameManager = new GameManager();
        map.level1Map(user);
        do {
            if (map.getMap()[user.getY()][user.getX()].isUser() && map.getMap()[user.getY()][user.getX()].isNextFloor()) {
                map.showMap(user);
                System.out.println("PARABENS! ENTER ANY KEY TO CONTINUE TO LEVEL 2");
                map.level2Map(user);
                choice = scan.next();
            }
            if (map.getMap()[user.getY()][user.getX()].isUser() && map.getMap()[user.getY()][user.getX()].isMission()) {
                if (map.getMap()[user.getY()][user.getX()].isCompleted()) {
                    try {
                        System.out.println("QUIZZ ALREADY COMPLETED!");
                        Thread.sleep(500);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    map.showMap(user);
                    if(map.getMap()[user.getY()][user.getX()].getMissionQuizz()==1) {
                        quiz.playQuiz1Level1(user);
                    }
                    if(map.getMap()[user.getY()][user.getX()].getMissionQuizz()==2) {
                        quiz.playQuiz2Level1(user);
                    }
                    if(map.getMap()[user.getY()][user.getX()].getMissionQuizz()==3) {
                        quiz.playQuiz3Level1(user);
                    }
                    if(map.getMap()[user.getY()][user.getX()].getMissionQuizz()==4) {
                        quiz.playQuiz1Level2(user);
                    }
                    if(map.getMap()[user.getY()][user.getX()].getMissionQuizz()==5) {
                        quiz.playQuiz2Level2(user);
                    }
                    if(map.getMap()[user.getY()][user.getX()].getMissionQuizz()==6) {
                        quiz.playQuiz3Level2(user);
                    }
                    map.getMap()[user.getY()][user.getX()].setCompleted(true);
                    user.setPlayerGifts(user.getPlayerGifts()+1);
                }
            }
            map.showMap(user);
            System.out.println("\n" + Colors.WHITE_BRIGHT_UNDERLINED + "KEYS TO MOVE" + Colors.RESET);
            System.out.print(Colors.WHITE_BRIGHT + "W" + Colors.RESET + " - UP | " + Colors.WHITE_BRIGHT + "S" + Colors.RESET + " - DOWN | " + Colors.WHITE_BRIGHT + "A" + Colors.RESET + " - LEFT | " + Colors.WHITE_BRIGHT + "D" + Colors.RESET + " - RIGHT\n");
            System.out.println("\n" + Colors.WHITE_BRIGHT_UNDERLINED + "PLAYER OPTIONS" + Colors.RESET);
            System.out.println(Colors.WHITE_BRIGHT + "0." + Colors.RESET + " Exit");
            System.out.println();
            System.out.print(Colors.WHITE_BOLD_BRIGHT + "=> " + Colors.RESET);
            choice = scan.next();
            map.checkUserMove(user, choice.toUpperCase());
            if (map.getMap()[user.getY()][user.getX()].isUser() && map.getMap()[user.getY()][user.getX()].isFinish()) {
                int playRockTime=0;
                while (playRockTime<3) {
                    user.setPlayerPoints(user.getPlayerPoints()+rockPaperScissor.rockPaperScissorMission());
                    playRockTime++;
                }
                System.out.println("CONGRATZZZZZ!!! YOU REACHED THE CHRISTMAS TREE!"
                        +(user.getPlayerGifts()==0?" BUT SADLY YOU GATHER 0 GIFTS! 😫":"WELL DONE! YOU BROUGHT "+user.getPlayerGifts()+" GIFTS! 🥳🎁"));
                System.out.println("POINTS:"+user.getPlayerPoints());
                try {
                    Thread.sleep(500);
                    gameManager.playMenu(user);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
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

    public void cheats(User user) {
        try {
            if (!(user.getCheats() % 3 == 0)) {
                System.out.println(Colors.RED + "CHEATS DON'T EXIST IN THIS GAME! 😡" + Colors.RESET);
            } else {
                user.setPlayerPoints(user.getPlayerPoints() + 10);
                System.out.println(Colors.BLUE + "Alright! I give up! 10 points for you! 😘" + Colors.RESET);
            }
            user.setCheats(user.getCheats()+1);
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
