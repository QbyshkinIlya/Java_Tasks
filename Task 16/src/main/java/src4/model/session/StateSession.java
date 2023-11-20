package src4.model.session;

import src4.model.Question;

public interface StateSession {
    enum State {INIT, ACTION, CHECK, END, ERROR};
    public Question action();
    public boolean check(String answer);
    public String end();
    public State getState();
}
