package io.ushi.springboot.runner;

import io.ushi.springboot.amqp.receiver.Receiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class MQSendRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MQSendRunner.class);

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;
    private final ConfigurableApplicationContext context;

    public MQSendRunner(Receiver receiver, RabbitTemplate rabbitTemplate,
                  ConfigurableApplicationContext context) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
        this.context = context;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Sending message...");
        rabbitTemplate.convertAndSend("springboot-demo", "Hello from RabbitMQ!");
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
//        context.close();
    }
}
