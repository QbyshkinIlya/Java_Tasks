package src4.model.sender;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import src4.model.session.StateSession;

public abstract class Sender {
    StateSession stateSession; //режим
    long chatID; //пользователь

    public abstract void onMessageReceived(String message); //получить сообщение
    public abstract SendMessage createSendMessage(); //отправить сообщение
}
