package src4.model.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import src4.model.sender.ExamSender;
import src4.model.sender.Sender;

public class ExamCommand extends Command{
    @Override
    public Sender execute(SendMessage sendMsg) {
        Sender sender = new ExamSender();
        return sender;
    }
}
