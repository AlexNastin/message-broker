package by.dt.config;

import by.dt.config.ampq.QueueAMPQCreator;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("default")
@Configuration
@EnableRabbit
public class RabbitMQConfig {

    @Autowired
    private GatewayProperties gatewayProperties;

//    @Bean
//    public QueueAMPQCreator queueAMPQCreator() {
//        return new QueueAMPQCreator(gatewayProperties.getQueue().getNames());
//    }
//
//    @Bean
//    public ConnectionFactory connectionFactory() {
//        CachingConnectionFactory connectionFactory =
//                new CachingConnectionFactory("localhost");
//        return connectionFactory;
//    }
//
//    @Bean
//    public AmqpAdmin amqpAdmin() {
//        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory());
//        return rabbitAdmin;
//    }
//
//    @Bean
//    public RabbitTemplate rabbitTemplate() {
//        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
//        return rabbitTemplate;
//    }


    @Bean
    public Queue myQueue1() {
        return new Queue(gatewayProperties.getQueue().getNames().get(0).trim());
    }

    @Bean
    public Queue myQueue2() {
        return new Queue(gatewayProperties.getQueue().getNames().get(1).trim());
    }

    @Bean
    public FanoutExchange fanoutExchangeA() {

        return new FanoutExchange("exchange-example-3");
    }


    @Bean
    public Binding binding1() {
        System.out.println(myQueue1().getName());
        return BindingBuilder.bind(myQueue1()).to(fanoutExchangeA());
    }

    @Bean
    public Binding binding2() {
        System.out.println(myQueue1().getName());
        return BindingBuilder.bind(myQueue2()).to(fanoutExchangeA());
    }
}
