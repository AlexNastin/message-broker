package by.dt;

import by.dt.config.GatewayProperties;
import by.dt.config.RabbitMQConfig;
import by.dt.config.WebConfig;
import by.dt.config.ampq.QueueAMPQCreator;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.util.Map;

@SpringBootApplication
@Import({RabbitMQConfig.class, WebConfig.class, GatewayProperties.class})
@ComponentScan(basePackages = "by.dt")

public class MessageGatewayApplication {



    public static void main(String[] args) {
      ApplicationContext  applicationContext = SpringApplication.run(MessageGatewayApplication.class, args);
        GatewayProperties gatewayProperties = applicationContext.getBean(GatewayProperties.class);
        gatewayProperties.getQueue().getNames().forEach(it-> System.out.println(it));
//        QueueAMPQCreator queueAMPQCreator =  applicationContext.getBean(QueueAMPQCreator.class);
//
//        Map<String, Queue> queues = queueAMPQCreator.createQueues();
//
//        for (Map.Entry entry : queues.entrySet()) {
//            System.out.println(entry.getKey() + ", " + entry.getValue());
//        }
    }
}
