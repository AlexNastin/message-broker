package by.dt;

import by.dt.config.Config;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(Config.class)
public class MessageGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageGatewayApplication.class, args);
    }
}
