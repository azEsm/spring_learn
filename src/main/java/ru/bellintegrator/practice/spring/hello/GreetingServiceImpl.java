package ru.bellintegrator.practice.spring.hello;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import ru.bellintegrator.practice.spring.GreetingService;
import ru.bellintegrator.practice.spring.Message;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class GreetingServiceImpl implements GreetingService {
    private final Log log = LogFactory.getLog(getClass());

    private final Message message;

    public GreetingServiceImpl(Message message) {
        this.message = message;
    }

    @Override
    public String hello() {
        return message.value();
    }

    @PostConstruct
    private void init() {
        log.info("GreetingServiceImpl INIT");
    }

    @PreDestroy
    private void destroy() {
        log.info("GreetingServiceImpl DESTROY");
    }
}
