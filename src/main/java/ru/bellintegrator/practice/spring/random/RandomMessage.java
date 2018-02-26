package ru.bellintegrator.practice.spring.random;

import ru.bellintegrator.practice.spring.Message;

import java.util.UUID;

/**
 * Случайно сгенерированное сообщение
 */
public class RandomMessage implements Message {

    @Override
    public String value() {
        return UUID.randomUUID().toString();
    }
}
