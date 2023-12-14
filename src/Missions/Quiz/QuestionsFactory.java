package Missions.Quiz;

import java.util.ArrayList;
import java.util.List;

public class QuestionsFactory {
    public static List<Question> createMissionQuiz1Level1() {

        //====== LEVEL 1 ======\\
        //==== CREATE MISSION QUIZ 1 LEVEL 1 ====\\
        List<Question> missionQuiz1Level1 = new ArrayList<>();

        missionQuiz1Level1.add(new Question("What is the largest planet in our solar system?",
                List.of("a) Jupiter", "b) Saturn", "c) Earth", "d) Uranus"), 'a'));

        missionQuiz1Level1.add(new Question("Who painted the Mona Lisa?",
                List.of("a) Vincent van Gogh", "b) Leonardo da Vinci", "c) Pablo Picasso", "d) Michelangelo"), 'b'));

        missionQuiz1Level1.add(new Question("What is the capital of Canada?",
                List.of("a) Montreal", "b) Ottawa", "c) Toronto", "d) Vancouver"), 'b'));

        return missionQuiz1Level1;
    }

    public static List<Question> createMissionQuiz2Level1() {
        //====== LEVEL 1 ======\\
        //==== CREATE MISSION QUIZ 2 LEVEL 1 ====\\
        List<Question> missionQuiz2Level1 = new ArrayList<>();

        missionQuiz2Level1.add(new Question("Who was the first man to walk on the moon?",
                List.of("a) Neil Armstrong", "b) Buzz Aldrin", "c) Yuri Gagarin", "d) John Glenn"), 'a'));

        missionQuiz2Level1.add(new Question("What is the most abundant chemical element in the universe?",
                List.of("a) Oxygen", "b) Hydrogen", "c) Carbon", "d) Iron"), 'b'));

        missionQuiz2Level1.add(new Question("In which continent is Mount Kilimanjaro located?",
                List.of("a) Africa", "b) Asia", "c) Europe", "d) South America"), 'a'));

        return missionQuiz2Level1;
    }

    public static List<Question> createMissionQuiz3Level1() {

        //====== LEVEL 1 ======\\
        //==== CREATE MISSION QUIZ 3 LEVEL 1 ====\\
        List<Question> missionQuiz3Level1 = new ArrayList<>();

        missionQuiz3Level1.add(new Question("Who wrote \"Don Quixote\"?",
                List.of("a) William Shakespeare", "b) Gustave Flaubert", "c) Dante Alighieri", "d) Miguel de Cervantes"), 'd'));

        missionQuiz3Level1.add(new Question("What is the second largest ocean in the world?",
                List.of("a) Indian Ocean", "b) Pacific Ocean", "c) Arctic Ocean", "d) Atlantic Ocean"), 'd'));

        missionQuiz3Level1.add(new Question("What is the capital of Australia?",
                List.of("a) Sydney", "b) Canberra", "c) Melbourne", "d) Brisbane"), 'b'));

        return missionQuiz3Level1;
    }

    public static List<Question> createMissionQuiz1Level2() {

        //====== LEVEL 2 ======\\
        //==== CREATE MISSION QUIZ 1 LEVEL 2 ====\\
        List<Question> missionQuiz1Level2 = new ArrayList<>();

        missionQuiz1Level2.add(new Question("Who was the first president of the United States?",
                List.of("a) Benjamin Franklin", "b) George Washington", "c) Thomas Jefferson", "d) John Adams"), 'b'));

        missionQuiz1Level2.add(new Question("What is the tallest mountain in the world?",
                List.of("a) Mount Everest", "b) K2", "c) Mont Blanc", "d) Kilimanjaro"), 'a'));

        missionQuiz1Level2.add(new Question("Who wrote the play \"Romeo and Juliet\"?",
                List.of("a) William Shakespeare", "b) Charles Dickens", "c) Jane Austen", "d) Oscar Wilde"), 'a'));

        return missionQuiz1Level2;
    }

    public static List<Question> createMissionQuiz2Level2() {

        //====== LEVEL 2 ======\\
        //==== CREATE MISSION QUIZ 2 LEVEL 2 ====\\
        List<Question> missionQuiz2Level2 = new ArrayList<>();

        missionQuiz2Level2.add(new Question("What is the largest desert in the world?",
                List.of("a) Arabian Desert", "b) Gobi Desert", "c) Sahara Desert", "d) Kalahari Desert"), 'c'));

        missionQuiz2Level2.add(new Question("Who painted the artwork \"Starry Night\"?",
                List.of("a) Claude Monet", "b) Vincent van Gogh", "c) Salvador Dalí", "d) Pablo Picasso"), 'b'));

        missionQuiz2Level2.add(new Question("Which country has the largest land area in the world?",
                List.of("a) China", "b) Russia", "c) Canada", "d) United States"), 'b'));

        return missionQuiz2Level2;
    }

    public static List<Question> createMissionQuiz3Level2() {

        //====== LEVEL 2 ======\\
        //==== CREATE MISSION QUIZ 3 LEVEL 2 ====\\
        List<Question> missionQuiz3Level2 = new ArrayList<>();

        missionQuiz3Level2.add(new Question("Who was the South African political leader who fought against apartheid and became the country's president?",
                List.of("a) Nelson Mandela", "b) Desmond Tutu", "c) Thabo Mbeki", "d) Jacob Zuma"), 'a'));

        missionQuiz3Level2.add(new Question("Which element has the chemical symbol 'Fe'?",
                List.of("a) Iron", "b) Gold", "c) Silver", "d) Copper"), 'a'));

        missionQuiz3Level2.add(new Question("Who is known as the \"Father of Modern Physics\"?",
                List.of("a) Isaac Newton", "b) Galileo Galilei", "c) Nikola Tesla", "d) Albert Einstein"), 'd'));

        return missionQuiz3Level2;
    }
}