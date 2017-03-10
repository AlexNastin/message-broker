package by.dt;

import by.dt.config.RabbitMQConfig;
import by.dt.config.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({RabbitMQConfig.class, WebConfig.class})
public class MessageGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageGatewayApplication.class, args);
    }
}
