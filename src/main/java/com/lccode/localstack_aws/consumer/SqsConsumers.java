package com.lccode.localstack_aws.consumer;

import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SqsConsumers {

    @SqsListener("first-queue")
    public void listen(FirstQueueMessage message){
        System.out.println(("First queue received: {}" + message.content()));
    }
}
