package ru.amin.kafkaserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.amin.kafkaserver.dto.MessageDto;
import ru.amin.kafkaserver.service.MessageService;

@RestController
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public void send(@RequestBody MessageDto dto) {
        messageService.send(dto);
    }
}
