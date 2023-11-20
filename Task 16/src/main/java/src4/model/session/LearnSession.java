package src4.model.session;

import src4.model.Leaner;
import src4.model.Question;

public class LearnSession implements StateSession {
    State stateSession;
    Leaner leaner;

    public LearnSession() {
        stateSession = State.INIT;
        leaner = new Leaner();
    }

    @Override
    public Question action() {
        stateSession = State.ACTION;
        return leaner.action();
    }

    @Override
    public boolean check(String answer) {
        if (stateSession == State.ACTION) {
            stateSession = State.CHECK;
            return leaner.check(answer);
        }
        return false;
    }

    @Override
    public String end() {
        if (stateSession == State.CHECK) {
            stateSession = State.END;
            return leaner.end();
        }
        return null;
    }

    @Override
    public State getState() {
        return stateSession;
    }
}
