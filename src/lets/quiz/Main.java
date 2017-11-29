package lets.quiz;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> question1Choices = new ArrayList<>();
        question1Choices.add("Nine");
        question1Choices.add("Four");
        question1Choices.add("Five");
        question1Choices.add("Three");
        ArrayList<Integer> question1Answers = new ArrayList<>();
        question1Answers.add(0);
        question1Answers.add(1);
        question1Answers.add(2);
        CheckboxQuestion question1 = new CheckboxQuestion("Which of these answers is a four letter word?", question1Choices, question1Answers);
        ArrayList<String> question2Choices = new ArrayList<>();
        question2Choices.add("Twelve");
        question2Choices.add("Eight");
        question2Choices.add("Four");
        question2Choices.add("Three");
        MultipleChoiceQuestion question2 = new MultipleChoiceQuestion("Which of these answers is a four letter word?", question2Choices, 2);
        TrueFalseQuestion question3 = new TrueFalseQuestion("The word seven has four letters in it.", 0);

        Quiz theQuiz = new Quiz("4 Letter Words Quiz");
        theQuiz.addQuestion(question1);
        theQuiz.addQuestion(question2);
        theQuiz.addQuestion(question3);

        theQuiz.runQuiz();
    }
}
