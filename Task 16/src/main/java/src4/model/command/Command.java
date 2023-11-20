package src4.model.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import src4.model.sender.Sender;

public abstract class Command {
    public abstract Sender execute(SendMessage sendMsg);
}
