package lets.quiz;

import java.util.ArrayList;

public class Quiz {
    private int maxScore = 0;
    private int score = 0;
    private String name;
    private ArrayList<Question> questions = new ArrayList<>();

    public Quiz (String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void addQuestion(Question newQuestion) {
        maxScore += 1;
        questions.add(newQuestion);
    }

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
