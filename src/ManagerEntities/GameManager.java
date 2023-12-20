package ManagerEntities;

import FrontEnd.Colors;
import GameMap.Map;
import Missions.Quiz.Quiz;
import Missions.RockPaperScissor.RockPaperScissor;
import UserManager.User;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameManager {
    FileManager fileManager = new FileManager();
    Quiz quiz = new Quiz();
    Scanner scan = new Scanner(System.in);
    String choice;
    RockPaperScissor rockPaperScissor = new RockPaperScissor();

    List<User> userList = fileManager.readDatabase();
    ;

    public void initialMenu() {
        do {
            System.out.println(Colors.WHITE_BOLD_BRIGHT + "INITIAL MENU");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("0. Exit the program");
            System.out.print(Colors.WHITE_BOLD_BRIGHT + "=> " + Colors.RESET);
            choice = scan.next();
            switch (choice) {
                case "1":
                    registerUser();
                    break;
                case "2":
                    loginUser();
                    break;
                case "0":
                    System.out.println(Colors.YELLOW_BRIGHT + "\nExiting...\n" + Colors.RESET);
                    System.exit(0);
                    break;
                default:
                    System.out.println(Colors.RED_BOLD_BRIGHT + "\nInvalid option!\n" + Colors.RESET);
            }
        } while (!choice.equals("0"));
    }

    public void playMenu(User user) {
        do {
            fileManager.writeDatabase(userList, user);
            System.out.println(Colors.WHITE_BOLD_BRIGHT + "PLAY Menu");
            System.out.println("1. PLAY");
            System.out.println("2. Change your player background");
            System.out.println("3. Cheats");
            System.out.println("4. Ranking");
            System.out.println("5. Save");
            System.out.println("0. Logout");
            System.out.print(Colors.WHITE_BOLD_BRIGHT + "=> " + Colors.RESET);
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
                    ranking(user);
                    break;
                case "5":
                    fileManager.writeDatabase(userList, user);
                    break;
                case "0":
                    System.out.println(Colors.YELLOW_BRIGHT + "\nLogging out\n" + Colors.RESET);
                    fileManager.writeDatabase(userList, user);
                    initialMenu();
                    break;
                default:
                    System.out.println(Colors.RED_BOLD_BRIGHT + "\nInvalid option!\n" + Colors.RESET);
            }
        } while (!choice.equals("0"));
    }

    public void choiceBackground(User user) {
        Scanner scan = new Scanner(System.in);
        List<Colors> colorsList = List.of(Colors.BLUE_BACKGROUND_BRIGHT, Colors.YELLOW_BACKGROUND, Colors.CYAN_BACKGROUND, Colors.RED_BACKGROUND, Colors.GREEN_BACKGROUND);
        System.out.println("\nCHOOSE A NEW BACKGROUND COLOR\n");
        System.out.println(Colors.WHITE_BOLD_BRIGHT + "CURRENT BACKGROUND: " + Colors.RESET + user.getPlayerBackgroundColor() + "◻️" + Colors.RESET + "\n");
        IntStream.range(0, colorsList.size() - 1)
                .mapToObj(index -> Colors.WHITE_BOLD_BRIGHT + "" + (index + 1) + ": " + Colors.RESET + colorsList.get(index + 1) + "◻️" + Colors.RESET)
                .forEach(System.out::println);
        System.out.println(Colors.WHITE_BOLD_BRIGHT + "0: " + Colors.RESET + "RETURN TO MENU");
        if (choice.equals("0")) {
            playMenu(user);
        }

        System.out.println();
        System.out.print(Colors.WHITE_BOLD_BRIGHT + "=> " + Colors.RESET);
        String choice = scan.next();
        user.setPlayerBackgroundColor(colorsList.get(Integer.parseInt(choice)));
        playMenu(user);
    }

    public void play(User user) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        startGameNarrative();
        Map map = new Map();
        GameManager gameManager = new GameManager();
        map.level1Map(user);
        do {
            if (map.getMap()[user.getY()][user.getX()].isUser() && map.getMap()[user.getY()][user.getX()].isNextFloor()) {
                map.showMap(user);
                System.out.println(Colors.YELLOW_BOLD_BRIGHT + "ENTER ANY KEY TO CONTINUE TO LEVEL 2" + Colors.RESET);
                map.level2Map(user);
                choice = scan.next();
            }
            if (map.getMap()[user.getY()][user.getX()].isUser() && map.getMap()[user.getY()][user.getX()].isMission()) {
                if (map.getMap()[user.getY()][user.getX()].isCompleted()) {
                    try {
                        System.out.println(Colors.RED_BOLD_BRIGHT + "\nTHAT MISSION IS ALREADY COMPLETED!\n" + Colors.RESET);
                        Thread.sleep(1000);
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    user.setPlayerPoints(user.getPlayerPoints()+5);
                    System.out.println("+5 POINTS!");
                    map.showMap(user);
                    if (map.getMap()[user.getY()][user.getX()].getMissionQuizz() == 1) {
                        quiz.playQuiz1Level1(user);
                    }
                    if (map.getMap()[user.getY()][user.getX()].getMissionQuizz() == 2) {
                        quiz.playQuiz2Level1(user);
                    }
                    if (map.getMap()[user.getY()][user.getX()].getMissionQuizz() == 3) {
                        quiz.playQuiz3Level1(user);
                    }
                    if (map.getMap()[user.getY()][user.getX()].getMissionQuizz() == 4) {
                        quiz.playQuiz1Level2(user);
                    }
                    if (map.getMap()[user.getY()][user.getX()].getMissionQuizz() == 5) {
                        quiz.playQuiz2Level2(user);
                    }
                    if (map.getMap()[user.getY()][user.getX()].getMissionQuizz() == 6) {
                        quiz.playQuiz3Level2(user);
                    }
                    map.getMap()[user.getY()][user.getX()].setCompleted(true);
                    user.setPlayerGifts(user.getPlayerGifts() + 1);
                }
            }
            map.showMap(user);
            System.out.println(Colors.YELLOW_BOLD_BRIGHT + "CURRENT POINTS: " + user.getPlayerPoints() + Colors.RESET);
            System.out.println("\n" + Colors.WHITE_BRIGHT_UNDERLINED + "KEYS TO MOVE" + Colors.RESET);
            System.out.print(Colors.WHITE_BRIGHT + "W" + Colors.RESET + " - UP | " + Colors.WHITE_BRIGHT + "S" + Colors.RESET + " - DOWN | " + Colors.WHITE_BRIGHT + "A" + Colors.RESET + " - LEFT | " + Colors.WHITE_BRIGHT + "D" + Colors.RESET + " - RIGHT\n");
            System.out.println("\n" + Colors.WHITE_BRIGHT_UNDERLINED + "PLAYER OPTIONS" + Colors.RESET);
            System.out.println(Colors.WHITE_BRIGHT + "0." + Colors.RESET + " Exit");
            System.out.println();
            System.out.print(Colors.WHITE_BOLD_BRIGHT + "=> " + Colors.RESET);
            choice = scan.next();
            if (!choice.equals("0")) {
                map.checkUserMove(user, choice.toUpperCase());
                if (map.getMap()[user.getY()][user.getX()].isUser() && map.getMap()[user.getY()][user.getX()].isFinish()) {
                    System.out.println(Colors.YELLOW_BOLD_BRIGHT + "\nYOU NOW HAVE A CHANCE TO MAKE MORE POINTS!" + Colors.WHITE_BOLD_BRIGHT + "\nWIN -> " + Colors.GREEN_BOLD_BRIGHT + " 2 POINTS " + Colors.WHITE_BOLD_BRIGHT + "\nDRAW -> " + Colors.GREEN_BOLD_BRIGHT + " 1 POINT " + Colors.YELLOW_BOLD_BRIGHT + "\nYOU HAVE 3 CHANCES, READY? GO!\n" + Colors.RESET);
                    System.out.println(Colors.YELLOW_BOLD_BRIGHT + "CHOOSE YOUR GUN!" + Colors.RESET);
                    int playRockTime = 0;
                    while (playRockTime < 3) {
                        user.setPlayerPoints(user.getPlayerPoints() + rockPaperScissor.rockPaperScissorMission());
                        playRockTime++;
                    }
                    System.out.println(Colors.GREEN_BOLD_BRIGHT + "\nCONGRATZZZZZ!!! YOU REACHED THE CHRISTMAS TREE!"
                            + (user.getPlayerGifts() == 0 ? " " + Colors.RED_BOLD_BRIGHT + "BUT SADLY YOU GATHER 0 GIFTS! 😫" + Colors.RESET : " WELL DONE! YOU BROUGHT " + user.getPlayerGifts() + " GIFTS! 🥳🎁" + Colors.RESET));
                    System.out.println(Colors.WHITE_BOLD_BRIGHT + "YOU MADE " + user.getPlayerPoints() + " POINTS\n" + Colors.RESET);
                    try {
                        Thread.sleep(2000);
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        endGameNarrative(user);
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        gameManager.playMenu(user);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        } while (!choice.equals("0"));
        playMenu(user);
    }

    public void registerUser() {
        System.out.println(Colors.MAGENTA_BOLD + "\n\n📝REGISTER📝" + Colors.RESET);
        System.out.println();
        System.out.println(Colors.WHITE_BOLD_BRIGHT + "USERNAME" + Colors.RESET);
        System.out.print(Colors.WHITE_BOLD_BRIGHT + "=> " + Colors.RESET);
        String username = scan.next();
        if (!fileManager.isUsernameTaken(username)) {
            System.out.println(Colors.WHITE_BOLD_BRIGHT + "PASSWORD" + Colors.RESET);
            System.out.print(Colors.WHITE_BOLD_BRIGHT + "=> " + Colors.RESET);
            String password = scan.next();
            userList.add(new User(username, password));
            fileManager.writeDatabase(userList);
        } else {
            System.out.println(Colors.RED_BOLD_BRIGHT + "THAT USERNAME IS ALREADY TAKEAN!" + Colors.RESET);
        }
    }

    public void loginUser() {
        System.out.println(Colors.MAGENTA_BOLD + "\n\n🔑LOGIN🔑" + Colors.RESET);
        System.out.println();
        System.out.println(Colors.WHITE_BOLD_BRIGHT + "USERNAME" + Colors.RESET);
        System.out.print(Colors.WHITE_BOLD_BRIGHT + "=> " + Colors.RESET);
        String username = scan.next();
        System.out.println(Colors.WHITE_BOLD_BRIGHT + "\nPASSWORD" + Colors.RESET);
        System.out.print(Colors.WHITE_BOLD_BRIGHT + "=> " + Colors.RESET);
        String password = scan.next();
        System.out.println();
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getPlayerName().equals(username) && userList.get(i).getPlayerPassword().equals(password)) {
                playMenu(userList.get(i));
            }
        }
        System.out.println("USER NOT FOUND");

    }

    public void cheats(User user) {
        try {
            if (!(user.getCheats() % 3 == 0)) {
                System.out.println(Colors.RED_BOLD_BRIGHT + "\nCHEATS DON'T EXIST IN THIS GAME! 😡\n" + Colors.RESET);
            } else {
                user.setPlayerPoints(user.getPlayerPoints() + 10);
                System.out.println(Colors.BLUE_BOLD_BRIGHT + "\nALRIGHT! I GIVE UP! 10 POINTS FOR YOU! 😘\n" + Colors.RESET);
            }
            user.setCheats(user.getCheats() + 1);
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void ranking(User user) {
        int limit = Math.min(userList.size(), 5);
        userList = userList.stream()
                .sorted(Comparator.comparingInt(User::getPlayerPoints).reversed())
                .collect(Collectors.toList());

        IntStream.range(0, limit)
                .forEach((i) -> {
                    String message = switch (i) {
                        case 0 -> "\n🥇" + Colors.YELLOW_BOLD_BRIGHT;
                        case 1 -> "🥈" + Colors.WHITE_BOLD_BRIGHT;
                        case 2 -> "🥉" + Colors.MAGENTA_BOLD_BRIGHT;
                        default -> String.valueOf(i + 1);
                    };

                    System.out.println(message + ": " + userList.get(i).toStringRank() + Colors.RESET+"\n");
                });

        IntStream.range(5, userList.size())
                .filter(i -> user.getPlayerName().equals(userList.get(i).getPlayerName()))
                .forEach(i -> System.out.println(i + 1 + ": " + userList.get(i).toStringRank()));
    }

    public void startGameNarrative() {
        try {
            String story = "\nOn December 24, 2023, Paulo was excited to open gifts with his family. \nBut when he looked at the Christmas tree, his presents were gone, making him sad and confused.\n" +
                    "\n" +
                    "He found a green shoe that seemed to belong to an elf named Marco, thinking Marco took the gifts. \nFeeling down, Paulo went to his room.\n" +
                    "\n" +
                    "Santa Claus Tiago saw everything and decided to help. \nHe went to Marco's place to find the presents.\n" + "\n";

            for (int i = 0; i < story.length(); i++) {
                System.out.print(Colors.BLUE_BOLD_BRIGHT + "" + story.charAt(i) + Colors.RESET);
                Thread.sleep(50);
            }
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("\nSomething went wrong while starting game narrative...\n");
        }
    }

    public void endGameNarrative(User user) {
        try {
            String story;
            if (user.getPlayerGifts() > 0) {
                story = "\nOn Christmas morning, Paulo felt sad, but he found his gifts under the tree. \n\nHe opened them, feeling happy again until the next Christmas.";
            } else {
                story = "\nPaulo woke up sad on Christmas and found a note from Santa Tiago, saying he couldn't get the presents but promised more next year. \n\nPaulo felt a bit better, looking forward to the next Christmas.\n\n";
            }
            for (int i = 0; i < story.length(); i++) {
                System.out.print(Colors.BLUE_BOLD_BRIGHT + "" + story.charAt(i) + Colors.RESET);
                Thread.sleep(50);
            }
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println("\nSomething went wrong while starting game narrative...\n");
        }
    }
}