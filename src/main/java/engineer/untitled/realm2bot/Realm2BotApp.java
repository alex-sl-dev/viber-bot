package engineer.untitled.realm2bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class Realm2BotApp {

	public static void main(String[] args) {
		SpringApplication.run(Realm2BotApp.class, args);
	}

}
