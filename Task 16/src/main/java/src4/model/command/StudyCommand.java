package src4.model.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import src4.model.sender.Sender;
import src4.model.sender.StudySender;

public class StudyCommand extends Command {
    @Override
    public Sender execute(SendMessage sendMsg) {
        Sender studySender = new StudySender();
        studySender.onMessageReceived(sendMsg.getText());
        return studySender;
    }
}
