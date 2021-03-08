package io.github.arabienko.TelegramBot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class MassageService {

    public SendMessage onUpdateReceived(Update update) {

        SendMessage sendMessage=new SendMessage();
        if (update != null) {
            Message message=update.getMessage();
            sendMessage.setChatId(message.getChatId());
            if (message != null && message.hasText()) {
                String magText = message.getText();
                if (magText.equals("/start")) {
                    return sendMessage.setText("start");

                } else if (magText.equals("/settings")) {
                    return sendMessage.setText("settings");

                } else if (magText.equals("/help")) {
                    return sendMessage.setText("help");

                }

            }
        }
        return sendMessage.setText("do");
    }
}