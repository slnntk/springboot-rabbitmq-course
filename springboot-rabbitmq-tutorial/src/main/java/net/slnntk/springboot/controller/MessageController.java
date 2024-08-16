package net.slnntk.springboot.controller;

import lombok.RequiredArgsConstructor;
import net.slnntk.springboot.publisher.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/message")
@RequiredArgsConstructor
public class MessageController {

    private final RabbitMQProducer rabbitMQProducer;

    // http://localhost:8080/api/v1/message/publish
    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String  message) {
        rabbitMQProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent: " + message);
    }

}
