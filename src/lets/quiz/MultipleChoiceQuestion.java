package lets.quiz;

import java.util.ArrayList;

public class MultipleChoiceQuestion extends CheckboxQuestion {

    // Another protected constructor, for when TrueFalseQuestion calls it.
    protected MultipleChoiceQuestion(String text) {
        super(text);
        setPrompt("Enter the correct answer choice.");
    }

    // Public constructor. Note how it only takes one right answer, but appends it to the correctChoices ArrayList.
    public MultipleChoiceQuestion(String text, ArrayList<String> answerChoices, Integer correctAnswer) {
        super(text);
        this.answerChoices = answerChoices;
        this.correctChoices.add(correctAnswer);
        // Both of these constructors set the answer prompt accordingly so the user knows to only guess one choice.
        setPrompt("Enter the correct answer choice.");
    }

}
