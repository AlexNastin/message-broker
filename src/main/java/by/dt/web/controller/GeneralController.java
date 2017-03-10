package by.dt.web.controller;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class GeneralController {

    @Autowired
    RabbitTemplate template;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Empty mapping";
    }

    @RequestMapping("/emit")
    @ResponseBody
    String emit() {
        System.out.println(("Emit to exchange-example-3"));
        template.setExchange("exchange-example-3");
        template.convertAndSend("Fanout message");
        return "Emit to exchange-example-3";
    }
}
