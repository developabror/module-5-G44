package uz.app.service;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

//5836247882
public class BotMainService extends TelegramLongPollingBot {
    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage =new SendMessage();
        Long chatId = update.getMessage().getChatId();
        sendMessage.setChatId(chatId);

        switch (update.getMessage().getText()){
            case "/start"->{
                sendMessage.setText("Salom botga xush kelibsiz");
            }
            case "nma gap"->{
                sendMessage.setText("o'zizdachi?");
            }
            default -> sendMessage.setText(update.getMessage().getText());
        }

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();

        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow keyboardRow =new KeyboardRow();
        keyboardRow.add("text 1");
        keyboardRow.add("text 2");
        keyboardRow.add("text 3");
        keyboardRows.add(keyboardRow);
        keyboardRow = new KeyboardRow();
        keyboardRow.add("text 4");
        keyboardRow.add("text 5");
        keyboardRows.add(keyboardRow);
        keyboardRow = new KeyboardRow();
        keyboardRow.add("text 6");
        keyboardRows.add(keyboardRow);

        keyboardMarkup.setKeyboard(keyboardRows);
        sendMessage.setReplyMarkup(keyboardMarkup);


        execute(sendMessage);

    }

    @Override
    public String getBotUsername() {
        return "g44testbot";
    }

    @Override
    public String getBotToken() {
        return "7468325908:AAEHcl6fV-gzG_JrEAxL7No08LH4tJJDQzU";
    }
}
