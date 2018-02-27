package ru.bellintegrator.practice.spring.random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import ru.bellintegrator.practice.spring.Message;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

/**
 * Случайно сгенерированное сообщение
 */
public class RandomMessage implements Message {
    private final Log log = LogFactory.getLog(getClass());

    private final String message;

    public RandomMessage() {
        message = UUID.randomUUID().toString();
    }

    @Override
    public String value() {
        return message;
    }

    @PostConstruct
    private void init() {
        log.info("RandomMessage INIT");
    }

    @PreDestroy
    private void destroy() {
        log.info("RandomMessage DESTROY");
    }
}
