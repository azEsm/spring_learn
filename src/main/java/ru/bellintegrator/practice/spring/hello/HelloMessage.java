package ru.bellintegrator.practice.spring.hello;

import ru.bellintegrator.practice.spring.Message;

/**
 * Сообщение приветствия
 */
public class HelloMessage implements Message {

    @Override
    public String value() {
        return "Hello";
    }
}
