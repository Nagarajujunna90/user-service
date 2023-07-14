/*
package com.emandi.customerservice.kafka;

import org.springframework.stereotype.Component;

@Component
public class KafkaListener {
    private  final String CREATE_USER="${spring.kafka.topics.createUser}";
    private final String GROUP_ID="${spring.kafka.consumer.groupId}";


    @org.springframework.kafka.annotation.KafkaListener(topics = CREATE_USER, groupId = GROUP_ID)
    public void listen(String message) {
        System.out.println("Received Messasge in group - group-id: " + message);
    }

}
*/
