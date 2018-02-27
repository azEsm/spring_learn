package ru.bellintegrator.practice.spring.random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import ru.bellintegrator.practice.spring.GreetingService;
import ru.bellintegrator.practice.spring.Message;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public abstract class RandomGreetingService implements GreetingService {
    private final Log log = LogFactory.getLog(getClass());

    @Override
    public String hello() {
        return randomMessage().value();
    }

    protected abstract Message randomMessage();

    @PostConstruct
    private void init() {
        log.info("RandomGreetingService INIT");
    }

    @PreDestroy
    private void destroy() {
        log.info("RandomGreetingService DESTROY");
    }
}
