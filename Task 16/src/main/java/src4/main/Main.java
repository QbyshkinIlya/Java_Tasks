package src4.main;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import src4.TelegramBot;

public class Main {
    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBot = new TelegramBotsApi(DefaultBotSession.class);
        TelegramBot myBot = new TelegramBot();
        telegramBot.registerBot(myBot);
    }
}

