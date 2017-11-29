package lets.quiz;

import java.util.ArrayList;

public class Quiz {

    // Some fields for keeping track of score and the name of the quiz, plus a place for questions to go.
    private int maxScore = 0;
    private int score = 0;
    private String name;
    private ArrayList<Question> questions = new ArrayList<>();

    public Quiz (String name) {
        this.name = name;
    }

    // Lets you add a question to the quiz, changing the max possible score accordingly.
    public void addQuestion(Question newQuestion) {
        maxScore += 1;
        questions.add(newQuestion);
    }

    /* This nominally runs the quiz, but in practice is just iterating through the
     * question list and calling askQuestion() on each of them. Prints final score
     * after all questions are asked.
     */
    public void runQuiz() {
        System.out.println(name + "\n");
        for (Question question :
                questions) {
            score += question.askQuestion();
            System.out.println("\n");
        }

        System.out.println("Your score:");
        System.out.println(score + "/" + maxScore);
    }
}
