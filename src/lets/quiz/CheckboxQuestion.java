package lets.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CheckboxQuestion extends Question {

    /* The main work of this version of quiz-time is done inside this class,
     * as all my other question classes inherit from CheckboxQuestion. You
     * may have chosen another inheritance path, and that's perfectly fine!
     * Yours is not more or less valid than mine, provided it works and it
     * makes sense.
     *
     * Allow me to explain my reasoning here:
     * A CheckboxQuestion is a question with a variable number of choices
     * and a variable number of correct answers.
     * A MultipleChoiceQuestion is a question with a variable number of
     * choices and a set number of correct answers (1).
     * A TrueFalseQuestion is a question with a set number of choices (2)
     * and a set number of correct answers (1).
     *
     * Therefore, from most general to most constricted:
     * Question -> CheckboxQuestion -> MultipleChoiceQuestion -> TrueFalseQuestion.
     */

    // These two arrays will hold our answers and correct answer numbers.
    protected ArrayList<String> answerChoices;
    protected ArrayList<Integer> correctChoices;

    // This string will be attached to the question when asked.
    // It will be changed in the other question subclasses during initialization.
    private String prompt = "Enter your answer choices, separated by commas.";

    // Protected constructor, used when subclasses call for the super constructor.
    protected CheckboxQuestion(String text) {
        super(text);
        answerChoices = new ArrayList<>();
        correctChoices = new ArrayList<>();
    }

    // Public constructor, for when you want to instantiate a CheckboxQuestion.
    public CheckboxQuestion(String text, ArrayList<String> answerChoices, ArrayList<Integer> correctChoices) {
        super(text);
        this.answerChoices = answerChoices;
        this.correctChoices = correctChoices;
    }

    // This allows us to set the prompt string from other subclasses.
    protected void setPrompt(String newPrompt) {
        this.prompt = newPrompt;
    }

    /* This is where the majority of the work for actually running the quiz happens.
     * This one overridden askQuestion() method will work for all of our subclasses,
     * due to the way I have constructed them and their inheritance chain.
     *
     * This obviously would not work for, say, a short answer question, which would
     * need to be created outside of the CheckboxQuestion inheritance chain, and
     * would need its own version of askQuestion().
     */
    @Override
    public int askQuestion() {
        // Prints the question, per the toString() below, then prints the prompt.
        System.out.println(this);
        System.out.println(prompt);

        // Creates a scanner to get user input.
        Scanner userInput = new Scanner(System.in);

        // Gets whole line of user input as a string, with individual answers separated by commas.
        String userGuessString = userInput.nextLine();
        // Splits the string into an array.
        String[] userGuesses = userGuessString.split(",");
        // Creates an empty Integer list to hold the user guesses in once we parse them as ints.
        ArrayList<Integer> userGuessesInts = new ArrayList<>();

        // Iterate through user guesses, changing them to ints (trimming any excess whitespace).
        for (String guessString :
                userGuesses) {
            userGuessesInts.add(Integer.parseInt(guessString.trim()));
        }

        // Sort both the user guesses and the correct answers lists, then compare them.
        Collections.sort(userGuessesInts);
        Collections.sort(correctChoices);

        // If they match, the user gets a point. Otherwise, 0 points.
        if (userGuessesInts.equals(correctChoices)) {
            return 1;
        }

        return 0;
    }

    @Override
    public String toString() {

        /* This toString() utilizes a StringBuilder to build a multiline string with
         * both the question and the possible answer choices. If you are unfamiliar
         * with StringBuilders, I suggest you check the Java docs. They're the best
         * way in Java to build a string dynamically.
         */
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
