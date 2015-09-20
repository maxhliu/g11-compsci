package testing.trivia;

public class Trivia {

    String question;
    boolean answer;

    Trivia(String q, boolean a) {
        question = q;
        answer = a;
    }

    void setAnswer(boolean a) {
        answer = a;
    }
    
    @Override
    public String toString() {
        return question;
    }
}
