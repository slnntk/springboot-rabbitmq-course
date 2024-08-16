package net.slnntk.springboot.controller;

import lombok.RequiredArgsConstructor;
import net.slnntk.springboot.dto.User;
import net.slnntk.springboot.publisher.RabbitMQJsonProducer;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MessageJsonController {

    private final RabbitMQJsonProducer jsonProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        jsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Message sent to RabbitMQ ");
    }


}
