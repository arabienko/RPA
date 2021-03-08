package io.github.arabienko.TelegramBot;

import io.github.arabienko.TelegramBot.service.MassageService;
import io.github.arabienko.TelegramBot.service.TelegramBot;
import io.github.arabienko.TelegramBot.service.config.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.telegram.telegrambots.meta.api.objects.Message;

@SpringBootTest(classes = {TelegramBot.class, Mapper.class, MassageService.class})
public class TelegramBotApplicationTests {

	@Test
	void contextLoads() {
	}

}
