package net.slnntk.springboot.consumer;


import lombok.RequiredArgsConstructor;
import net.slnntk.springboot.dto.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class RabbitMQJsonConsumer {

    private static final Logger LOGGER = Logger.getLogger(RabbitMQConsumer.class.getName());

    @RabbitListener(queues = "${rabbitmq.queue.json.name}")
    public void consumeJsonMessage(User user) {
        LOGGER.info(String.format("Received Json message: %s", user.toString()));

    }

}
