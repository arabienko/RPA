package io.github.arabienko.TelegramBot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.arabienko.TelegramBot.service.config.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

@SpringBootTest(classes = {TelegramBot.class, Mapper.class})
class TelegramBotTest {
    //остать из контекста
    @Autowired
    TelegramBot telegramBot;
    @Autowired
    ObjectMapper objectMapper;

   // @Test
    void onUpdateReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/update.json"), Update.class);
        telegramBot.onUpdateReceived(update);
        //throws IOException
    }

  //  @Test
    void sendMessage() throws TelegramApiException {
        SendMessage sendMessage=new SendMessage();
        sendMessage.setChatId(216016480L);
        sendMessage.setText("hello Bot");

        telegramBot.execute(sendMessage);
    }

}