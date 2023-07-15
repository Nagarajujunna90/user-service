package com.emandi.user.kafka;

import org.springframework.stereotype.Component;

@Component
public class KafkaListener {
//    private  final String CREATE_USER="${spring.kafka.topics.createUser}";
//    private final String GROUP_ID="${spring.kafka.consumer.groupId}";


    @org.springframework.kafka.annotation.KafkaListener(topics = "createUser", groupId = "nagaraju",containerFactory = "kafkaListenerContainerFactory")
    public void listen(String message) {
        System.out.println("Received Message in group - group-id: " + message);
    }

}
