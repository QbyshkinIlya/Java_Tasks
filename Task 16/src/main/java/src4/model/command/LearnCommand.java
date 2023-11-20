package src4.model.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import src4.model.sender.LearnSender;
import src4.model.sender.Sender;

public class LearnCommand extends Command {
    @Override
    public Sender execute(SendMessage sendMsg) {
        Sender learnSender = new LearnSender();
        learnSender.onMessageReceived(sendMsg.getText());
        return learnSender;
    }
}
