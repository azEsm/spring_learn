package ru.bellintegrator.practice.spring.hello;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import ru.bellintegrator.practice.spring.Message;

/**
 * Сообщение приветствия
 */
public class HelloMessage implements Message {
    private final Log log = LogFactory.getLog(getClass());

    @Override
    public String value() {
        return "Hello";
    }

    private void init() {
        log.info("HelloMessage INIT");
    }

    private void destroy() {
        log.info("HelloMessage DESTROY");
    }
}
