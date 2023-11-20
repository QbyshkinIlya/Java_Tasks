package src4;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import src4.model.command.*;
import src4.model.sender.Sender;
import src4.model.session.StateSession;

import java.util.HashMap;

public class TelegramBot extends TelegramLongPollingBot {
    final private String BOT_NAME = "Task16bot_bot";
    final private String BOT_TOKEN = "6631185924:AAEwE5D0hih0uyB4Rj3isUG6ZD74QPYfV0o";

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    private final HashMap<String, Command> commandMap = new HashMap<>();
    private final HashMap<Long, Sender> userChat = new HashMap<>();

    public TelegramBot() {
        commandMap.put("/learn", new LearnCommand());
        commandMap.put("/exam", new ExamCommand());
        commandMap.put("/study", new StudyCommand());
    }

    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message inMsg = update.getMessage();
            String text = inMsg.getText();
            Long chatID = inMsg.getChatId();
            SendMessage sendMsg = new SendMessage();

            // Определение текущего режима бота
            if (text.startsWith("/")) {
                Command currentCommand = commandMap.get(text);
                Sender stateSession = currentCommand.execute(sendMsg);

                if (stateSession != null) {
                    userChat.put(chatID, stateSession);
                    sendMsg = stateSession.createSendMessage();
                }
            } else {
                Sender stateSession = userChat.get(chatID);
//                Sender stateSession =
                if (stateSession == null) sendMsg.setText("Ошибочная команда!");
                else {
                    stateSession.onMessageReceived(text);
                    sendMsg = stateSession.createSendMessage();
                }
            }
            sendMsg.setChatId(chatID.toString());
            try {
                execute(sendMsg);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}

