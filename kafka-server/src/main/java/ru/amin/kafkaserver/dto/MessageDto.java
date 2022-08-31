package ru.amin.kafkaserver.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MessageDto extends AbstractDto {

    private String name;

    private String model;
}
