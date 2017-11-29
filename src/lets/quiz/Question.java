package lets.quiz;

public abstract class Question {

    protected String text;

    public Question(String text) {
        this.text = text;
    }

    public abstract int askQuestion();
}
