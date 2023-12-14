package Missions.Quiz;

import java.util.List;

public class Question {
    private final String question;
    private final List<String> possibleAnswers;
    private final char correctAnswer;
    private boolean isCompleted;


    //====== CONSTRUCTOR ======\\
    public Question(String question, List<String> possibleAnswers, char correctAnswer) {
        this.question = question;
        this.possibleAnswers = possibleAnswers;
        this.correctAnswer = correctAnswer;
        this.isCompleted = false;
    }


    //====== GETTER & SETTER ======\\
    public String getQuestion() {
        return question;
    }

    public List<String> getPossibleAnswers() {
        return possibleAnswers;
    }

    public char getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}