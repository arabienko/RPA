package io.github.arabienko.TelegramBot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class TelegramBotApplication {

	public static void main(String[] args) {
		ApiContextInitializer.init();
		//процесс загрузки,
		SpringApplication.run(TelegramBotApplication.class, args);

	}

}
