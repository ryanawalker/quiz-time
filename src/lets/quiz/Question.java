package lets.quiz;

public abstract class Question {

    /* I determined that all a base, abstract Question should know how to do
     * is know what it's asking, and require the ability to ask it.
     */

    /* Any time you see a protected field/method in these classes, it's because
     * I wanted to give the subclasses access to those fields/methods without
     * making those accessible outside of the subclasses.
     */

    protected String text;

    /* For example, this constructor cannot be called outside of this class or
     * it's subclasses, which means that even if this class wasn't abstract, it
     * could not be instantiated.
     */

    protected Question(String text) {
        this.text = text;
    }

    /* I chose not to implement the actual method that would ask a question in
     * this base class, as I can envision a variety of different ways in which
     * a question could be asked/scored. As such, I just require that all
     * questions implement the ability to ask and score itself (hence why this
     * method returns an int -- the score, either 0 or 1).
     */

    public abstract int askQuestion();
}
