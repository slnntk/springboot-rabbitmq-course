package net.slnntk.springboot.publisher;

import lombok.RequiredArgsConstructor;
import net.slnntk.springboot.dto.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class RabbitMQJsonProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.json.key}")
    private String jsonRoutingKey;

    private final RabbitTemplate rabbitTemplate;

    private static final Logger LOGGER = Logger.getLogger(RabbitMQJsonProducer.class.getName());

    public void sendJsonMessage(User user) {
        rabbitTemplate.convertAndSend(exchange, jsonRoutingKey, user);
        LOGGER.info(String.format("Message sent: %s", user.toString()));
    }
}
