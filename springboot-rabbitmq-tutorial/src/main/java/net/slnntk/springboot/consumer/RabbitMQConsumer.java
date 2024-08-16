package net.slnntk.springboot.consumer;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class RabbitMQConsumer {

    private static final Logger LOGGER = Logger.getLogger(RabbitMQConsumer.class.getName());

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void consumeMessage(String message) {
        LOGGER.info(String.format("Message received: %s", message));

    }

}
