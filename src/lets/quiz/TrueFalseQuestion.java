package lets.quiz;

public class TrueFalseQuestion extends MultipleChoiceQuestion{

    public TrueFalseQuestion(String text, Integer answer) {
        super(text);
        this.answerChoices.add("False");
        this.answerChoices.add("True");
        this.correctChoices.add(answer);
    }

}
