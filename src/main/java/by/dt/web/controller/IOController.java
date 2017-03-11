package by.dt.web.controller;

import by.dt.config.GatewayProperties;
import by.dt.entity.HttpMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/gateway")
public class IOController {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    GatewayProperties gatewayProperties;


    @RequestMapping(path = "/emit", method = RequestMethod.GET)
    public ResponseEntity<HttpMessage> io(String json) {
//        gatewayProperties.getNames().forEach(it-> System.out.println(it));
        json = "!!!!!!!! TEST !!!!!!!!";
        System.out.println(("Emit to exchange-example-3"));
        template.setExchange("exchange-example-3");
        template.convertAndSend(json);
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new HttpMessage());
        return null;
    }
}
