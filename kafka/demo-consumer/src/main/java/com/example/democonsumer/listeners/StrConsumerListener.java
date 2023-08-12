package com.example.democonsumer.listeners;

import com.example.democonsumer.custom.StrConsumerCustomListener;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class StrConsumerListener {

    @SneakyThrows
    @StrConsumerCustomListener(groupId = "group-1")
    public void create(String message){
        try{
            log.info("CREATE ::: message{}", message);
        } catch (Exception ex){
            throw new IllegalArgumentException("EXCEPTION...");
        }

    }

    @SneakyThrows
    @StrConsumerCustomListener(groupId = "group-1")
    public void log(String message){
        try{
        log.info("LOG ::: message{}", message);
        } catch (Exception ex){
            throw new IllegalArgumentException("EXCEPTION...");
        }
    }

    @SneakyThrows
    @KafkaListener(groupId = "group-2", topics = "str-topic" ,containerFactory = "validMessageContainerFactory")
    public void history(String message){
        try{
            log.info("HISTORY ::: message{}", message);
        } catch (Exception ex){
            throw new IllegalArgumentException("EXCEPTION...");
        }
    }

}
