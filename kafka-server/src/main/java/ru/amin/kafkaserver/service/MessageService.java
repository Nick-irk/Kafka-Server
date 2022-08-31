package ru.amin.kafkaserver.service;

import ru.amin.kafkaserver.dto.MessageDto;

public interface MessageService {

    MessageDto save(MessageDto dto);

    void send(MessageDto dto);

    void consume(MessageDto dto);
}
