package com.lccode.localstack_aws.sqs.consumer;

import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SqsConsumers {

    @SqsListener("first-queue")
    public void processMessage(FirstQueueMessage message){
        try {
        log.info("First queue received message: [{}]", message.content());

        }catch (RuntimeException e) {
            throw new RuntimeException();
        }
    }

}
