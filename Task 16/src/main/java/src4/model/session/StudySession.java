package src4.model.session;

import src4.model.Question;
import src4.model.Study;

public class StudySession implements StateSession {
    State stateSession;
    Study study;

    public StudySession() {
        stateSession = State.INIT;
        study = new Study();
    }

    @Override
    public Question action() {
        stateSession = State.ACTION;
        return study.action();
    }

    @Override
    public boolean check(String answer) {
        if (stateSession == State.ACTION) {
            stateSession = State.CHECK;
            return study.check(answer);
        }
        return false;
    }

    @Override
    public String end() {
        if (stateSession == State.CHECK) {
            stateSession = State.END;
            return study.end();
        }
        return null;
    }

    @Override
    public State getState() {
        return stateSession;
    }
}
