package io.github.arabienko.TelegramBot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.arabienko.TelegramBot.TelegramBotApplication;
import io.github.arabienko.TelegramBot.TelegramBotApplicationTests;
import io.github.arabienko.TelegramBot.service.config.Mapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {TelegramBot.class, Mapper.class, MassageService.class})
class MassageServiceTest extends TelegramBotApplicationTests {

    @Autowired
    TelegramBot telegramBot;

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    MassageService massageService;

   /* @Test
    void onUpdateReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/update.json"), Update.class);
        SendMessage actualResult = massageService.onUpdateReceived(update);
        SendMessage expectedResult = makeMessage("do no");
        assertEquals(expectedResult, actualResult);
    }*/

    @Test
    void onUnknowReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/update.json"), Update.class);
        SendMessage actualResult = massageService.onUpdateReceived(update);
        SendMessage expectedResult = makeMessage("do");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void onStartReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/start.json"), Update.class);
        SendMessage actualResult = massageService.onUpdateReceived(update);
        SendMessage expectedResult = makeMessage("start");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void onSettingsReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/settings.json"), Update.class);
        SendMessage actualResult = massageService.onUpdateReceived(update);
        SendMessage expectedResult = makeMessage("settings");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void onHelpReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/help.json"), Update.class);
        SendMessage  actualResult = massageService.onUpdateReceived(update);
        SendMessage expectedResult = makeMessage("help");
        assertEquals(expectedResult, actualResult);
    }


    private SendMessage makeMessage(String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(216016480L);
        sendMessage.setText(text);
        return sendMessage;
    }

}