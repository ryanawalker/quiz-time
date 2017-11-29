package lets.quiz;

import java.util.ArrayList;

public class MultipleChoiceQuestion extends CheckboxQuestion {

    protected MultipleChoiceQuestion(String text) {
        super(text);
        setPrompt("Enter the correct answer choice.");
    }

    public MultipleChoiceQuestion(String text, ArrayList<String> answerChoices, Integer correctAnswer) {
        super(text);
        this.answerChoices = answerChoices;
        this.correctChoices.add(correctAnswer);
        setPrompt("Enter the correct answer choice.");
    }

}
