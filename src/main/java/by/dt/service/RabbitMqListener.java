package by.dt.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
//public class RabbitMqListener {
//
//    @RabbitListener(queues = "query-example-3-1")
//    public void worker1(String message) {
//        System.out.println("accepted on worker 1 : " + message);
//    }
//
//    @RabbitListener(queues = "query-example-3-2")
//    public void worker2(String message) {
//        System.out.println("accepted on worker 2 : " + message);
//    }
//}