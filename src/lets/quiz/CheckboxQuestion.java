package lets.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CheckboxQuestion extends Question {

    protected ArrayList<String> answerChoices;
    protected ArrayList<Integer> correctChoices;
    private String prompt = "Enter your answer choices, separated by commas.";

    protected CheckboxQuestion(String text) {
        super(text);
        answerChoices = new ArrayList<>();
        correctChoices = new ArrayList<>();
    }

    public CheckboxQuestion(String text, ArrayList<String> answerChoices, ArrayList<Integer> correctChoices) {
        super(text);
        this.answerChoices = answerChoices;
        this.correctChoices = correctChoices;
    }

    public void setPrompt(String newPrompt) {
        this.prompt = newPrompt;
    }

    @Override
    public int askQuestion() {
        System.out.println(this);
        System.out.println(prompt);

        Scanner userInput = new Scanner(System.in);
        String userGuessString = userInput.nextLine();
        String[] userGuesses = userGuessString.split(",");

        ArrayList<Integer> userGuessesInts = new ArrayList<>();

        for (String guessString :
                userGuesses) {
            userGuessesInts.add(Integer.parseInt(guessString.trim()));
        }

        Collections.sort(userGuessesInts);
        Collections.sort(correctChoices);

        if (userGuessesInts.equals(correctChoices)) {
            return 1;
        }

        return 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.text);
        sb.append("\n\n");
        for (String answerChoice :
                answerChoices) {
            sb.append(answerChoices.indexOf(answerChoice) + " " + answerChoice + "\n");
        }
        return sb.toString();
    }
}
