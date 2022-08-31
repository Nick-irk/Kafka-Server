package ru.amin.kafkaserver.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.amin.kafkaserver.dto.MessageDto;

@Service
@Slf4j
public class MessageServiceImpl implements MessageService {

    private final KafkaTemplate<Long, MessageDto> kafkaMessageTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public MessageServiceImpl(KafkaTemplate<Long, MessageDto> kafkaMessageTemplate, ObjectMapper objectMapper) {
        this.kafkaMessageTemplate = kafkaMessageTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public MessageDto save(MessageDto dto) {
        return null;
    }

    @Override
    public void send(MessageDto dto) {
        kafkaMessageTemplate.send("server.message", dto);}

    @Override
    @KafkaListener(id = "Message", topics = {"server.message"}, containerFactory = "singleFactory")
    public void consume(MessageDto dto) {
        log.info("=> consumed {}", writeValueAsString(dto));
    }

    private String writeValueAsString(MessageDto dto) {
        try {
            return objectMapper.writeValueAsString(dto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Writing value to JSON failed: " + dto.toString());
        }
    }
}
