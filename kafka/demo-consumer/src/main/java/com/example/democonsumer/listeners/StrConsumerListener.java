package com.example.democonsumer.listeners;

import com.example.democonsumer.custom.StrConsumerCustomListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class StrConsumerListener {

    @StrConsumerCustomListener(groupId = "group-1")
    public void create(String message){
       log.info("CREATE ::: message{}", message);
    }

    @StrConsumerCustomListener(groupId = "group-1")
    public void log(String message){
        log.info("LOG ::: message{}", message);
    }


    @KafkaListener(groupId = "group-2", containerFactory = "validMessageContainerFactory")
    public void history(String message){
        log.info("HISTORY ::: message{}", message);
    }

}
