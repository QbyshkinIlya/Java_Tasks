package src4.model.session;

import src4.model.Examinator;
import src4.model.Question;

public class ExamSession implements StateSession{
    State stateSession;
    Examinator examinator;

    public ExamSession() {
        stateSession = State.INIT;
        examinator = new Examinator();
    }
    @Override
    public Question action() {
        stateSession = State.ACTION;
        return examinator.action();
    }

    @Override
    public boolean check(String answer) {
        if (stateSession == State.ACTION) {
            stateSession = State.CHECK;
            return examinator.check(answer);
        }
        return false;
    }

    @Override
    public String end() {
        if (stateSession == State.CHECK) {
            stateSession = State.END;
            return examinator.end();
        }
        return null;
    }

    @Override
    public State getState() {
        return stateSession;
    }
}
