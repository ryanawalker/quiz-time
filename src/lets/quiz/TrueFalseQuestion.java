package lets.quiz;

public class TrueFalseQuestion extends MultipleChoiceQuestion{

    // At this point, all we need is the public constructor in here.
    public TrueFalseQuestion(String text, Integer answer) {
        super(text);
        this.answerChoices.add("False");
        this.answerChoices.add("True");
        this.correctChoices.add(answer);
    }

}
