package com.lccode.localstack_aws.sqs;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.CreateQueueRequest;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlRequest;
import software.amazon.awssdk.services.sqs.model.QueueNameExistsException;

@Component
@AllArgsConstructor
@Slf4j
public class SqsSetup implements CommandLineRunner {

    private final SqsClient sqsClient;

    @Override
    public void run(String... args) throws Exception {
        createQueue("first-queue");
    }

    private void createQueue(String queueName) {
        try {
            //Search for an existing queue, if not exists throw an exception
            sqsClient.getQueueUrl(GetQueueUrlRequest.builder()
                    .queueName(queueName)
                    .build());
        } catch (Exception e) {
           log.info("Creating queue: [{}]", queueName);
            try {
                //If queue don't exist, create a queue
                sqsClient.createQueue(CreateQueueRequest.builder()
                        .queueName(queueName)
                        .build());
            } catch (QueueNameExistsException ex) {
                log.warn("Queue [{}] already exists\nDetails: [{}]", queueName, ex.getMessage());
            }
        }
    }
}
