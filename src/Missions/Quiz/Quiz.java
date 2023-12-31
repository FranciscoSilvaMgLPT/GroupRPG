package Missions.Quiz;

import FrontEnd.Colors;
import UserManager.User;

import java.util.List;
import java.util.Scanner;

public class Quiz {
    //====== LEVEL 1 ======\\
    public List<Question> missionQuiz1Level1 = QuestionsFactory.createMissionQuiz1Level1();
    public List<Question> missionQuiz2Level1 = QuestionsFactory.createMissionQuiz2Level1();
    public List<Question> missionQuiz3Level1 = QuestionsFactory.createMissionQuiz3Level1();

    //====== LEVEL 2 ======\\
    public List<Question> missionQuiz1Level2 = QuestionsFactory.createMissionQuiz1Level2();
    public List<Question> missionQuiz2Level2 = QuestionsFactory.createMissionQuiz2Level2();
    public List<Question> missionQuiz3Level2 = QuestionsFactory.createMissionQuiz3Level2();

    public void playQuiz1Level1(User user) {
        Scanner scan = new Scanner(System.in);

        missionQuiz1Level1.forEach(e -> {
            System.out.println("\n" + Colors.WHITE_BOLD_BRIGHT + e.getQuestion() + Colors.RESET);
            System.out.println(Colors.WHITE_BOLD_BRIGHT + String.join(" ", e.getPossibleAnswers()) + Colors.RESET);
            System.out.print(Colors.WHITE_BOLD_BRIGHT + "=> " + Colors.RESET);
            char userAnswer = scan.next().charAt(0);

            if (userAnswer == e.getCorrectAnswer()) {
                e.setCompleted(true);
                System.out.println(Colors.GREEN_BOLD_BRIGHT + "\nCorrect answer!" + Colors.RESET);
                user.setPlayerPoints(user.getPlayerPoints() + 1);
            } else {
                e.setCompleted(false);
                System.out.println(Colors.RED_BOLD_BRIGHT + "\nWrong answer!" + Colors.RESET);
            }
        });
    }

    public void playQuiz2Level1(User user) {
        Scanner scan = new Scanner(System.in);

        missionQuiz2Level1.forEach(e -> {
            System.out.println("\n" + Colors.WHITE_BOLD_BRIGHT + e.getQuestion() + Colors.RESET);
            System.out.println(Colors.WHITE_BOLD_BRIGHT + String.join(" ", e.getPossibleAnswers()) + Colors.RESET);
            System.out.print(Colors.WHITE_BOLD_BRIGHT + "=> " + Colors.RESET);
            char userAnswer = scan.next().charAt(0);

            if (userAnswer == e.getCorrectAnswer()) {
                e.setCompleted(true);
                System.out.println(Colors.GREEN_BOLD_BRIGHT + "\nCorrect answer!" + Colors.RESET);
                user.setPlayerPoints(user.getPlayerPoints() + 1);
            } else {
                e.setCompleted(false);
                System.out.println(Colors.RED_BOLD_BRIGHT + "\nWrong answer!" + Colors.RESET);
            }
        });
    }

    public void playQuiz3Level1(User user) {
        Scanner scan = new Scanner(System.in);

        missionQuiz3Level1.forEach(e -> {
            System.out.println("\n" + Colors.WHITE_BOLD_BRIGHT + e.getQuestion() + Colors.RESET);
            System.out.println(Colors.WHITE_BOLD_BRIGHT + String.join(" ", e.getPossibleAnswers()) + Colors.RESET);
            System.out.print(Colors.WHITE_BOLD_BRIGHT + "=> " + Colors.RESET);
            char userAnswer = scan.next().charAt(0);

            if (userAnswer == e.getCorrectAnswer()) {
                e.setCompleted(true);
                System.out.println(Colors.GREEN_BOLD_BRIGHT + "\nCorrect answer!\n" + Colors.RESET);
                user.setPlayerPoints(user.getPlayerPoints() + 1);
            } else {
                e.setCompleted(false);
                System.out.println(Colors.RED_BOLD_BRIGHT + "\nWrong answer!\n" + Colors.RESET);
            }
        });
    }

    public void playQuiz1Level2(User user) {
        Scanner scan = new Scanner(System.in);

        missionQuiz1Level2.forEach(e -> {
            System.out.println("\n" + Colors.WHITE_BOLD_BRIGHT + e.getQuestion() + Colors.RESET);
            System.out.println(Colors.WHITE_BOLD_BRIGHT + String.join(" ", e.getPossibleAnswers()) + Colors.RESET);
            System.out.print(Colors.WHITE_BOLD_BRIGHT + "=> " + Colors.RESET);
            char userAnswer = scan.next().charAt(0);

            if (userAnswer == e.getCorrectAnswer()) {
                e.setCompleted(true);
                System.out.println(Colors.GREEN_BOLD_BRIGHT + "\nCorrect answer!" + Colors.RESET);
                user.setPlayerPoints(user.getPlayerPoints() + 1);
            } else {
                e.setCompleted(false);
                System.out.println(Colors.RED_BOLD_BRIGHT + "\nWrong answer!" + Colors.RESET);
            }
        });
    }

    public void playQuiz2Level2(User user) {
        Scanner scan = new Scanner(System.in);

        missionQuiz2Level2.forEach(e -> {
            System.out.println("\n" + Colors.WHITE_BOLD_BRIGHT + e.getQuestion() + Colors.RESET);
            System.out.println(Colors.WHITE_BOLD_BRIGHT + String.join(" ", e.getPossibleAnswers()) + Colors.RESET);
            System.out.print(Colors.WHITE_BOLD_BRIGHT + "=> " + Colors.RESET);
            char userAnswer = scan.next().charAt(0);

            if (userAnswer == e.getCorrectAnswer()) {
                e.setCompleted(true);
                System.out.println(Colors.GREEN_BOLD_BRIGHT + "\nCorrect answer!" + Colors.RESET);
                user.setPlayerPoints(user.getPlayerPoints() + 1);
            } else {
                e.setCompleted(false);
                System.out.println(Colors.RED_BOLD_BRIGHT + "\nWrong answer!" + Colors.RESET);
            }
        });
    }

    public void playQuiz3Level2(User user) {
        Scanner scan = new Scanner(System.in);

        missionQuiz3Level2.forEach(e -> {
            System.out.println("\n" + Colors.WHITE_BOLD_BRIGHT + e.getQuestion() + Colors.RESET);
            System.out.println(Colors.WHITE_BOLD_BRIGHT + String.join(" ", e.getPossibleAnswers()) + Colors.RESET);
            System.out.print(Colors.WHITE_BOLD_BRIGHT + "=> " + Colors.RESET);
            char userAnswer = scan.next().charAt(0);

            if (userAnswer == e.getCorrectAnswer()) {
                e.setCompleted(true);
                System.out.println(Colors.GREEN_BOLD_BRIGHT + "\nCorrect answer!\n" + Colors.RESET);
                user.setPlayerPoints(user.getPlayerPoints() + 1);
            } else {
                e.setCompleted(false);
                System.out.println(Colors.RED_BOLD_BRIGHT + "\nWrong answer!\n" + Colors.RESET);
            }
        });
    }
}