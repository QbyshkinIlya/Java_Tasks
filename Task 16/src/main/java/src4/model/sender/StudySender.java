package src4.model.sender;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import src4.model.Question;
import src4.model.session.StateSession;
import src4.model.session.StudySession;

public class StudySender extends Sender {
    public StudySender() {
        stateSession = new StudySession();
    }
    @Override
    public void onMessageReceived(String message) {
        stateSession.check(message);
    }

    @Override
    public SendMessage createSendMessage() {
        SendMessage sendMsg = new SendMessage();

        if (stateSession.getState() == StateSession.State.ACTION ||
                stateSession.getState() == StateSession.State.INIT) {
            Question qt = stateSession.action();
            sendMsg.setText(qt.getQuestion() + "?");
        }
        else { sendMsg.setText("" + stateSession.end()); }
        return sendMsg;
    }
}
